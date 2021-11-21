package db.course.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "performer")
@ToString(of = {"id", "address", "human"})
@EqualsAndHashCode(of = {"id"})
public class Performer {
    @Id
    @Column(name = "performer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "human_id", referencedColumnName = "human_id")
    private Human human;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
}
