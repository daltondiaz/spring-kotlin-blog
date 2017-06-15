package dalton.kotlin.springkotlin.post

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Created by dalton on 10/06/17.
 */

@Component
class PostService(val postRepository: PostRepository){

    val log = LoggerFactory.getLogger(PostService::class.java)

    fun updatePost(post: Post):Boolean{
        try {
            var newPost = postRepository.findOne(post.id)
            newPost.title = post.title
            newPost.description = post.description
            postRepository.save(newPost)
            return true
        }catch (e:Exception ){
            log.error(e.localizedMessage, e)
        }
        return false
    }

    fun deletePost(id: Long): Boolean{
        try {
            var post = postRepository.findOne(id)
            post.status = false
            postRepository.save(post)
            return true
        }catch (e: Exception){
            log.error(e.localizedMessage, e)
        }
        return false
    }
}
