package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "human")
@ToString(of = {"id", "name", "surname", "age", "gender", "profession"})
@EqualsAndHashCode(of = {"id"})
public class Human {
    @Id
    @Column(name = "human_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Long age;
    private boolean gender;
    private String profession;
}
