#
# Build stage
#
FROM maven:3.6.2-jdk-8-openj9 AS build  
COPY pom.xml /usr/tmanager/module/pom.xml
COPY lombok.config /usr/tmanager/module/lombok.config
COPY module-domain/ /usr/tmanager/module/module-domain/  
COPY module-application/ /usr/tmanager/module/module-application/
COPY module-infrastructure/ /usr/tmanager/module/module-infrastructure/
COPY module-frontend/ /usr/tmanager/module/module-frontend/
COPY module-web/ /usr/tmanager/module/module-web/
COPY module-loader/ /usr/tmanager/module/module-loader/

RUN mvn -f /usr/tmanager/module/pom.xml clean install -Pkubernetes-in-memory -DskipTests

#
# Package stage
#
FROM gcr.io/distroless/java:8  
LABEL maintainer="txomin.sirera@gmail.com"
LABEL version="1.0"
VOLUME /tmp/tmanager/module
COPY --from=build /usr/tmanager/module/module-loader/target/*.jar /usr/tmanager/module/compiled/app.jar  
EXPOSE 8002  
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=kubernetes-in-memory", "/usr/tmanager/module/compiled/app.jar"]