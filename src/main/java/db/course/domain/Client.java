package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "client")
@ToString(of = {"id", "police", "cash", "human"})
@EqualsAndHashCode(of = {"id"})
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean police;
    private Long cash;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "human_id", referencedColumnName = "human_id")
    private Human human;
}
