package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ImageDTO;
import lk.ijse.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @author : ShEnUx
 * @time : 12:51 AM
 * @date : 2/8/2023
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("api/v1/upload")
@CrossOrigin
public class ImageUploadController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public String uploadFileWithSpringWay(@RequestPart("image") MultipartFile myFile, ModelMap modelMap) {
        modelMap.addAttribute("file", myFile);
        try {
            byte[] byteArray = myFile.getBytes();
//          String projectPath = "D:\\IJSE\\Second Semester\\AAD (Advance API Development)\\Spring-Image-Uploader-MVC\\ImageUploadFrontEnd\\assets\\image";
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

            String path = "/" + myFile.getOriginalFilename();
            Path location = Paths.get(projectPath + path);
            Files.write(location, byteArray);
            myFile.transferTo(location);
            System.out.println(projectPath);

//          String location2 = "assets/" + myFile.getOriginalFilename();
            imageService.saveImageLocation(new ImageDTO(null, location.toString()));

            return Base64.getEncoder().encodeToString(byteArray);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public String getAllImagesFromDatabase(){
        return imageService.loadImageLocation();
    }
}
