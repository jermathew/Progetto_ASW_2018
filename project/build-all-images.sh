#!/bin/bash
docker build --rm -t vmartello95/eureka-server ./eureka-server 
docker push vmartello95/eureka-server

docker build --rm -t vmartello95/word ./word-service 
docker push vmartello95/word

docker build --rm -t vmartello95/sentence ./sentence-service
docker push vmartello95/sentence

docker build --rm -t vmartello95/zuul ./zuul
docker push vmartello95/zuul









