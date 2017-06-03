# Spring Boot Kotlin

This is a simple application used to learning Spring together with Kotlin. Its compose by Spring Web and Data, H2 Database (only needed put the dependency in the build.gradle). The tutorial base was https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin
You can launch the application with by running:

		$ ./gradlew bootRun

Make sure you have at least IntelliJ IDEA 2016.3 and Kotlin plugin 1.0.6 since `kotlin-spring` and `kotlin-jpa` compiler plugins require this version.

This project uses a [Kotlin based Gradle](https://blog.gradle.org/kotlin-meets-gradle) configuration, but `build.gradle.kts` auto-complete is currently not available since Kotlin `1.1-M04` IDEA plugin needed for that does not allow to use `kotlin-spring` and `kotlin-jpa` compiler in a reliable way.

This project is Apache 2.0 licensed.

## Mongo DB

For more study I resolve to use mongoDB with Kotlin, but without using new framework so I add the dependencie:

     compile("org.springframework.boot:spring-boot-starter-data-mongodb")

So I create a documento called Data with some fields only for test, I use 

    interface DataRepository : MongoRepository<Data,String>
    
So simple and one controller for request the data who I added.
