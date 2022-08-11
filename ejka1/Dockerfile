FROM openjdk:17-alpine@sha256:a996cdcc040704ec6badaf5fecf1e144c096e00231a29188596c784bcf858d05
ENV TOPICNAME topic1
ENV TOPICNAME2 topic2
ENV GROUPID kafkagroup
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kafka-1.0.0.jar
ENTRYPOINT ["java", "-Dtopicname=${TOPICNAME}",  "-Dtopicname2=${TOPICNAME2}", "-Dgroupid=${GROUPID}", "-jar",  "/kafka-1.0.0.jar"]