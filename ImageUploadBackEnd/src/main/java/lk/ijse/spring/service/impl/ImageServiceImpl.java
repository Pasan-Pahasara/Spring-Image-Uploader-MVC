package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ImageDTO;
import lk.ijse.spring.entity.Image;
import lk.ijse.spring.repo.ImageUploadedRepo;
import lk.ijse.spring.service.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author : ShEnUx
 * @time : 3:08 PM
 * @date : 2/10/2023
 * @since : 0.1.0
 **/
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageUploadedRepo repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveImageLocation(ImageDTO imageDTO) {
        repo.save(mapper.map(imageDTO, Image.class));
    }

    @Override
    public String loadImageLocation() {
        return repo.getLastImageLocation();
    }
}
