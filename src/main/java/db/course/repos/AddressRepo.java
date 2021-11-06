package db.course.repos;

import db.course.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
    Address findAddressById(Long id);
    Address getById(Long id);
}
