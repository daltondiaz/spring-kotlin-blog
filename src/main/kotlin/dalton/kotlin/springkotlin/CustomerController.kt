package dalton.kotlin.springkotlin
/*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by dalton on 18/05/17.
 */

@RestController
class CustomerController(val repository:CustomerRepository){

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{name}")
    fun findByLastName(@PathVariable name:String)
        = repository.findByLastName(name)
}
*/