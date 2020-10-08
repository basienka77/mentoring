package sanecznik.barbara.mentoring.controller;

import sanecznik.barbara.mentoring.dto.Person;
import sanecznik.barbara.mentoring.dto.Teacher;
import sanecznik.barbara.mentoring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/teacher", produces = APPLICATION_JSON_VALUE)
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public void registerTeacher(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
    }

    @PutMapping
    public void updateTeacher(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
    }

    //adres: /teacher/7
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteById(id);
    }

    //adres: /teacher?id=7
    @DeleteMapping
    public void deleteTeacher2(@RequestParam Long id) {
        Optional<Teacher> teacher = teacherService.findById(id);
        teacher.ifPresent(teacher1 -> teacherService.delete(teacher1));
    }

    @PostMapping("/login")
    public Long login(@RequestBody Person person) {
     return teacherService.findByEmailEqualsAndPasswordEquals(person.getEmail(), person.getPassword());
    }

    @GetMapping
    public List<Teacher> getListTeachers() {
        return teacherService.findAll();
    }

}
