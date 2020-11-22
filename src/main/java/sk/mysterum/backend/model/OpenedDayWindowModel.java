package sk.mysterum.backend.model;

import javax.persistence.*;

@Entity
public class OpenedDayWindowModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Integer dayNumber;

    public OpenedDayWindowModel(Long id, Long userId, Integer dayNumber) {
        this.id = id;
        this.userId = userId;
        this.dayNumber = dayNumber;
    }

    public OpenedDayWindowModel() {
        this.id = null;
        this.userId = null;
        this.dayNumber = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }
}
