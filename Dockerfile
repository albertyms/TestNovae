FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
ADD target/NovaeTest-0.0.1-SNAPSHOT.jar NovaeTest-0.0.1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/NovaeTest-0.0.1.jar"]