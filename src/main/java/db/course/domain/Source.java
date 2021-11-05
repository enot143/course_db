package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of = {"source_id", "source_name", "source_rating"})
@EqualsAndHashCode(of = {"source_id"})
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long source_id;
    private String source_name;
    private Long source_rating;

    public Long getSource_id() {
        return source_id;
    }

    public void setSource_id(Long source_id) {
        this.source_id = source_id;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public Long getSource_rating() {
        return source_rating;
    }

    public void setSource_rating(Long source_rating) {
        this.source_rating = source_rating;
    }
}
