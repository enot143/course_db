package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "crimetype")
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id"})
public class CrimeType {
    @Id
    @Column(name = "crimetype_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "crimetype_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long crimetype_id) {
        this.id = crimetype_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String crimetype_name) {
        this.name = crimetype_name;
    }
}
