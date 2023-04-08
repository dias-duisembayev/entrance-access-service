package kz.dias.entrance_access_service.domain;

import lombok.Data;

@Data
public class Employee {
    private String id;
    private Organization organization;
}
