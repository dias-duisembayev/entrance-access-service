package kz.dias.entrance_access_service.service;

import kz.dias.entrance_access_service.domain.AccessJournal;
import kz.dias.entrance_access_service.domain.UsernameRequestBody;
import kz.dias.entrance_access_service.enums.EActionType;

import java.util.List;

public interface AccessJournalService {
    boolean checkAccessAndUpdateJournal(UsernameRequestBody username, EActionType actionType);
    List<AccessJournal> listJournal();
}
