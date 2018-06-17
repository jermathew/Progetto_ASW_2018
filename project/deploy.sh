#!/bin/bash
scp -o "StrictHostKeyChecking no" -i asw_key.pem project/restart-service.sh $AWS_USER@$AWS_HOSTNAME:$AWS_DEPLOY_PATH
scp -o "StrictHostKeyChecking no" -i asw_key.pem project/docker-compose.yml $AWS_USER@$AWS_HOSTNAME:$AWS_DEPLOY_PATH
ssh -o "StrictHostKeyChecking no" -i asw_key.pem $AWS_USER@$AWS_HOSTNAME 'bash restart-service.sh'

sleep 300
cd project/sentence-service
gradle endToEndTest
rc=$?; if [[ $rc != 0 ]]; then echo "End-To-End failed"; exit $rc; fi
cd ../..
