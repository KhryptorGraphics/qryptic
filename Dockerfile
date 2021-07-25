FROM tomcat:jdk16-openjdk-slim
ARG JAR_FILE=build/libs/*.war
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ${JAR_FILE} /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]