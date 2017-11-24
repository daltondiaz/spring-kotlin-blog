
package dalton.kotlin.springkotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer





/**
 *  Enabling CORS for the whole application to methods:
 *  GET, POST, PUT and DELETE
 *
 * @author dalton
 * @since v1.0


@Configuration
class MyConfiguration {

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {

            override fun addCorsMappings(registry: CorsRegistry?) {
                registry!!.addMapping("/**")
            }
        }
    }
}
*/