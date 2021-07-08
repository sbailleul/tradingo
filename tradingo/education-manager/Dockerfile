FROM gradle:7.0.0-jdk11 AS build
USER root
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle :education-manager:build --no-daemon


FROM openjdk:11-jre-slim
USER root
WORKDIR app
EXPOSE 8080


COPY --from=build /home/gradle/src/education-manager/build/libs/*.jar /app/education-manager.jar

ENTRYPOINT ["java", "-jar","education-manager.jar"]
