package hexagonal.adpters.outbound.entity;

import hexagonal.domain.Series;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class JpaSeriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double note;

    @CreatedDate
    private LocalDateTime created_at;
    @LastModifiedDate
    private LocalDateTime updated_at;

    public JpaSeriesEntity() {}

    public JpaSeriesEntity(Series data) {
        this.name = data.getName();
        this.note = data.getNote();
        this.created_at = data.getCreated_at();
        this.updated_at = data.getUpdated_at();
    }
}
