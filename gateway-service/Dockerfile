FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -DskipTests=true -f /home/app/pom.xml clean package

FROM openjdk:11-jdk
USER root
WORKDIR /opt/app
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build ${JAR_FILE} /opt/app/gateway-service.jar
ENTRYPOINT ["java","-jar","gateway-service.jar"]
ARG DISC_SERVER_IP
ENV DISC_SERVER_IP=$DISC_SERVER_IP
EXPOSE 8080
