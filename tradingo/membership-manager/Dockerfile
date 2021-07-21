FROM gradle:7.0.0-jdk11 AS build
USER root
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle :membership-manager:build --no-daemon


FROM openjdk:11-jre-slim
USER root
WORKDIR app
EXPOSE 8083


COPY --from=build /home/gradle/src/membership-manager/build/libs/*.jar /app/membership-manager.jar

ENTRYPOINT ["java", "-jar","membership-manager.jar"]
