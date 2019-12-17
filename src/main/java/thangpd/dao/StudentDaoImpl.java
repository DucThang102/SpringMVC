package thangpd.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import thangpd.dto.StudentDTO;
import thangpd.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<StudentDTO> findAll() {
        String sql = "Select * From STUDENT";
        return namedParameterJdbcTemplate.query(sql,
                new BeanPropertyRowMapper<StudentDTO>(StudentDTO.class));
    }

    @Override
    public StudentDTO findById(String id) {
        String sql = "Select * From STUDENT WHERE id = :p_id";
        Map<String, String> params = new HashMap<>();
        params.put("p_id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params,
                new BeanPropertyRowMapper<>(StudentDTO.class));
    }

    @Override
    public void save(Student studentInformation) {
        sessionFactory.getCurrentSession().save(studentInformation);
    }

}
