package sanecznik.barbara.mentoring.services;

import sanecznik.barbara.mentoring.dto.Teacher;
import sanecznik.barbara.mentoring.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }


    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    public void delete(Teacher teacher1) {
        teacherRepository.delete(teacher1);
    }

    public Long findByEmailEqualsAndPasswordEquals(String email, String password) {
        Teacher teacher = teacherRepository.findByEmailEqualsAndPasswordEquals(email, password);
        if (teacher != null) {
            return teacher.getId();
        }
        return -1L;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

}
