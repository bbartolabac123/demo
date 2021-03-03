FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
EXPOSE 8080
ADD build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]