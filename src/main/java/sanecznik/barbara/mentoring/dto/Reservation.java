package sanecznik.barbara.mentoring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "Id_Student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Id_Teacher")
    private Teacher teacher;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @NonNull
    private Date dateStart;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @NonNull
    private Date dateEnd;
}
