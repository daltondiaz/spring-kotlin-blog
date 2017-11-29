package dalton.kotlin.springkotlin.role

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

/**
 * Created by dalton on 07/11/17.
 *
 * @author dalton
 * @since v1.0
 */

@Entity
@Table(name = "role")
data class Role (
       @Id @GeneratedValue(strategy = GenerationType.AUTO)
       var id: Long,
       var description: String,
       @Column(name = "role_name")
       var roleName: String,
       var status: Boolean
): GrantedAuthority {
       override fun getAuthority(): String {
           return roleName
       }
}