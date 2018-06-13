#!/bin/bash
#scp -o "StrictHostKeyChecking no" -i asw_key.pem project/restart-service.sh $AWS_USER@$AWS_HOSTNAME:$AWS_DEPLOY_PATH
#scp -o "StrictHostKeyChecking no" -i asw_key.pem project/docker-compose.yml $AWS_USER@$AWS_HOSTNAME:$AWS_DEPLOY_PATH
#ssh -o "StrictHostKeyChecking no" -i asw_key.pem $AWS_USER@$AWS_HOSTNAME 'bash restart-service.sh'

#Aspetto 5 minuti e controllo
#sleep 300
curl -s "http://${AWS_HOSTNAME}:8080/sentence" | awk '{n=split($0, array, " "); if (n==3) {exit 0;} else {exit 1;}}'

