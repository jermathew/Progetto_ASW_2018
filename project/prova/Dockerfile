########################################################
# Dockerfile per l'applicazione
########################################################

FROM frolvlad/alpine-oraclejdk8

ADD build/libs/prova-0.0.1-SNAPSHOT.jar hello-world.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "-Dspring.profiles.active=english", "hello-world.jar"]