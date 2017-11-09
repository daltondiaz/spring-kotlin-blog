package dalton.kotlin.springkotlin.author

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

/**
 * Created by dalton on 11/06/17.
 *
 * @author dalton
 * @since v1.0
 */

@RestController
@RequestMapping("/api/v1")
class AuthorController(val authorRepository: AuthorRepository,
                       val authorService: AuthorService){


    @GetMapping("/author")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun findAll()
        = authorRepository.findAll()

    @GetMapping("/author/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun findOne(@PathVariable id:Long)
        = authorRepository.findOne(id)

    @PostMapping("/author")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    // TODO only can change own author
    fun save(@RequestBody author:Author)
        = authorRepository.save(author)

    @DeleteMapping("/author")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun delete(@PathVariable id:Long)
        = authorService.delete(id)
}