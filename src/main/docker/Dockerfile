FROM java:8-jre-alpine
VOLUME /tmp
ADD servicecomb_base-0.0.1-SNAPSHOT.jar app.jar
ENV LANG C.UTF-8
ENTRYPOINT ["java","-Xmx2048m","-Xms512m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
