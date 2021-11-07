package db.course.repos;

import db.course.domain.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvidenceRepo extends JpaRepository<Evidence, Long> {
    Evidence findEvidenceById(Long id);
}
