package dalton.kotlin.springkotlin

import dalton.kotlin.springkotlin.author.Author
import dalton.kotlin.springkotlin.author.AuthorRepository
import dalton.kotlin.springkotlin.hashtag.Tag
import dalton.kotlin.springkotlin.hashtag.TagRepostiory
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by dalton on 07/11/17.
 *
 * Controller Test
 *
 * @author dalton
 * @since v1.0
 */

@RestController
@RequestMapping("/springjwt")
class ResourceController(val tagRepository: TagRepostiory, val authorRepository:AuthorRepository){

    @RequestMapping(value = "/tags")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun getUser(): List<Tag>
        = tagRepository.findAll()

    @GetMapping(value = "/authors")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    fun getAuthors(): List<Author>
        = authorRepository.findAll()
}