package sk.mysterum.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.mysterum.backend.model.TextModel;

import java.util.List;

public interface TextRepository extends JpaRepository<TextModel, Long> {
    public List<TextModel> findByDay(Integer day);
    public void deleteByDay(Integer day);
}
