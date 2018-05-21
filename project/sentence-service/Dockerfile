########################################################
# Dockerfile per l'applicazione sentence / word service 
########################################################

FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/sentence-0.0.1-SNAPSHOT.jar sentence.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "sentence.jar"]


