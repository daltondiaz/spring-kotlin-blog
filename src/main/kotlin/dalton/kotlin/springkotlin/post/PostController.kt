package dalton.kotlin.springkotlin.post

import org.springframework.web.bind.annotation.*

/**
 * Created by dalton on 08/06/17.
 */

@RestController
@RequestMapping("/api/v1")
class PostController(val postRepository: PostRepository, val postService : PostService){

    @GetMapping("/post")
    fun findAll()
        = postRepository.findAll()

    @GetMapping("/post/{id}")
    fun findOne(@PathVariable id:Long)
        = postRepository.findOne(id)

    @PostMapping("/post")
    fun save(@RequestBody post: Post)
        = postRepository.save(post)


    @PutMapping("/post")
    fun update(@RequestBody post: Post)
        = postService.updatePost(post)

    @DeleteMapping("/post/{id}")
    fun deletePost(@PathVariable id:Long)
        = postService.deletePost(id)

}