#!/bin/bash

docker build --rm -t vmartello95/eureka-server-img ./eureka-server 
docker build --rm -t vmartello95/word-img ./word-service 
docker build --rm -t vmartello95/sentence-img ./sentence-service
docker build --rm -t vmartello95/zuul-img ./zuul

docker push vmartello95/eureka-server-img







