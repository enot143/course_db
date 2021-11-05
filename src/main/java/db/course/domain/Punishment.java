package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@ToString(of = {"punishment_id", "punishment_name", "punishment_lasting"})
@EqualsAndHashCode(of = {"punishment_id"})
public class Punishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long punishment_id;
    private String punishment_name;
    private Date punishment_lasting;

    public Long getPunishment_id() {
        return punishment_id;
    }

    public void setPunishment_id(Long punishment_id) {
        this.punishment_id = punishment_id;
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
