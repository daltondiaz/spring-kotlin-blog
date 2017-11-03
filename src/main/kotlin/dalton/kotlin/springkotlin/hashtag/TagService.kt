package dalton.kotlin.springkotlin.hashtag

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

/**
 * Created by dalton on 15/06/17.
 *
 *
 * @author dalton
 * @since v1.0
 */

@Component
class TagService(val tagRepostiory: TagRepostiory){

    val log = LoggerFactory.getLogger(TagService::class.java)

    fun delete(id : Long): Boolean{

        try{
            var hashtag = tagRepostiory.findOne(id)
            hashtag.status = false
            tagRepostiory.save(hashtag)
            return true
        }catch (e : Exception){
            log.error(e.localizedMessage,e)
        }
        return false

    }

    fun update(hashtag: Tag){
        try {
            hashtag.updateDate = Date()
        }catch (e:Exception){
            log.error(e.localizedMessage,e)
        }
    }
}
