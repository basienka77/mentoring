package sanecznik.barbara.mentoring.dto;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Teachers")
public class Teacher extends Person {

    @NonNull
    private Degree degree;

    @ElementCollection(targetClass = Subject.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "Teacher_subjects")
    private List<Subject> subjects = new ArrayList<>();

    @Override
    public String toString() {
        return degree.name() + ' ' + super.toString() + " subject: " + subjects;
    }
}
