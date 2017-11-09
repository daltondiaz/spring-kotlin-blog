package dalton.kotlin.springkotlin.hashtag

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

/**
 * Created by dalton on 15/06/17.
 *
 * @author dalton
 * @since v1.0
 */

@RestController
@RequestMapping("/api/v1")
class TagController(val tagRepostiory: TagRepostiory,
                    val tagService: TagService) {

    @GetMapping("/tags")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun findAll()
            = tagRepostiory.findAll()

    @GetMapping("/tag/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun findOne(@PathVariable id: Long)
            = tagRepostiory.findOne(id)

    @PostMapping("/tag")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun save(@RequestBody hashtag: Tag)
            = tagRepostiory.save(hashtag)

    @PutMapping("/tag")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun update(@RequestBody hashtag: Tag)
            = tagRepostiory.save(hashtag)

    @DeleteMapping("/tag/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun delete(@PathVariable id: Long)
            = tagService.delete(id)
}
