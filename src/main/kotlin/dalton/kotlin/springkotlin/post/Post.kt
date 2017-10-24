package dalton.kotlin.springkotlin.post


import dalton.kotlin.springkotlin.author.Author
import dalton.kotlin.springkotlin.hashtag.Hashtag
import java.text.SimpleDateFormat
import java.util.*
import javax.persistence.*

/**
 * Created by dalton on 08/06/17.
 */
@Entity
@Table(name = "post")
data class Post (
        var description: String = "",
        var title: String = "",
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long = 0,
        var status: Boolean = true,
        @ManyToOne
        var author:Author = Author(),
        @OneToMany
        var hashtags: MutableList<Hashtag> = mutableListOf(),
        var creationDate: Date = Date(),
        var updateDate: Date
){
        // created a get to format the creation date
        val creationDateFormat: String
                get() {
                        var sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                        return sdf.format(this.creationDate)
                }
}