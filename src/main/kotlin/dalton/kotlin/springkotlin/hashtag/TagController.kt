package dalton.kotlin.springkotlin.hashtag

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
    fun findAll()
            = tagRepostiory.findAll()

    @GetMapping("/tag/{id}")
    fun findOne(@PathVariable id: Long)
            = tagRepostiory.findOne(id)

    @PostMapping("/tag")
    fun save(@RequestBody hashtag: Tag)
            = tagRepostiory.save(hashtag)

    @PutMapping("/tag")
    fun update(@RequestBody hashtag: Tag)
            = tagRepostiory.save(hashtag)

    @DeleteMapping("/tag/{id}")
    fun delete(@PathVariable id: Long)
            = tagService.delete(id)
}
