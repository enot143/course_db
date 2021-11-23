package db.course.repos;

import db.course.domain.CaseSource;
import db.course.domain.CaseSourceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CaseSourceRepo extends JpaRepository<CaseSource, CaseSourceKey> {
    @Transactional
    void deleteByC_Id(Integer case_id);
}
