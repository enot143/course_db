package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Data
@Table(name = "evidence")
@ToString(of = {"id", "suspect", "c", "evid_name"})
@EqualsAndHashCode(of = {"id"})
public class Evidence {
    @Id
    @Column(name = "evid_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "suspect_id", referencedColumnName = "suspect_id")
    private Suspect suspect;
    @ManyToOne
    @JoinColumn(name = "case_id", referencedColumnName = "case_id")
    private Case c;
    private String evid_name;
}
