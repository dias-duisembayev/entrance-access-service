package kz.dias.entrance_access_service.domain;

import kz.dias.entrance_access_service.enums.EActionType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccessJournal {
    private Long id;
    private Employee employee;
    LocalDateTime accessTime;
    private EActionType actionType;
    private Boolean success;
}
