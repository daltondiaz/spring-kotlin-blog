package dalton.kotlin.springkotlin.post

import dalton.kotlin.springkotlin.author.Author
import dalton.kotlin.springkotlin.hashtag.Tag
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by dalton on 08/06/17.
 *
 * @author dalton
 * @since v1.0
 */

interface  PostRepository: JpaRepository<Post, Long> {

    fun findByAuthorAndStatusOrderByCreationDateDesc(author: Author, status:Boolean):List<Post>
    fun findByTagsAndStatusOrderByCreationDateDesc(tag: Tag, status: Boolean):List<Post>
}