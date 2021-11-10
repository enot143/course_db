package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of = {"id", "name", "rating"})
@EqualsAndHashCode(of = {"id"})
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "source_id")
    private Long id;
    @Column(name = "source_name")
    private String name;
    @Column(name = "source_rating")
    private Long rating;

    public Long getId() {
        return id;
    }

    public void setId(Long source_id) {
        this.id = source_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String source_name) {
        this.name = source_name;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long source_rating) {
        this.rating = source_rating;
    }
}
