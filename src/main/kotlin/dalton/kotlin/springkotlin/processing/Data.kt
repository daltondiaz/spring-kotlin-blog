package dalton.kotlin.springkotlin.processing

import org.springframework.data.annotation.Id
import java.util.*

/**
 * Created by dalton on 31/05/17.
 */


data class Data(
        var dateInit: Date,
        var dateEnd: Date,
        var createDate: Date = Date(),
        var uuid: String,
        var idItem: String){

    constructor(): this(Date(), Date(), Date(), "", "")
}