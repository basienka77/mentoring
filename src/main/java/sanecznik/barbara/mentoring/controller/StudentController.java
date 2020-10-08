package sanecznik.barbara.mentoring.controller;

import sanecznik.barbara.mentoring.dto.Person;
import sanecznik.barbara.mentoring.dto.Student;
import sanecznik.barbara.mentoring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/student", produces = APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getListOfStudents() {
        return studentService.findAll();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping("/login")
    public Long login(@RequestBody Person person) {
      return studentService.findByEmailEqualsAndPasswordEquals(person.getEmail(),person.getPassword());
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student) {
        studentService.save(student);
    }
}
