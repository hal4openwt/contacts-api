## Description
The root project was generated with the [Swagger Codegen CLI](https://github.com/swagger-api/swagger-codegen) module using a yaml OpenAPI description of the API. 

### Relevant files in the root directory
* `contacts-api.yml`: OpenAPI definition of the API
* `contact-api-config.json`: Configuration file for swagger-codegen-cli
* `codegen`: Bash script used to run the code generator

### Directories
* `swagger-codegen/`: Contains the git repository for the swagger code generator (v2.4.10 is used). Built using `mvn clean package`.
* `db/`: Contains the docker compose yaml configuration for the used PostgreSQL DB server.
* `spring-server/`: Contains the generated spring project.

## Build and run

1. Start the Docker PostgreSQL DB Server:
```
cd db
docker-compose up
```
2. Start the server:
```
cd spring-server
mvn clean package spring-boot:run
```
or

```
cd spring-server
mvn clean package
java -jar target/contact-api-0.0.1-SNAPSHOT.jar
```
## Connect to the API and the DB

* The API **swagger UI** is accessible at http://localhost:8080/api/v1/
* The **DB** can be explored using [Adminer](https://www.adminer.org/) at http://localhost:8081/
	* **System**: PostgreSQL
	* **Server**: db
	* **Username**: admin
	* **Password**: pa55w0rd

