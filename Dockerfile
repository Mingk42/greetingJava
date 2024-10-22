# FROM openjdk:8-jdk-alpine
# FROM openjdk:22-ea-11-jdk-slim
# FROM openjdk:17-jdk-alpine AS build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /tmp
COPY . .
RUN ./gradlew clean bootJar

FROM eclipse-temurin:17-jre-alpine AS run
COPY --from=build /tmp/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
