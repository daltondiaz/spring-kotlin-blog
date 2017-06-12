package dalton.kotlin.springkotlin.post

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by dalton on 08/06/17.
 */

interface  PostRepository: JpaRepository<Post, Long> {

}