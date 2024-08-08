package kongkin.bbu.edu.crud.controller;

import kongkin.bbu.edu.crud.models.Student;
import kongkin.bbu.edu.crud.models.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class StudentController extends webConfig{
    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudent(){

            List<Student> list = studentService.getAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable("id") Integer id){
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("/students/active")
    public ResponseEntity<Object> getActiveStudent(){

     return null;
    }



    @PostMapping("/students/create")
    public ResponseEntity<Object> create(@RequestBody Student req){
        studentService.create(req);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @PostMapping("/students/update")
    public ResponseEntity<Object> update(@RequestBody Student req){
        studentService.update(req);
        return new ResponseEntity<>("Update sucees", HttpStatus.OK);
    }

    @PostMapping("/students/delete")
    public ResponseEntity<Object> delete(@RequestBody Student student){
        studentService.delete(student);
        return new ResponseEntity<>("Delete success",HttpStatus.OK);
    }
}
