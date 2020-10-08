package sanecznik.barbara.mentoring.controller;

import sanecznik.barbara.mentoring.dto.Reservation;
import sanecznik.barbara.mentoring.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/reservation", produces = APPLICATION_JSON_VALUE)
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/teacher")
    public List<Reservation> getListReservationsForTeacher(@RequestParam Long id) {
        return reservationService.findAllByTeacherId(id);
    }

    @GetMapping("/student")
    public List<Reservation> getListReservationsForStudent(@RequestParam Long id) {
        return reservationService.findAllByStudentId(id);
    }

    @DeleteMapping
    public void deleteReservation(@RequestParam Long id) {
        reservationService.deleteById(id);
    }

    @PostMapping
    public String addReservation(@RequestBody Reservation reservation) {
       return reservationService.addReservation(reservation);
    }

    @PutMapping
    public void updateReservation(@RequestBody Reservation reservation) {
        reservationService.updateReservation(reservation);
    }

}
