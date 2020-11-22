package sk.mysterum.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.mysterum.backend.model.UserModel;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    public List<UserModel> findByNameEquals(String name);
}
