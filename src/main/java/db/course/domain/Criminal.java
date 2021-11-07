package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Data
@Table(name = "criminal")
@ToString(of = {"id", "human", "crimeType", "punishment", "c"})
@EqualsAndHashCode(of = {"id"})
public class Criminal {
    @Id
    @Column(name = "criminal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "human_id", referencedColumnName = "human_id")
    private Human human;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "crimetype_id", referencedColumnName = "crimetype_id")
    private CrimeType crimeType;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "punishment_id", referencedColumnName = "punishment_id")
    private Punishment punishment;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "case_id", referencedColumnName = "case_id")
    private Case c;
}
