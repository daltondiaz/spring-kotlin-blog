package dalton.kotlin.springkotlin.post

import dalton.kotlin.springkotlin.author.AuthorRepository
import dalton.kotlin.springkotlin.hashtag.Hashtag
import org.springframework.web.bind.annotation.*

/**
 * Created by dalton on 08/06/17.
 */

@RestController
@RequestMapping("/api/v1")
class PostController(val postRepository: PostRepository, val postService : PostService, val authorRepository: AuthorRepository){

    @GetMapping("/post")
    fun findAll():List<Post>{
        val author = authorRepository.findOne(1L)
        val posts = postRepository.findByAuthorAndStatusOrderByCreationDateDesc(author,true)
        return posts
    }


    @GetMapping("/post/{id}")
    fun findOne(@PathVariable id:Long)
        = postRepository.findOne(id)

    @PostMapping("/post")
    fun save(@RequestBody post: Post, hashtags: ArrayList<Hashtag>):Post{
        return postService.save(post)
    }

    @PutMapping("/post")
    fun update(@RequestBody post: Post)
        = postService.updatePost(post)

    @DeleteMapping("/post/{id}")
    fun deletePost(@PathVariable id:Long)
        = postService.deletePost(id)

}

