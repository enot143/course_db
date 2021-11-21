package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "suspect")
@ToString(of = {"id", "isCriminal", "appearance", "human"})
@EqualsAndHashCode(of = {"id"})
public class Suspect {
    @Id
    @Column(name = "suspect_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isCriminal;
    private String appearance;
    @OneToOne
    @JoinColumn(name = "human_id", referencedColumnName = "human_id")
    private Human human;
}
