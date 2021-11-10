package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long punishment_id) {
        this.id = punishment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String punishment_name) {
        this.name = punishment_name;
    }

    public Date getLasting() {
        return lasting;
    }

    public void setLasting(Date punishment_lasting) {
        this.lasting = punishment_lasting;
    }
}
