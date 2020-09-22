# Healthometer Application

## Scope
The scope of this project is to provide a clean and simple architecture in order to build enterprise applications using as a main tool Spring Boot

The main technologies used in this application are:
* Java 8+
* Maven
* Spring MVC
* Spring Profiles
* Spring Security
* Spring Data JPA
* JPA/Hibernate
* Lombok
* Mapstruct
* Flyway
* H2

## Structure 
This project is organized as a maven multimodule composed in:
* healthometer-commons (this module contains common libraries and clases)
* healthometer-core (this module contain main logic)

## Run
To run this application go to the main folder healthometer and execute:
./mvnw install -Dlogging.level.root=error && ./mvnw spring-boot:run -pl healthometer-core

## Use H2 Console Application
http://localhost:8081/h2-console

## Swagger UI
http://localhost:8081/swagger-ui.html

## Access
To login into the application you should get a jwt token through AuthRestController 
There are 2 users:
* username=user, password=password and with the role of user
* username=admin, password=password and with the role of admin

you should check SecurityConfig in order to add/remove access to rest endpoints.

## Task 1 
Provide tests(keep in mind providing also edge cases) for all methods exposed in UserRestController class in healthometer-core module (you should modify UserRestControllerTest class)

## Task 2
Create e new feature that tracks the activities of the person in time.
* your feature should be located in al.ikubinfo.healthometer.activity 
* follow the same code structure of the package users

The person preferably each day should insert from a set of activities:
* today date
* food (how many calories)
* water quantity (how many ml per day)
* physical activity (what activity & how many calories spent)
* no activity

Keep in mind that a user has a lot of activities and an activit belongs to a single user.






