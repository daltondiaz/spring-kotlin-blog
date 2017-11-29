package dalton.kotlin.springkotlin.security.auth

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails

/**
 * Created by dalton on 28/11/17.
 *
 * @author dalton
 * @since v1.0
 */

class TokenBasedAuthentication(var userDetails: UserDetails): AbstractAuthenticationToken(userDetails.authorities){

    var token: String
            get() = token
            set(token: String){
                this.token = token
            }
    override fun getCredentials() : Any = token

    override fun getPrincipal(): Any = userDetails

    override fun isAuthenticated(): Boolean = true

}