package dalton.kotlin.springkotlin.security.auth

import dalton.kotlin.springkotlin.author.Author
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.hibernate.validator.spi.time.TimeProvider
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Value
import org.springframework.mobile.device.Device
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest




/**
 * Created by dalton on 07/11/17.
 *
 * @author dalton
 * @since v1.0
 */

@Component
class TokenHelper(){

    @Value("\${app.name}")
    private var appName: String? = null

    @Value("\${jwt.secret}")
    var SECRET: String? = null

    @Value("\${jwt.expires_in}")
    private var EXPIRES_IN: Long = 1

    @Value("\${jwt.mobile_expires_in}")
    private var MOBILE_EXPIRES_IN: Long = 1

    @Value("\${jwt.header}")
    private val AUTH_HEADER: String? = null

    private var SIGNATURE_ALGORITHM : SignatureAlgorithm = SignatureAlgorithm.HS512

    val AUDIENCE_UNKNOWN = "unknown"
    val AUDIENCE_WEB = "web"
    val AUDIENCE_MOBILE = "mobile"
    val AUDIENCE_TABLET = "tablet"

    fun getUsernameFromToken(token:String) : String?{
        var username:String? = null
        val claims: Claims? = getAllClaimsFromToken(token)
        username = claims?.subject
        return username
    }

    fun getAllClaimsFromToken(token: String): Claims?{

        val claims : Claims? = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .body

        return claims
    }

    fun getAudienceFromToken(token: String): String? {
        var audience: String?
        try {
            val claims = this.getAllClaimsFromToken(token)
            audience = claims?.getAudience()
        } catch (e: Exception) {
            audience = null
        }

        return audience
    }

    fun refreshToken(token: String, device: Device): String{
        val a: Date = Date()
        val claims = this.getAllClaimsFromToken(token)
        claims!!.issuedAt = a
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate(device))
                .signWith(SIGNATURE_ALGORITHM, SECRET)
                .compact()

    }

    fun generateToken(username: String, device: Device): String {
        val audience = generateAudience(device)
        return Jwts.builder()
                .setIssuer(appName)
                .setSubject(username)
                .setAudience(audience)
                .setExpiration(generateExpirationDate(device))
                .signWith(SIGNATURE_ALGORITHM, SECRET)
                .compact()
    }

    private fun generateAudience(device: Device): String {
        var audience = AUDIENCE_UNKNOWN
        if (device.isNormal) {
            audience = AUDIENCE_WEB
        } else if (device.isTablet) {
            audience = AUDIENCE_TABLET
        } else if (device.isMobile) {
            audience = AUDIENCE_MOBILE
        }
        return audience
    }

    fun getToken(request : HttpServletRequest) : String?{
        val authHeader : String
        authHeader = getAuthHeaderFromHeader(request)
        if (authHeader.startsWith("Bearer ")){
            return authHeader.substring(7)
        }
        return null
    }

    fun getAuthHeaderFromHeader(request : HttpServletRequest): String{
        return request.getHeader(AUTH_HEADER)
    }

    fun getIssuedAtDateFromToken(token: String): Date?{
        val claims: Claims? = this.getAllClaimsFromToken(token)
        return claims?.issuedAt

    }

    fun generateExpirationDate(device: Device): Date?{
        val expiresIn: Long = if(device.isTablet || device.isMobile) MOBILE_EXPIRES_IN else EXPIRES_IN
        return Date(Date().time.plus(expiresIn.times(1000)))
    }

    fun getExpiredIn(device: Device): Long? {
        if (device.isMobile() || device.isTablet()){
            return MOBILE_EXPIRES_IN
        }
        return EXPIRES_IN
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean{
        var author: Author = userDetails as Author
        val username: String? = getUsernameFromToken(token)
        val created = getIssuedAtDateFromToken(token)
        return !isCreatedBeforeLastPasswordReset(created,userDetails.lastPasswordResetDate)
                && username.equals(userDetails.username)
    }

    private fun isCreatedBeforeLastPasswordReset(created: Date?, lastPasswordReset: Date): Boolean
            = (created!!.before(lastPasswordReset))

}