FROM openjdk:11-jre

COPY target/quartz-schedulable-task-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "quartz-schedulable-task-0.0.1-SNAPSHOT.jar"]