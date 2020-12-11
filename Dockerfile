FROM openjdk:11-jre-slim
COPY deliveryMoment-CRUD-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar","app.jar"]
EXPOSE 8080
