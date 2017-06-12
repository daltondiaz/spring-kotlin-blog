package dalton.kotlin.springkotlin.author

import org.springframework.web.bind.annotation.*

/**
 * Created by dalton on 11/06/17.
 */

@RestController
@RequestMapping("/api/v1")
class AuthorController(val authorRepository: AuthorRepository){


    @GetMapping("/author")
    fun findAll()
        = authorRepository.findAll()

    @GetMapping("/author/{id}")
    fun findOne(@PathVariable id:Long)
        = authorRepository.findOne(id)

    @PostMapping("/author")
    fun save(@RequestBody author:Author)
        = authorRepository.save(author)
}