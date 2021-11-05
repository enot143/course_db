package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "crimetype")
@ToString(of = {"crimetype_id", "crimetype_name"})
@EqualsAndHashCode(of = {"crimetype_id"})
public class CrimeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crimetype_id;
    private String crimetype_name;

    public Long getCrimetype_id() {
        return crimetype_id;
    }

    public void setCrimetype_id(Long crimetype_id) {
        this.crimetype_id = crimetype_id;
    }

    public String getCrimetype_name() {
        return crimetype_name;
    }

    public void setCrimetype_name(String crimetype_name) {
        this.crimetype_name = crimetype_name;
    }
}
