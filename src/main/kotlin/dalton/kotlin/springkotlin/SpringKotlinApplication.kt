package dalton.kotlin.springkotlin

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
// classes and methods in Kotlin are final by default without the open modifier
class SpringKotlinApplication{

    private val log = LoggerFactory.getLogger(SpringKotlinApplication::class.java)

}

fun main(args: Array<String>) {
    SpringApplication.run(SpringKotlinApplication::class.java, *args)
}
