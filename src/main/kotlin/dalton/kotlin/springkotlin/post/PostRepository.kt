package dalton.kotlin.springkotlin.post

import dalton.kotlin.springkotlin.author.Author
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by dalton on 08/06/17.
 */

interface  PostRepository: JpaRepository<Post, Long> {

    fun findByAuthorAndStatusOrderByCreationDateDesc(author: Author, status:Boolean):List<Post>
}