package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table
@ToString(of = {"id", "name", "rating"})
@EqualsAndHashCode(of = {"id"})
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "source_id")
    private Long id;
    @Column(name = "source_name")
    private String name;
    @Column(name = "source_rating")
    private Long rating;

}
