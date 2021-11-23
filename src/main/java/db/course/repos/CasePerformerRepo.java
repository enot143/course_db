package db.course.repos;


import db.course.domain.CasePerformer;
import db.course.domain.CasePerformerKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CasePerformerRepo extends JpaRepository<CasePerformer, CasePerformerKey> {
//    @Query("delete from CasePerformer t where t.c.id = :case_id")
//    void deletePerformersByCaseId(@Param("case_id") Integer case_id);

    @Transactional
    void deleteByC_Id(Integer case_id);
}
