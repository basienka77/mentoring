package sanecznik.barbara.mentoring.repository;

import sanecznik.barbara.mentoring.dto.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByTeacher_Id(Long id);

    List<Reservation> findAllByStudent_Id(Long id);
    Integer countAllByStudent_Id(Long id);
}
