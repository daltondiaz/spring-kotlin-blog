package dalton.kotlin.springkotlin.security

import dalton.kotlin.springkotlin.author.AuthorRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import jdk.nashorn.internal.objects.NativeArray.forEach
import java.util.ArrayList
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component


/**
 * Created by dalton on 08/11/17.
 *
 * @author dalton
 * @since v1.0
 */
@Component
class UserDetailsService(val authorRepository: AuthorRepository): UserDetailsService{


    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {

        val author = authorRepository.findByName(username)

        if(author == null){
            throw UsernameNotFoundException(String.format("The username %s doesn't exist", username))
        }

        val authorities = ArrayList<GrantedAuthority>()
        author.roles.forEach { role -> authorities.add(SimpleGrantedAuthority(role.roleName)) }

        return User(author.name,author.password,authorities)
    }



}
