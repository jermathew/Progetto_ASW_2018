#!/bin/bash

#Build eureka
echo 'building eureka server ...'
gradle build -b eureka-server/build.gradle --build-cache -x test
rc=$?; if [[ $rc != 0 ]]; then echo "Build eureka-server failed"; exit $rc; fi

#Build word-service
echo 'building word service ...'
gradle build -b word-service/build.gradle --build-cache -x test
rc=$?; if [[ $rc != 0 ]]; then echo "Build word-service failed"; exit $rc; fi

#Build sentence-service
echo 'building sentence service ...'
gradle build -b sentence-service/build.gradle --build-cache	-x test
rc=$?; if [[ $rc != 0 ]]; then echo "Build sentence-service failed"; exit $rc; fi

#Build zuul
echo 'building zuul ...'
gradle build -b zuul/build.gradle --build-cache	-x test
rc=$?; if [[ $rc != 0 ]]; then echo "Build zuul failed"; exit $rc; fi