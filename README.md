# Project build a simple blog

The main idea from this project is put together some concepts like RESTFull, 
authentication by Json Web Token, separate the development the backend and frontend and some other things.

The backend use Kotlin and frontend Vuejs.

## Running

This project uses a [Kotlin based Gradle](https://blog.gradle.org/kotlin-meets-gradle) 
configuration, but `build.gradle.kts` auto-complete is currently not available since 
Kotlin `1.1-M04` IDEA plugin needed for that does not allow to use `kotlin-spring` 
and `kotlin-jpa` compiler in a reliable way.

Make sure you have at least IntelliJ IDEA 2016.3 and Kotlin plugin 1.0.6 since 
`kotlin-spring` and `kotlin-jpa` compiler plugins require this version.

You need install postgresql and the configuration are in **application.properties**

    $ ./gradlew bootRun
    
To run the frontend access que folder /frontend and run:

    $ npm run dev

The port 8081 is backend and 8080 frontend. If everything is okay access http://localhost:8080/

## Tools

- [Intellij Communinty Edition](https://www.jetbrains.com/idea/download), to programming in kotlin
- [Visual Studio Code](https://code.visualstudio.com/), to programming in js
- [DBeaver](https://dbeaver.jkiss.org/), to access the database ( For me is the best ide to connection with database in linux)

## Backend

- PostgreSQL to management the database. You can change the database in file application.properties and add your dependence in build.gradle
- Spring Boot
- Kotlin, I want use 100% kotlin in this project, discovery news challenges and improve my knowledge in this language
- Jwt Authentication between backend and frontend, the responsible for this is Spring Security.

## Frontend

- Vuejs [https://vuejs.org/]
- Bulma [http://bulma.io/]
- Buefy [https://buefy.github.io]
- Npm

## Tables

- Author: Like a user, but I choice use the name Author
- Post: Its my post, have a author and many tags
- Tag: One post can be one or more tags
- Role: Each Author has one or more role for now can be Standard User and Administrator

## Routes

For now only home

## Future

- Run Backend and Frontend each one in a container

## License

This project is Apache 2.0 licensed.

## Resources

 - [Kotlin based Gradle](https://blog.gradle.org/kotlin-meets-gradle)
 - [Developing Spring Boot applications with Kotlin](https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin)
 - [Secure a Spring Boot REST API With JSON Web Token + Reference to Angular Integration](https://medium.com/@nydiarra/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50)
 - [Vuejs](https://vuejs.org/)



