package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "crimetype")
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id"})
public class CrimeType {
    @Id
    @Column(name = "crimetype_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "crimetype_name")
    private String name;
}
