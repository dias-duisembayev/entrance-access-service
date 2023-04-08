package kz.dias.entrance_access_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "e_organization")
@SequenceGenerator(name = "SEQ", sequenceName = "seq_org", allocationSize = 1)
public class Organization {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(generator = "SEQ")
    private Long id;

    @Column(nullable = false, name = "access_allowed")
    boolean accessAllowed = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
