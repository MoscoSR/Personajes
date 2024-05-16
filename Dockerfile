FROM ubuntu:latest
LABEL authors="santiago.mosquera"
ENTRYPOINT ["top", "-b"]

# Usar la imagen base de OpenJDK
FROM openjdk:11

# Copiar el archivo application.properties al directorio /app dentro del contenedor
COPY src/main/resources/application.properties /app/application.properties

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar los archivos compilados de tu aplicación Java al directorio /app
COPY .mvn/wrapper/maven-wrapper.jar  /app/demo.jar

# Comando para ejecutar la aplicación Java
CMD ["java", "-jar", "demo.jar"]
