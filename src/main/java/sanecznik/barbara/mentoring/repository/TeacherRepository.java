package sanecznik.barbara.mentoring.repository;

import sanecznik.barbara.mentoring.dto.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByEmailEqualsAndPasswordEquals(String email, String password);
}
