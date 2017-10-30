package dalton.kotlin.springkotlin.post

import dalton.kotlin.springkotlin.author.Author
import dalton.kotlin.springkotlin.hashtag.Hashtag
import dalton.kotlin.springkotlin.hashtag.HashtagRepostiory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

/**
 * Created by dalton on 10/06/17.
 */

@Component
class PostService(val postRepository: PostRepository, val hashtagRepostiory: HashtagRepostiory){

    val log = LoggerFactory.getLogger(PostService::class.java)

    fun updatePost(post: Post):Boolean{
        try {
            var newPost = postRepository.findOne(post.id)
            newPost.title = post.title
            newPost.description = post.description
            newPost.updateDate = Date()
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


    fun save(post:Post): Post{

        val author = Author()
        author.id= 1
        post.author = author
        post.creationDate = Date()
        post.status = true

        val hashtags = post.hashtags

        for (hashtag : Hashtag in hashtags){
            if (hashtag.id == 0L){
                hashtag.creationDate = Date()
                hashtag.status = true
                hashtagRepostiory.save(hashtag)
            }
        }

        return postRepository.save(post)
    }
}
