package db.course.repos;

import db.course.domain.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepo extends JpaRepository<Performer, Long> {
    Performer findPerformerById (Long id);
}

