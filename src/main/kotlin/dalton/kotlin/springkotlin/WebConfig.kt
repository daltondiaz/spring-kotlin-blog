
package dalton.kotlin.springkotlin

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
@EnableWebMvc

/**
 * Enabling CORS for the whole application
 *
 * @author dalton
 * @since v1.0
 */
class WebConfig : WebMvcConfigurerAdapter(){

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
    }
}