package db.course.repos;

import db.course.domain.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalRepo extends JpaRepository<Criminal, Long> {
    Criminal findCriminalById(Long id);
}
