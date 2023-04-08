package kz.dias.entrance_access_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "e_employee")
public class Employee {
    @Id
    @Column(updatable = false, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
