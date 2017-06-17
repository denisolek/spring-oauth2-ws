package pl.denisolek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.denisolek.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}