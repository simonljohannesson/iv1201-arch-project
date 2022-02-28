# iv1201-arch-project

This is a project in the course iv1201 at kth.

## [Backlog](https://github.com/simonljohannesson/iv1201-arch-project/projects/1)

## Decision log

### 2022-01-26 Github should be used

All developers in team has experience with Github and it is commonly used.

### 2022-01-26 Should try to use one single git repository

The whole project can be accessed from a single place. If we decide to use microservices it could be easier to keep them in the same place, but no decision has been taken regarding microservices yet.

### 2022-01-26 Decision log should be in the projects git repository

It is easy for everyone to access the information.

### 2022-01-26 The branch master will not be locked from pushing directly

When working together it can be cumbersome to create a symbolic pull request which will be accepted without formal review. Everyone in the team has experience with working with git and github so the risk is considered minimal.

### 2022-01-28 REST API should be used

Requirement specification says that a mobile app should be developed in the future, so to secure the project for this it is deemed best to produce a backend that supports platform independent frontends on client side.

### 2022-01-28 Java Spring Boot

* Java is a well known language so it should be easy to find competent developers in the future, all developers in the team knows it well.
* Learning a new language is not feasable considering the short time span of the project.
* Javascript was considered but it is not typed so it can be difficult to maintain, the team also has less knowledge about the available frameworks for backend development.
* Java Spring Boot is widely used, well documented and allows for faster initial development compared to for example Spring MVC.
* Commonly used for building REST APIs.
* Allows for building decoupled modules.
* Handover requirement, since Spring Boot is commonly used it is suitable to use since developers with experience from the actual framework or even similar frameworks more easily will be able to understand it than others that may be more obscure.

### 2022-01-28 JPA should be used for object to relational mapping

Object to relational mapping can be used to abstract away the SQL from the application and thus if used correctly will increase the speed of development. At least in theory. JPA, is commonly used.

### 2022-01-28 PostgreSQL is chosen to be the database

* JPA has support
* Dialect is not believed to have great importance initially
* Maps directly with the previous database
* Since data is highly structured and being able to query the database may be important it is deemed that using a document based database is not suitable.

### 2022-01-28 Docker should be used for development and deployment of the backend and frontend

* Well supported for Spring Boot
* Easy to use with Vue projects
* Desired since it makes sure that all developers use the same environment for development
* Cloud solution agnostic

### 2022-01-28 Vue + Bootstrap should be used for frontend

* All developers in team have experience with vue
* Bootstrap works well with Vue and makes development fast with pre-canned components
* Bootstrap makes it easy to support all major browers according to the requriement specification
* Both frameworks commonly used and easily understood makes for easier handover according to the requirement specification.

### 2022-01-28 Documentation backend

* The REST API should be documented
* Javadoc should be used to document all public definitons in the backend.

### 2022-02-02 Maven should be used as a build tool for the backend.
Big community, a lot documentation, often used in tutorials, team has some experience. Config files are verbose to a point where it is easy to understand what is going on which the team sees as a positive. Gradle was considered, but the energy needed to learn a new tool would be better spent on something else.

### 2022-02-02 Backend should be monolith.
The team wanted to create the backend using microservices but considering the added complexity, it appears that there are limited perks for the application if microservices is chosen. Creating the backend as a monolith is likely to take a lot less time and should be easier to maintain and understand if the requirement specification will remain somewhat static for a long time.

### 2022-02-02 Team will use Github Projects to organize tasks and work
It is simple and similar to how the team has worked in the passed, and it allows the team to keep all information in the same place (github).


### 2022-02-10 Controller endpoints should only expose DTOs not DAOs. And DTOs containing critical security information should be explicitly named for their purpose.
For example when creating a user the dto could be named UserCreateDTO


### 2022-02-10 Vue dependencies
* Eslint with standard configuration, this will enable us to conform to a coding style without having to worry about it when we write code. This can be further configured to add more rules as we see necessary. Will be setup so linting is done on save, no risk of forgetting to lint project before commits.
* Babel, will allow us to write the lates JS which then compiles down to a target version of JS. Enabling more support without having to think about JS compability when writing code.
* Bootstrap see earlier decision.
* Jest, testing library that comes package with Vue during setup hence works good with Vue. 

### 2022-02-10 Vue project structuring
Conforming to Vue project structuring help both new developers starting on the project and keep a good seperation in the code.  

### 2022-02-14 RestAPI naming convention should follow this [guide](https://restfulapi.net/resource-naming/).

### 2022-02-14 Keep `/applicants` and `/recruiters` endpoints under `/users` endpoint
To enforce coherence and for future functionality changes, keep all user related endpoints under `/users` endpoint.

### 2022-02-14 Add table for application status
To keep track of an applications status, add a table in the database. 

### 2022-02-28 Everything should be `@Transactional` and services should force transactions
With some possible loss in performance we will instead prevent weird behaviour and bugs created by potential faulty database calls
