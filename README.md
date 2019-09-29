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

## Run application
* Restore the DB and WP file volumes:
- `docker run -v java-taf_db_data:/volume -v $(pwd):/backup --rm loomchild/volume-backup restore db_wp_backup`
- `docker run -v java-taf_wp_files:/volume -v $(pwd):/backup --rm loomchild/volume-backup restore wp_files_backup`
- `docker-compose up -d wordpress`
- Wait until the app runs, and load this in your browser: http://localhost:8000/

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
- Open some VNC client and go to `localhost:5900` to see your tests running inside the container (the password is `secret`)
- Since this is a dummy site, I'm publicly sharing the following:
   * User/Password: `automation/automation`
   * Consumer key: `ck_747561c1957b4d5e9c4ba174397365f9bdf43ab7`
   * Consumer secret: `cs_ae256b8de43dd771568cab572c8c135b11ff21f3`
- These are the commands used to create the volume backups:
   * `docker run -v java-taf_db_data:/volume -v $(pwd):/backup --rm loomchild/volume-backup backup db_wp_backup`
   * `docker run -v java-taf_wp_files:/volume -v $(pwd):/backup --rm loomchild/volume-backup backup wp_files_backup`
- Also, if you want to destroy (containers, images and volumes) and then recreate this just use the commands below:
   * `docker-compose down --rmi all`
   * `docker volume prune`
