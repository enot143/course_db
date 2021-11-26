package db.course.repos;

import db.course.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
