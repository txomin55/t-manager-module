FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY prueba-loader/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]