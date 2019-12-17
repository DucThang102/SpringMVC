package thangpd.dao;

import thangpd.dto.StudentDTO;
import thangpd.entity.Student;

import java.util.List;

public interface StudentDao {

    List<StudentDTO> findAll();

    StudentDTO findById(String id );

    void save(Student studentInformation);
}
