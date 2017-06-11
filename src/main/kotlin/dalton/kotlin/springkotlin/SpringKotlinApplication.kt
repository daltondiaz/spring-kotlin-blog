package dalton.kotlin.springkotlin

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
// classes and methods in Kotlin are final by default without the open modifier
class SpringKotlinApplication{

    private val log = LoggerFactory.getLogger(SpringKotlinApplication::class.java)

    /*@Bean
    fun init(repository: DataRepository) = CommandLineRunner{

        repository.deleteAll()*/
        /*repository.save(Customer("Jack","Bauer"))
        repository.save(Customer("Chloe","O'Brian"))
        repository.save(Customer("Kim","Bauer"))
        repository.save(Customer("David","Palmer"))
        repository.save(Customer("Michelle","Dessler"))*/

        /*repository.save(Data(Date(),Date(),Date(),UUID.randomUUID().toString(),"1"))
        val list = repository.findAll()
        for(item in list){
            print(item)
        }
    }*/
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringKotlinApplication::class.java, *args)
}
