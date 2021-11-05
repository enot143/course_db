package db.course.repos;

import db.course.domain.Punishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PunishmentRepo extends JpaRepository<Punishment, Long> {
}

