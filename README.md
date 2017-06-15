# Project build a simple blog

I change de goal to create a simple blog, only for add some content.

This project uses a [Kotlin based Gradle](https://blog.gradle.org/kotlin-meets-gradle) configuration, but `build.gradle.kts` auto-complete is currently not available since Kotlin `1.1-M04` IDEA plugin needed for that does not allow to use `kotlin-spring` and `kotlin-jpa` compiler in a reliable way.

Make sure you have at least IntelliJ IDEA 2016.3 and Kotlin plugin 1.0.6 since `kotlin-spring` and `kotlin-jpa` compiler plugins require this version.

## Running

    $ ./gradlew bootRun

## Tools

### Backend
- PostgreSQL to management the database
- Spring boot
- Kotlin, I want use 100% kotlin in this project, discovery news challenges and improve my knowledge in this language

### Frontend

- Vuejs [building]
- Nodejs [building] I'm thinking and searching about that

## Tables

- Author: Like a user, but I choice use the name Author
- Post: Its my post, have a author and many hashtags
- Hashtag: Like the owener name

## Routes

Later I'll describe

## License

This project is Apache 2.0 licensed.

## Fonts

 - [Kotlin based Gradle](https://blog.gradle.org/kotlin-meets-gradle)
 - [Developing Spring Boot applications with Kotlin](https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin)



