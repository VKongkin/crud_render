package kongkin.bbu.edu.crud.models.service.implement;

import kongkin.bbu.edu.crud.models.Student;
import kongkin.bbu.edu.crud.models.service.StudentService;
import kongkin.bbu.edu.crud.models.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;


    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Integer Id) {
        return studentRepo.findById(Id).orElse(null);
    }





    @Override
    public void create(Student student) {
        student.setStatus("ACT");
        studentRepo.save(student);
    }

    @Override
    public void update(Student student) {
        String message = "Not found";
        var checkStu = getById(student.getId());
        if (checkStu == null){
            log.error("No id found");
        }
        student.setStatus("ACT");
        studentRepo.save(student);

    }

    @Override
    public void delete(Student student) {
        var checkStu = getById(student.getId());
        if (checkStu == null){
            log.error("No id found");
        }
        student.setName(student.getName());
        student.setDOB(student.getDOB());
        student.setAddress(student.getAddress());
        student.setStatus("DEL");
        studentRepo.save(student);

    }
}
