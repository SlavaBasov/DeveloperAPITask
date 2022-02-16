# DeveloperAPITask
Simple REST API to make CRUD operations with Developer entity

**What technologies I used on the project**: Java 11, Spring Boot, Spring Data JPA, Embedded H2 Database, Hibernate Validation, Junit 5, Mokito, Poject Lombok, Git.

Reference to description of the API on Open API Specification 3 (Swagger) :
- https://app.swaggerhub.com/apis/SlavaBasov/DeveloperAPITask/1.0.0#/

**Application functionality:**
- operations to create, modify, and find the Developer entity (CRUD-operations).

The entity contains the fields: id, name, email.
Each Developer have a valid unique email address. No two developers have the same email address. 
The ‘name’ Developer’s field allow names with the length of 2 to 50 and should always start with an alphabet.

The database is located in the directory: DeveloperAPITask/src/main/resources/db/Developers.mv.db 
- Username: user   
- Password: password
