package dalton.kotlin.springkotlin.hashtag

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Created by dalton on 15/06/17.
 */

@Component
class HashtagService(val hashtagRepostiory: HashtagRepostiory){

    val log = LoggerFactory.getLogger(HashtagService::class.java)

    fun delete(id : Long): Boolean{

        try{
            var hashtag = hashtagRepostiory.findOne(id)
            hashtag.status = false
            hashtagRepostiory.save(hashtag)
            return true
        }catch (e : Exception){
            log.error(e.localizedMessage,e)
        }
        return false

    }
}
