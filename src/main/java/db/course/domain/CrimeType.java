package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "crimetype")
@ToString(of = {"id", "crimetype_name"})
@EqualsAndHashCode(of = {"id"})
public class CrimeType {
    @Id
    @Column(name = "crimetype_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crimetype_name;

    public Long getCrimetype_id() {
        return id;
    }

    public void setCrimetype_id(Long crimetype_id) {
        this.id = crimetype_id;
    }

    public String getCrimetype_name() {
        return crimetype_name;
    }

    public void setCrimetype_name(String crimetype_name) {
        this.crimetype_name = crimetype_name;
    }
}
