package db.course.repos;

import db.course.domain.Case;
import db.course.domain.Evidence;
import db.course.domain.Human;
import db.course.domain.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;


public interface CaseRepo extends JpaRepository<Case, Integer> {
    Case findCaseById(Integer id);

    @Procedure(value = "end_case")
    int endCase(@Param("case_id") Integer caseId);

    @Query("SELECT e.evid_name FROM Evidence e WHERE e.c.id = :case_id")
    List<String> findEvidences(@Param("case_id") Integer case_id);

    @Query("select p.human.name, p.human.surname from Performer p join Human h ON h.id = p.human.id where p.id in \n" +
            "(select p2.performer.id from CasePerformer p2 where p2.c.id = :case_id) ")
    ArrayList<String> findPerformers(@Param("case_id") Integer case_id);

    @Query("select c.human.name, c.human.surname from Criminal c where c.c.id = :case_id")
    ArrayList<String> findCriminals(@Param("case_id") Integer case_id);

    @Query("select s.name from Source s where s.id in (select s2.source.id from CaseSource s2 where s2.c.id = :case_id) ")
    ArrayList<String> findSources(@Param("case_id") Integer case_id);
}
