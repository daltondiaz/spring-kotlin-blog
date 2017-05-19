package dalton.kotlin.springkotlin

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
// classes and methods in Kotlin are final by default without the open modifier
class SpringKotlinApplication{

    private val log = LoggerFactory.getLogger(SpringKotlinApplication::class.java)

    @Bean
    fun init(repository: CustomerRepository) = CommandLineRunner{
        repository.save(Customer("Jack","Bauer"))
        repository.save(Customer("Chloe","O'Brian"))
        repository.save(Customer("Kim","Bauer"))
        repository.save(Customer("David","Palmer"))
        repository.save(Customer("Michelle","Dessler"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringKotlinApplication::class.java, *args)
}
