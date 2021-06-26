## Floow platform technical challenge project

**================ Editor log =================**
|Date|Author|Description|Version|
|----|----|----|----|
|25/06/2021|Daolin Sheng|Create and implement the project|0.0.1|


### Table of Contents
- **Objectives**
- **Install and run on local**
- **The APIs of Function**
- **Develop environment and Technology Stack**
- **The structure of project**
- **Testing with Swagger2**
- **Testing with Postman**



### Objective:
> The objective of this challenge is to create a simple REST service that will manage details of drivers for use
within a hypothetical insurance service. For the purposes of this challenge, a driver record consists of the
following information:
- A unique ID for the driver
- Fisrt Name
- Last Name
- Date of Birth
- Creation Date

Details of drivers should be stored in a simple flat file. You may store dates in any format you wish.

### Install and run on local

> git clone https://github.com/linksdl/floow-platform-technical-project.git
> cd .../loow-platform-technical-project/bin
> run command `java -jar floow-project-0.0.1-SNAPSHOT.jar`
> the run result on local
![image](images/run%20on%20local.png)


### The APIs of Function
> The APIs for Driver operations in a SpringBoot

|Operation|Path| Description|
|----|----|----|
|POST|/drive  | An POST endpoint to allow new drivers to be created and stored. |
|GET |/drives | A GET endpoint which returns a list of all existing drivers in JSON format.|
|GET |/drivers/byDate?date=<date>|A GET endpoint which returns a list of all drivers created after the specified date. Again, the list should be returned in JSON format. Again, the date parameter should use the format YYYY-MM-DD.|


### Develop environment and Technology Stack
#### Development evironment
- Mac OS
- IntelliJ IDEA
- JDK 1.8

#### Technology Stack
- Java 8
- Maven 3.6.3
- Swagger2
- Postman
- Springboot 2.5.2
- Spring Validation
- Slf4j
- JSON (fastJson, Jackson)
- Junit
- Springboot test
- Mockito

### The structure of project
/src/main/java/com/floow/challenge/web
  - /onfig
     - SwaggerConfig.java # config swagger2 
  - /controller
     - DriverController.java # Controller
  - /domain
     - Driver.java     # Driver Entity
  - /exception
     - BusinessException.java  
     - ExceptionEnum.java
     - GlobalExceptionHandler.java
  - /repository
     - DatabaseLoader.java  # load data sources from Json file
     - DriverDao.java       #
  - /service
     - IDriverService       # the interface of DriverService
     - /impl
        - DriverServiceImpl
  - /utils
  - FloowProjectApplication.java
  
/src/main/resources
  - application.yml  # Springboot global config file
  - driver.json      # the file for storage the driver data
  
/src/test/java/com/floow/challenge/web
  - /service
     - RegisterDriverCase.java
  - DriverUseCaseTest.java      # Unit test with Junit
  - DriverUseCaseTest2.java     # Unit test with Mockito

### Testing with Swagger2
- Overview of the Swagger2
> http:<localhost>:8080/floow/swagger-ui.html
![image0](images/0-overview.png)

- Create or add one driver
> POST http://localhost:8080/floow/api/v1/driver
![image1](images/1-create%20driver-0.png) 
![image1](images/1-create%20driver-1.png)        
 
- Find all drivers
> GET http://localhost:8080/floow/api/v1/drivers
![image2](images/2-find%20all.png)

- Find all drivers by Date (creation date)
> http://localhost:8080/floow/api/v1/drivers/byDate?date=<Date>
![image3](images/3-find%20all%20by%20date.png)

### Testing with Postman
- Create or add one driver
> POST http://localhost:8080/floow/api/v1/driver
![image4](images/postman-0-create%20driver.png)       
 
- Find all drivers
> GET http://localhost:8080/floow/api/v1/drivers
![image5](images/postman-1-finall.png)

- Find all drivers by Date (creation date)
> http://localhost:8080/floow/api/v1/drivers/byDate?date=<Date>
![image6](images/postman-2-finall%20by%20date.png)


