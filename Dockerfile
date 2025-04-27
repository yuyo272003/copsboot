# Etapa de construcción
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copia sólo los ficheros de configuración para cachear dependencias
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN mvn dependency:go-offline -B

# Copia el resto del código y compila
COPY src src
RUN mvn package -DskipTests -B

# Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos el JAR construido
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto que configura Spring Boot
EXPOSE 8888

# Arrancamos la aplicación
ENTRYPOINT ["java","-jar","app.jar"]
