package db.course.domain;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "case_source")
@ToString(of = {"c", "source"})
public class CaseSource {

    @EmbeddedId
    CaseSourceKey id;

    @ManyToOne
    @MapsId("caseId")
    @JoinColumn(name = "case_id", referencedColumnName = "case_id")
    Case c;

    @ManyToOne
    @MapsId("sourceId")
    @JoinColumn(name = "source_id", referencedColumnName = "source_id")
    Source source;

}