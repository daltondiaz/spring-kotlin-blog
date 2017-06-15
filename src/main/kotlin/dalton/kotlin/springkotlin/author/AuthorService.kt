package dalton.kotlin.springkotlin.author

import dalton.kotlin.springkotlin.hashtag.HashtagService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Created by dalton on 15/06/17.
 */

@Component
class AuthorService(val authorRepository: AuthorRepository){

    val log = LoggerFactory.getLogger(AuthorService::class.java)

    fun delete(id: Long):Boolean{
        try {
            val author:Author = authorRepository.findOne(id)
            author.status = false
            authorRepository.save(author)
            return true
        }catch (e:Exception){
            log.error(e.localizedMessage,e)
        }
        return false
    }
}
