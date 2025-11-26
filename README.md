# Spring Boot Backend Training Project

This project was developed during my internship as a preparation step before contributing to the company’s production codebase.

My team leader encouraged me to build a small backend service from scratch so I could practice:
- Spring Boot fundamentals  
- Layered architecture  
- Writing clean and extensible REST APIs  
- Understanding service → repository flow  
- Following enterprise coding conventions  

This training project helped me gain confidence before working on the real airline management system modules.

---

## Features

- RESTful API development  
- CRUD-style endpoints  
- Layered architecture  
  (Controller → Service → Repository)  
- DTO-based request/response modeling  
- Centralized exception handling  
- Maven-based project structure  
- Clean, readable and maintainable class design  
- Basic JUnit test structure  

Although this was a training application, I aimed to structure it as closely as possible to the internal format used by the backend teams.

---

## Tech Stack

- Java 17  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA (basic usage)  
- Maven  
- JUnit  

No database (H2/MySQL/etc.) was used; the goal was to understand backend architecture and API flow, not persistence or DB operations.

---

## Project Structure
```
src/
 ├── main/
 │    ├── java/
 │    │     └── com/
 │    │           └── elifcetinkaya/
 │    │                 └── backendtraining/
 │    │                       ├── BackendtrainingApplication.java
 │    │                       └── member/
 │    │                             ├── Feature.java
 │    │                             ├── FeatureBO.java
 │    │                             ├── FeatureGroup.java
 │    │                             ├── FeatureType.java
 │    │                             ├── Member.java
 │    │                             ├── MemberBO.java
 │    │                             ├── MemberConfig.java
 │    │                             ├── MemberController.java
 │    │                             ├── MemberRepository.java
 │    │                             ├── MemberService.java
 │    │                             └── MemberType.java 
 │    └── resources/
 │          └── application.properties
 └── test/
      └── java/
            └── com/
                  └── elifcetinkaya/
                        └── backendtraining/
                              └── BackendtrainingApplicationTests.java
```
This project follows the standard Spring Boot folder layout.

---

## What I Learned

Working on this backend service helped me:

- Understand how backend layers interact  
- Organize business logic inside service classes  
- Use DTOs to separate internal logic from API models  
- Write cleaner and more maintainable Java code  
- Use Spring annotations effectively  
- Follow enterprise-level project conventions  
- Prepare for real production-level work  

This preparation made it much easier when I later worked on client integration code during my internship, where I implemented internal API calls and request/response structures in the airline management system.

---

## Running the Project
On macOS / Linux:
./mvnw spring-boot:run

On Windows:
mvnw.cmd spring-boot:run

Application will run at:
http://localhost:8080/api/v1/members
