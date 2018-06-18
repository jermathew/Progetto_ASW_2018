#!/bin/bash

#Build eureka
gradle build -b eureka-server/build.gradle --build-cache -x integrationTest
rc=$?; if [[ $rc != 0 ]]; then echo "Build eureka-server failed"; exit $rc; fi

#Build word-service
gradle build -b word-service/build.gradle --build-cache -x integrationTest 
rc=$?; if [[ $rc != 0 ]]; then echo "Build word-service failed"; exit $rc; fi


#Build sentence-service
gradle build -b sentence-service/build.gradle --build-cache -x integrationTest -x endToEndTest
rc=$?; if [[ $rc != 0 ]]; then echo "Build sentence-service failed"; exit $rc; fi


#Build zuul
gradle build -b zuul/build.gradle --build-cache
rc=$?; if [[ $rc != 0 ]]; then echo "Build zuul failed"; exit $rc; fi
