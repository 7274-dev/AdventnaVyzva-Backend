package sk.mysterum.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.mysterum.backend.model.TextModel;

import javax.transaction.Transactional;
import java.util.List;

public interface TextRepository extends JpaRepository<TextModel, Long> {
    public List<TextModel> findByDay(Integer day);
    @Transactional
    public void deleteAllByDayEquals(Integer day);
}
