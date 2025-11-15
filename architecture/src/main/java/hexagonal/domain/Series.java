package hexagonal.domain;

import java.time.LocalDateTime;

public class Series {
    private Long id;

    private String name;
    private double note;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Series() {}

    public Series(
            String name,
            double note
    ) {}

    public Series(
            Long id,
            String name,
            double note,
            LocalDateTime created_at,
            LocalDateTime updated_at
    ) {}

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getNote() {
        return this.note;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public LocalDateTime getUpdated_at() {
        return this.updated_at;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdatedAt(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
