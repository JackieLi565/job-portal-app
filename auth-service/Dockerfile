FROM tomcat:9.0

ENV MY_CONTEXT=auth-service
COPY ./target/auth-service-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/${MY_CONTEXT}.war

EXPOSE 8080