package db.course.domain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "case_performer")
@ToString(of = {"c", "performer"})
@EqualsAndHashCode
public class CasePerformer {

    @EmbeddedId
    CasePerformerKey id;

    @ManyToOne
    @MapsId("caseId")
    @JoinColumn(name = "case_id", referencedColumnName = "case_id")
    Case c;

    @ManyToOne
    @MapsId("performerId")
    @JoinColumn(name = "performer_id", referencedColumnName = "performer_id")
    Performer performer;

}