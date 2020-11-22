package sk.mysterum.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.mysterum.backend.model.OpenedDayWindowModel;

import java.util.List;

public interface OpenedDayWindowRepository extends JpaRepository<OpenedDayWindowModel, Long> {
    public List<OpenedDayWindowModel> findByUserId(Long userId);
}
