#
# Build stage
#
FROM maven:3.6.2-jdk-8-openj9 AS build  
COPY src /usr/src/module/src  
COPY pom.xml /usr/src/module  
RUN mvn -f /usr/src/module/pom.xml clean package -Pproduction-in-memory

#
# Package stage
#
FROM gcr.io/distroless/java:8  
LABEL maintainer="txomin.sirera@gmail.com"
LABEL version="1.0"
VOLUME /tmp/module
COPY --from=build /usr/src/module/target/*.jar /usr/module/app.jar  
EXPOSE 8002  
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production-in-memory", "/usr/module/app.jar"]