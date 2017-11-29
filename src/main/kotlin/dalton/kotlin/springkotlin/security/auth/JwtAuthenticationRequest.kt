package dalton.kotlin.springkotlin.security.auth

/**
 * Created by dalton on 07/11/17.
 *
 * @author dalton
 * @since v1.0
 */

class JwtAuthenticationRequest(){
    var username: String = ""
    var password: String = ""

    fun JwtAuthenticationRequest(username: String, password: String){
        this.username = username
        this.username = password
    }
}