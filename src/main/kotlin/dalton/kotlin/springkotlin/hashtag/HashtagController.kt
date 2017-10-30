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
class HashtagController(val hashtagRepostiory: HashtagRepostiory,
                        val hashtagService: HashtagService) {

    @GetMapping("/hashtags")
    fun findAll()
            = hashtagRepostiory.findAll()

    @GetMapping("/hashtag/{id}")
    fun findOne(@PathVariable id: Long)
            = hashtagRepostiory.findOne(id)

    @PostMapping("/hashtag")
    fun save(@RequestBody hashtag: Hashtag)
            = hashtagRepostiory.save(hashtag)

    @PutMapping("/hashtag")
    fun update(@RequestBody hashtag: Hashtag)
            = hashtagRepostiory.save(hashtag)

    @DeleteMapping("/hashtag/{id}")
    fun delete(@PathVariable id: Long)
            = hashtagService.delete(id)
}
