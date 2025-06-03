FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN ./gradlew build -x test

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]