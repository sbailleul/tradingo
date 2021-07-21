FROM gradle:7.0.0-jdk11 AS build
USER root
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle :generic-client:build --no-daemon


FROM openjdk:11-jre-slim
USER root
WORKDIR app
EXPOSE 8081


COPY --from=build /home/gradle/src/generic-client/build/libs/*.jar /app/generic-client.jar

ENTRYPOINT ["java", "-jar","generic-client.jar"]
