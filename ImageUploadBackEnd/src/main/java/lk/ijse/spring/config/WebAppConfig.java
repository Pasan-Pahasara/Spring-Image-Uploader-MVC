package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : ShEnUx
 * @time : 12:40 AM
 * @date : 2/8/2023
 * @since : 0.1.0
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {})
public class WebAppConfig {
}
