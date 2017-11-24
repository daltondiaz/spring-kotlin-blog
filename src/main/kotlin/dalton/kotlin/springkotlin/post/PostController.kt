package dalton.kotlin.springkotlin.post

import dalton.kotlin.springkotlin.author.AuthorRepository
import dalton.kotlin.springkotlin.hashtag.Tag
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

/**
 * Created by dalton on 08/06/17.
 *
 * @author dalton
 * @since v1.0
 */

@RestController
@RequestMapping("/api/v1")
class PostController(val postRepository: PostRepository, val postService : PostService, val authorRepository: AuthorRepository){

    @GetMapping("/posts")
   // @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun findAll():List<Post>{
        val author = authorRepository.findOne(1L)
        val posts = postRepository.findByAuthorAndStatusOrderByCreationDateDesc(author,true)
        return posts
    }

    @PostMapping("/post/tag")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun findAllByTag(@RequestBody tag: Tag): List<Post>{
        return postRepository.findByTagsAndStatusOrderByCreationDateDesc(tag,true)
    }

    @GetMapping("/post/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun findOne(@PathVariable id:Long)
        = postRepository.findOne(id)

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun save(@RequestBody post: Post): Post
        = postService.save(post)

    @PutMapping("/post")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    // TODO only edit own post
    fun update(@RequestBody post: Post)
        = postService.updatePost(post)

    @DeleteMapping("/post/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun deletePost(@PathVariable id:Long)
        = postService.deletePost(id)

}

