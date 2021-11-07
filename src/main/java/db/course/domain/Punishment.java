package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@ToString(of = {"id", "punishment_name", "punishment_lasting"})
@EqualsAndHashCode(of = {"id"})
public class Punishment {
    @Id
    @Column(name = "punishment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String punishment_name;
    private Date punishment_lasting;

    public Long getPunishment_id() {
        return id;
    }

    public void setPunishment_id(Long punishment_id) {
        this.id = punishment_id;
    }

    public String getPunishment_name() {
        return punishment_name;
    }

    public void setPunishment_name(String punishment_name) {
        this.punishment_name = punishment_name;
    }

    public Date getPunishment_lasting() {
        return punishment_lasting;
    }

    public void setPunishment_lasting(Date punishment_lasting) {
        this.punishment_lasting = punishment_lasting;
    }
}
