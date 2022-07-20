package lt.codeacademy.eshop.security.repos;

import lt.codeacademy.eshop.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
