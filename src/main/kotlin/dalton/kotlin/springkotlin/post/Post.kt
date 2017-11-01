package dalton.kotlin.springkotlin.post


import dalton.kotlin.springkotlin.author.Author
import dalton.kotlin.springkotlin.hashtag.Hashtag
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
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
        @ManyToMany
        //@Cascade(CascadeType.SAVE_UPDATE)
        var hashtags: MutableList<Hashtag> = mutableListOf(),
        var creationDate: Date = Date(),
        var updateDate: Date?
){
        // created a get to format the creation date
        val creationDateFormat: String
                get() {
                        return SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(this.creationDate)
                }

        val updateDateFormat: String
                get(){
                        if(this.updateDate != null){
                                return SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(this.updateDate)
                        }else{
                                return ""
                        }
                }
}