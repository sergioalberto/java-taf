# Base Automation Framework
Here you can find a base automation framework architecture using Java and Selenium.

### Current environment (tested)
- Ubuntu 18.04.1
- Google Chrome 76.0.3809
- ChromeDriver 76.0.3809.126
- Firefox 68.0.2 (64-bit)
- Geckodriver 0.24.0 ( 2019-01-28)
- Microsoft Edge 44.18362.267.0
- IEDriverServer.exe 3.4.0.0 (64-bit)
- Java 8 openjdk amd64
- Apache Maven 3.6.0
- Editor: Spring Tool Suite 3.9.8

## Running the automation locally
* You just need to create a `testng.xml` file and customize your tests that want to execute
* Create a build of the project (`mvn install`)
* To run it, from your favorite Editor, right click on the `testng.xml` file, `Run As` -> `TestNG Suite`.

##### Note:
You need to install `TestNG` package, in your favorite editor.

## Running the automation locally but using Selenium drivers on docker
```
mvn clean package
```
```
docker-compose up -d selenium-hub chrome
```
```
java -cp target/selenium-docker.jar:target/selenium-docker-tests.jar:target/libs/* -DseleniumHubHost=localhost org.testng.TestNG smoke.xml
```
```
docker-compose down
```

## Running with docker
```
make build
```

```
make run
```

```
make clean
```
##### Note:
Open some VNC client and go to `localhost:5900` to see your tests running inside the container (the password is `secret`)
