package dalton.kotlin.springkotlin.processing

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by dalton on 01/06/17.
 */

@RestController
class ProcessingController(val repository: DataRepository) {

    @GetMapping("/data")
    fun findAll() = repository.findAll()


    @GetMapping("/data/{idItem}")
    fun findByWorkShift(@PathVariable idItem: String)
        = repository.findByIdItem(idItem)

}