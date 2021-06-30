# Student Registration Assistant (SRA)
Back-end for a Student Registration Assistant web-app created in Spring Boot

## Initialization
- If a new project is being created, it is recommended to create new Spring Project via [Spring Initializer](https://start.spring.io/), using Maven, Java, JAR 8, Spring 2.5.2 and initial dependencies as Spring Web, Spring Data JPA, and MS SQL Server Driver.
- Added JAR files can be removed from the project structure if a version of Java later than 8 is installed.
- All source code is included, launching the src folder via an IDE such as IntelliJ should automatically install all required dependencies.
- Database SQL connection can be set up based on however the schema is utilized. In our case, for example, an integrated connection was used, thus bypassing the need to provide authorization credentials.

## Running
- Once all relevant dependencies are installed, the SraApplication.java file is to be launched. It is contained in the following path: sra\src\main\java\com\example\sra
- The port 8090 is being used to service outside requests, such as those from our front-end.
- If ports are correctly forwarded, any web address with "api/v1/<api call>" appended to it should work
- All API call routes are located in the controller classes in the packages located in the following path: sra\src\main\java\com\example\sra
