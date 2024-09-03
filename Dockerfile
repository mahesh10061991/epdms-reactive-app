FROM openjdk:21
LABEL maintainer = "SourceFuse"
ADD target/epdms-reactive-app-0.0.1-SNAPSHOT.jar epdms-reactive-app.jar
ENTRYPOINT ["java","-jar","epdms-reactive-app.jar"]