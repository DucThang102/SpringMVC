package thangpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import thangpd.dao.StudentDao;
import thangpd.dto.StudentDTO;
import thangpd.entity.Student;
import thangpd.utils.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("all")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentInformationDao;

    @Override
    public List<StudentDTO> findAll() {
        return studentInformationDao.findAll();
    }

    @Override
    public StudentDTO findById(String id) {
        return studentInformationDao.findById(id);
    }

    @Override
    public boolean uploadFile(MultipartFile file) {
        try {
            File newFile = new File(Constant.FOLDER_UPLOAD +
                    file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException fileNotFound) {
            return false;
        }
        return true;
    }

    @Override
    public void save(StudentDTO studentInformationDto) {
        Student studentInformation = new Student();

        studentInformation.setName(studentInformationDto.getName());
        studentInformation.setPhone(studentInformationDto.getPhone());
        studentInformation.setAddress(studentInformationDto.getAddress());
        studentInformation.setEmail(studentInformationDto.getEmail());

        studentInformationDao.save(studentInformation);
    }

}
