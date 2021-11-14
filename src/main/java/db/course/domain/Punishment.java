package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table
@ToString(of = {"id", "name", "lasting"})
@EqualsAndHashCode(of = {"id"})
public class Punishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "punishment_id")
    private Long id;
    @Column(name = "punishment_name")
    private String name;
    @Column(name = "punishment_lasting")
    private Date lasting;
}
