# Project build a simple blog

I change de goal to create a simple blog, only for add some content.

This project uses a [Kotlin based Gradle](https://blog.gradle.org/kotlin-meets-gradle) configuration, but `build.gradle.kts` auto-complete is currently not available since Kotlin `1.1-M04` IDEA plugin needed for that does not allow to use `kotlin-spring` and `kotlin-jpa` compiler in a reliable way.

Make sure you have at least IntelliJ IDEA 2016.3 and Kotlin plugin 1.0.6 since `kotlin-spring` and `kotlin-jpa` compiler plugins require this version.

## Running

You need install postgresql and the configuration are in **application.properties**

    $ ./gradlew bootRun
    
To run the frontend access que folder /frontend and run:

    $ npm run dev

The port 8081 is backend and 8080 frontend. If everything is okay access http://localhost:8080/

## Tools

- Intellij Communinty Edition, to programming in kotlin
- Visual Studio Code, to programming in js
- DBeaver, to access the database ( For me is the best ide to connection with database in linux)

### Backend

- PostgreSQL to management the database. You can change the database in file application.properties and add your dependence in build.gradle
- Spring Boot
- Kotlin, I want use 100% kotlin in this project, discovery news challenges and improve my knowledge in this language

### Frontend

- Vuejs [https://vuejs.org/]
- Bulma [http://bulma.io/]
- Buefy [https://buefy.github.io]
- Npm

## Tables

- Author: Like a user, but I choice use the name Author
- Post: Its my post, have a author and many hashtags
- Hashtag: Like the owener name [building]

## Routes

For now only home

## License

This project is Apache 2.0 licensed.

## Fonts

 - [Kotlin based Gradle](https://blog.gradle.org/kotlin-meets-gradle)
 - [Developing Spring Boot applications with Kotlin](https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin)



