FROM fabric8/java-jboss-openjdk8-jdk:1.2.1

ENV JAVA_APP_JAR tutorial-swarm.jar
ENV AB_ENABLED off
ENV JAVA_OPTIONS -Xmx512m

EXPOSE 8080

ADD target/tutorial-swarm.jar /deployments/
