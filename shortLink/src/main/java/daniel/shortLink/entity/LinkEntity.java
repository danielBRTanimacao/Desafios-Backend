package daniel.shortLink.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private LocalDateTime createdAt;

    @PrePersist
    public void preCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public boolean isExpired() {
        LocalDateTime expiredTime = this.createdAt.plusMinutes(5);
        return LocalDateTime.now().isAfter(expiredTime);
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
