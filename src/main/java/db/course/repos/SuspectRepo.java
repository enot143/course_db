package db.course.repos;


import db.course.domain.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuspectRepo extends JpaRepository<Suspect, Long> {
    Suspect findSuspectById (Long id);
}
