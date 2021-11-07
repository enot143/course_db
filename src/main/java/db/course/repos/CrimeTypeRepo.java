package db.course.repos;

import db.course.domain.CrimeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeTypeRepo extends JpaRepository<CrimeType, Long> {
    CrimeType findCrimeTypeById(Long id);
}

