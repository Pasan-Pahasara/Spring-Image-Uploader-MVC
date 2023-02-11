package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : ShEnUx
 * @time : 3:03 PM
 * @date : 2/10/2023
 * @since : 0.1.0
 **/
public interface ImageUploadedRepo extends JpaRepository<Image,Integer> {
    @Query(value = "SELECT filePath FROM Image ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLastImageLocation();
}
