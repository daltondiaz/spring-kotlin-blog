package dalton.kotlin.springkotlin.security.auth

import dalton.kotlin.springkotlin.author.Author
import dalton.kotlin.springkotlin.common.DeviceProvider
import dalton.kotlin.springkotlin.security.UserDetailsService
import org.springframework.http.MediaType
import org.springframework.mobile.device.Device
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.AuthenticationException
import java.io.IOException
import javax.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.servlet.http.HttpServletRequest


/**
 * Created by dalton on 29/11/17.
 *
 * @author dalton
 * @since v1.0
 */

@RestController
@RequestMapping(value = "/auth", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
class AuthenticationController(val tokenHelper: TokenHelper,
                               val authenticationManager: AuthenticationManager,
                               val customUserDetailsService: UserDetailsService,
                               val deviceProvider: DeviceProvider){

    @Throws(AuthenticationException::class, IOException::class)
    @CrossOrigin(origins = arrayOf("http://localhost:8080"))
    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
    fun createAuthenticationToken(@RequestBody authenticationRequest: JwtAuthenticationRequest,
                                  response: HttpServletResponse,
                                  device: Device): ResponseEntity<UserTokenState>? {

        // Perform the security
        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        authenticationRequest.username,
                        authenticationRequest.password
                )
        )

        // Inject into security context
        SecurityContextHolder.getContext().authentication = authentication

        val user: Author = authentication.principal as Author
        val jws: String = tokenHelper.generateToken(user.username,device)
        val expiresIn: Long = tokenHelper.getExpiredIn(device)

        return ResponseEntity.ok(UserTokenState(jws,expiresIn))

    }

    @RequestMapping(value = "/refresh", method = arrayOf(RequestMethod.POST))
    fun refreshAuthenticationToken(request: HttpServletRequest,
                                   response: HttpServletResponse,
                                   principal: Principal): ResponseEntity<UserTokenState>? {

        val authToken = tokenHelper.getToken(request)
        val device = deviceProvider.getCurrentDevice(request)

        if(authToken != null){
            val refreshtoken = tokenHelper.refreshToken(authToken, device)
            val expiresIn = tokenHelper.getExpiredIn(device)
            return ResponseEntity.ok(UserTokenState(refreshtoken, expiresIn))
        }else{
            val userTokenState = UserTokenState()
            return ResponseEntity.accepted().body(userTokenState)
        }
    }



}
