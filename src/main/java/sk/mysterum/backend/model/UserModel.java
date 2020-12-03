package sk.mysterum.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean hasOpenedChallenge;
    private boolean hasOpenedSite;

    public boolean isHasOpenedChallenge() {
        return hasOpenedChallenge;
    }

    public void setHasOpenedChallenge(boolean hasOpenedChallenge) {
        this.hasOpenedChallenge = hasOpenedChallenge;
    }

    public boolean isHasOpenedSite() {
        return hasOpenedSite;
    }

    public void setHasOpenedSite(boolean hasOpenedSite) {
        this.hasOpenedSite = hasOpenedSite;
    }

    public UserModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserModel() {
        this.id = null;
        this.name = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasOpenedChallenge=" + hasOpenedChallenge +
                ", hasOpenedSite=" + hasOpenedSite +
                '}';
    }
}
