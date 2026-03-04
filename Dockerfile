# 1. Build Stage
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app
COPY . .

# Fix permission issue for mvnw
RUN chmod +x ./mvnw

# Build project
RUN ./mvnw clean package -DskipTests

# 2. Runtime Stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "app.jar"]