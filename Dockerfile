FROM openjdk:8
ADD target/energybot-docker.jar energybot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "energybot-docker.jar"]
