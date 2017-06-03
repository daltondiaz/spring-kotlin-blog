package dalton.kotlin.springkotlin.processing

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by dalton on 31/05/17.
 */

interface DataRepository : MongoRepository<Data,String>{
   fun findByIdItem(id: String): List<Data>
}


