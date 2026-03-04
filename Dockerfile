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

# EXPOSE fixed port for Docker syntax (Render will map its $PORT)
EXPOSE 8080

# Run Spring Boot on Render assigned port
ENTRYPOINT ["sh","-c","java -jar app.jar --server.port=$PORT"]