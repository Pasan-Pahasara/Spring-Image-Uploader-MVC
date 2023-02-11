package lk.ijse.spring.config;

import lk.ijse.spring.service.ImageService;
import lk.ijse.spring.service.impl.ImageServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : ShEnUx
 * @time : 12:41 AM
 * @date : 2/8/2023
 * @since : 0.1.0
 **/
@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackages = "lk.ijse.spring.service")
public class WebRootConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
