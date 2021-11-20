package db.course.repos;


import db.course.domain.CasePerformer;
import db.course.domain.CasePerformerKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CasePerformerRepo extends JpaRepository<CasePerformer, CasePerformerKey> {

}
