package kz.dias.entrance_access_service.controller;

import kz.dias.entrance_access_service.domain.AccessJournal;
import kz.dias.entrance_access_service.domain.UsernameRequestBody;
import kz.dias.entrance_access_service.enums.EActionType;
import kz.dias.entrance_access_service.service.AccessJournalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/access")
public class AccessController {
    private final AccessJournalService accessJournalService;

    public AccessController(AccessJournalService accessJournalService) {
        this.accessJournalService = accessJournalService;
    }

    @PostMapping("/enter")
    private Boolean checkEnterAccessAndUpdateJournal(@RequestBody UsernameRequestBody username) {
        return accessJournalService.checkAccessAndUpdateJournal(username, EActionType.enter);
    }

    @PostMapping("/exit")
    private Boolean checkExitAccessAndUpdateJournal(@RequestBody UsernameRequestBody username) {
        return accessJournalService.checkAccessAndUpdateJournal(username, EActionType.exit);
    }

    @GetMapping("/journal")
    private List<AccessJournal> listJournal() {
        return accessJournalService.listJournal();
    }
}
