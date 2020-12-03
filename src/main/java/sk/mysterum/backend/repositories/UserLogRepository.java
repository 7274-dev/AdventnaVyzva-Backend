package sk.mysterum.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.mysterum.backend.model.UserModel;

public interface UserLogRepository extends JpaRepository<UserModel, Long> {
}
