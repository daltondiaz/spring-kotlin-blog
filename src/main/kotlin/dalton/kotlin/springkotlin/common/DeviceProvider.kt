package dalton.kotlin.springkotlin.common

import org.springframework.mobile.device.DeviceUtils
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

/**
 * Created by dalton on 29/11/17.
 *
 * @author dalton
 * @since v1.0
 */

@Component
class DeviceProvider{

    fun getCurrentDevice(request: HttpServletRequest)
        = DeviceUtils.getCurrentDevice(request)
}
