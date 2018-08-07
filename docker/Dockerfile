FROM java:openjdk-8-jre
VOLUME /properties
VOLUME /logdir
ADD oauth-server-db-example.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar  --spring.config.location=/properties/application.properties" ]