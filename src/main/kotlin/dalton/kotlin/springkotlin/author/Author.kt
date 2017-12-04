package dalton.kotlin.springkotlin.author

import javax.persistence.*
import dalton.kotlin.springkotlin.role.Role
import org.joda.time.DateTime
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.sql.Timestamp
import java.util.*

/**
 * Created by dalton on 11/06/17.
 * @author dalton
 * @since v1.0
 */

@Entity
@Table(name = "author")
data class Author (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long=0,
        var name: String = "",
        var email: String = "",
        var status: Boolean = false,
        private var password: String = "",
        @ManyToMany(fetch = FetchType.EAGER)
        var roles: MutableList<Role> = mutableListOf(),
        @Column(name = "last_password_reset_date")
        var lastPasswordResetDate: Timestamp = Timestamp(DateTime.now().millis)
): UserDetails {
    override fun isEnabled(): Boolean = status

    override fun getUsername(): String = name

    override fun isCredentialsNonExpired(): Boolean = true

    override  fun getPassword(): String = this.password

    fun setPassword(password: String){
        val now = Timestamp(DateTime.now().millis)
        this.lastPasswordResetDate = now
        this.password = password
    }

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = roles

}
