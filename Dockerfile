FROM openjdk:11-jre-slim
COPY target/health-0.0.1-SNAPSHOT.jar health.jar
ENTRYPOINT ["java","-jar","/health.jar"]