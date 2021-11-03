package db.course.repos;

import db.course.domain.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepo extends JpaRepository<Human, Long> {
   Human findByName(String name);
}
