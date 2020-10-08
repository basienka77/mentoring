package sanecznik.barbara.mentoring.services;

import sanecznik.barbara.mentoring.dto.Person;
import sanecznik.barbara.mentoring.dto.Reservation;
import sanecznik.barbara.mentoring.dto.Student;
import sanecznik.barbara.mentoring.dto.Teacher;
import sanecznik.barbara.mentoring.repository.ReservationRepository;
import sanecznik.barbara.mentoring.repository.StudentRepository;
import sanecznik.barbara.mentoring.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    JavaMailSenderImpl mailSender;

    private final static String SUBJECT = "Reservation created";

    private final static String TEXT = "Reservation created for %s, student: %s, teacher: %s.";

    public List<Reservation> findAllByTeacherId(Long id) {
        return reservationRepository.findAllByTeacher_Id(id);
    }

    public List<Reservation> findAllByStudentId(Long id) {
        return reservationRepository.findAllByStudent_Id(id);
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    public String addReservation(Reservation reservation) {
        Optional<Student> student = studentRepository.findById(reservation.getStudent().getId());
        Optional<Teacher> teacher = teacherRepository.findById(reservation.getTeacher().getId());
        if (student.isPresent() && reservationRepository.countAllByStudent_Id(student.get().getId()) > 4) {
            return "Reservation limit reached";
        }
        if (!isDateDivisibleBy15(reservation.getDateStart(), reservation.getDateEnd())){
            return "Reservation must be multiply 15 min";
        }
        reservationRepository.save(reservation);
        if (student.isPresent() && teacher.isPresent()) {
            String text = String.format(TEXT, reservation.getDateStart(), student.get(), teacher.get());
            sendMessage(teacher.get(), student.get(), SUBJECT, text);
        }
        return "Reservation added";
    }
    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    private boolean isDateDivisibleBy15 (Date dataStart, Date dataEnd){
        long timeDiffrence = dataEnd.getTime() - dataStart.getTime();
        return timeDiffrence % 15 ==0;
    }

    private void sendMessage(Person teacher, Person student, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("buchwaldgrupa@gmail.com");
        message.setTo(teacher.getEmail(), student.getEmail());
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}
