package sanecznik.barbara.mentoring.services;

import sanecznik.barbara.mentoring.dto.Student;
import sanecznik.barbara.mentoring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Long findByEmailEqualsAndPasswordEquals(String email, String password) {
        Student student = studentRepository.findByEmailEqualsAndPasswordEquals(email,password);
        if (student != null) {
            return student.getId();
        }
        return -1L;
    }
}
