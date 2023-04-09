package kz.dias.entrance_access_service.service.implementation;

import kz.dias.entrance_access_service.domain.UsernameRequestBody;
import kz.dias.entrance_access_service.enums.EActionType;
import kz.dias.entrance_access_service.mapper.AccessJournalMapper;
import kz.dias.entrance_access_service.mapper.EmployeeMapper;
import kz.dias.entrance_access_service.model.AccessJournal;
import kz.dias.entrance_access_service.repository.AccessJournalRepository;
import kz.dias.entrance_access_service.service.AccessJournalService;
import kz.dias.entrance_access_service.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessJournalServiceImpl implements AccessJournalService {
    private final EmployeeService employeeService;
    private final AccessJournalRepository accessJournalRepository;
    private final EmployeeMapper employeeMapper;
    private final AccessJournalMapper accessJournalMapper;

    public AccessJournalServiceImpl(EmployeeService employeeService, AccessJournalRepository accessJournalRepository, EmployeeMapper employeeMapper, AccessJournalMapper accessJournalMapper) {
        this.employeeService = employeeService;
        this.accessJournalRepository = accessJournalRepository;
        this.employeeMapper = employeeMapper;
        this.accessJournalMapper = accessJournalMapper;
    }

    @Override
    public boolean checkAccessAndUpdateJournal(UsernameRequestBody username, EActionType actionType) {
        var employee = employeeService.getEmployeeById(username.getUsername());
        var accessAllowed = employee.getOrganization().isAccessAllowed();
        var journalEntry = new AccessJournal();
        journalEntry.setEmployee(employeeMapper.domainToEntity(employee));
        journalEntry.setActionType(actionType);
        journalEntry.setSuccess(accessAllowed);
        accessJournalRepository.save(journalEntry);
        return accessAllowed;
    }

    @Override
    public List<kz.dias.entrance_access_service.domain.AccessJournal> listJournal() {
        return accessJournalRepository.findAll()
                .stream().map(accessJournalMapper::entityToDomain)
                .toList();
    }

}
