package kz.dias.entrance_access_service.domain;

import lombok.Data;

@Data
public class Organization {
    private Long id;
    boolean accessAllowed;
}
