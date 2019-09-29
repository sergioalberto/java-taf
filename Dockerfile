FROM java:8
FROM maven:alpine

WORKDIR /app
COPY . /app

RUN mvn -v

RUN mvn clean package

# Add the suite xmls
ADD smoke.xml /app/smoke.xml

# Command line to execute the test
# Expects below ennvironment variables
# MODULE  = smoke-module

ENTRYPOINT java -cp /app/target/selenium-docker.jar:/app/target/selenium-docker-tests.jar:/app/target/libs/* -DseleniumHubHost=$SELENIUM_HUB org.testng.TestNG $MODULE
