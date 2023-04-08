package kz.dias.entrance_access_service.model;

import jakarta.persistence.*;
import kz.dias.entrance_access_service.enums.EActionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "e_journal")
@SequenceGenerator(name = "SEQ", sequenceName = "seq_journal", allocationSize = 1)
public class AccessJournal {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(generator = "SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "action_type", updatable = false, nullable = false)
    private EActionType actionType;

    @Column(updatable = false, nullable = false)
    private Boolean success;

    @CreatedDate
    @Column(name = "access_time", nullable = false, updatable = false)
    LocalDateTime accessTime;

    @PrePersist
    protected void onCreate() {
        setAccessTime(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessJournal that = (AccessJournal) o;
        return Objects.equals(id, that.id) && Objects.equals(accessTime, that.accessTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accessTime);
    }
}
