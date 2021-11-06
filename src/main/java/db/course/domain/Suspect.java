package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "suspect")
@ToString(of = {"id", "isCriminal", "appearance", "human"})
@EqualsAndHashCode(of = {"id"})
public class Suspect {
    @Id
    @Column(name = "suspect_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isCriminal;
    private String appearance;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "human_id", referencedColumnName = "human_id")
    private Human human;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCriminal() {
        return isCriminal;
    }

    public void setCriminal(boolean criminal) {
        isCriminal = criminal;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
}
