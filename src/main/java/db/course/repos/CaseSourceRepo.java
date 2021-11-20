package db.course.repos;

import db.course.domain.CaseSource;
import db.course.domain.CaseSourceKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseSourceRepo extends JpaRepository<CaseSource, CaseSourceKey> {

}
