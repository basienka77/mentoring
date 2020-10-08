package sanecznik.barbara.mentoring.dto;

import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Persons")
@DiscriminatorColumn
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Nationalized
    private String name;

    @NonNull
    @Nationalized
    private String surname;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @Override
    public String toString() {
        return name + ' ' + surname;
    }
}
