package sanecznik.barbara.mentoring.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class Student extends Person {

    @NonNull
    private Faculty faculty;

    @NonNull
    @Column(unique = true)
    private long albumNumber;

    @Override
    public String toString() {
        return super.toString() + " album number: " + albumNumber + " faulty: " + faculty;
    }
}
