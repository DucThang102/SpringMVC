package thangpd.service;

import org.springframework.web.multipart.MultipartFile;
import thangpd.dto.StudentDTO;

import java.io.FileNotFoundException;
import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findById(String id);

    boolean uploadFile(MultipartFile file) throws FileNotFoundException;

    void save( StudentDTO studentInformationDto );
}
