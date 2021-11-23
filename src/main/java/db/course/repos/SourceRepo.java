package db.course.repos;

import db.course.domain.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepo extends JpaRepository<Source, Long> {
    Source findSourceById(Long id);
}
