package kongkin.bbu.edu.crud.models.service;

import kongkin.bbu.edu.crud.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAll();
    Student getById(Integer Id);

    void create(Student student);

    void update(Student student);
    void delete(Student student);
}
