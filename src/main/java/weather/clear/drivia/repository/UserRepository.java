package weather.clear.drivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.entity.userEntity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
