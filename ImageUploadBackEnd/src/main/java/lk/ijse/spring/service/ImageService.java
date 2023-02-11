package lk.ijse.spring.service;

import lk.ijse.spring.dto.ImageDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author : ShEnUx
 * @time : 3:07 PM
 * @date : 2/10/2023
 * @since : 0.1.0
 **/
public interface ImageService {
    void saveImageLocation(@ModelAttribute ImageDTO imageDTO);
    String loadImageLocation();
}
