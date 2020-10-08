package sanecznik.barbara.mentoring;

import sanecznik.barbara.mentoring.dto.Faculty;
import sanecznik.barbara.mentoring.dto.Student;
import sanecznik.barbara.mentoring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class MentoringApplication implements ApplicationRunner {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(MentoringApplication.class, args);
    }
    @Autowired
    StudentRepository studentRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
      // saveStudents();
      // showStudentsByFaculty();
      // showStudentsBySurnameContain();
    }

    private void showStudentsBySurnameContain() {
        for (Student student : studentRepository.findAllBySurnameContaining("9")) {
            System.out.println(student);
        }
    }

    private void showStudentsByFaculty() {
        for (Student student : studentRepository.findAllByFacultyEquals(Faculty.IP)) {
            System.out.println(student);
        }
    }

    private void saveStudents() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setAlbumNumber(Math.abs(new Random().nextLong()));
            student.setName("Name" + i);
            student.setSurname("Surname" + i);
            student.setFaculty(i % 2 == 0 ? Faculty.IP : Faculty.ZiIP);
            students.add(student);
        }
        studentRepository.saveAll(students);
    }

}
