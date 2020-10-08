package sanecznik.barbara.mentoring.repository;

import sanecznik.barbara.mentoring.dto.Faculty;
import sanecznik.barbara.mentoring.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFacultyEquals(Faculty faculty);

    List<Student> findAllBySurnameContaining(String surname);

    Student findByEmailEqualsAndPasswordEquals(String email, String password);

}
