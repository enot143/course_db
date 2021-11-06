package db.course.repos;

import db.course.domain.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface CaseRepo extends JpaRepository<Case, Integer> {
    Case findCaseById(Integer id);
    @Procedure(value = "end_case")
    void endCase(@Param("case_id") Integer caseId);
}
