package kz.dias.entrance_access_service.mapper;

import kz.dias.entrance_access_service.domain.AccessJournal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccessJournalMapper {
    @Mapping(target = "employee.organization", ignore = true)
    AccessJournal entityToDomain(kz.dias.entrance_access_service.model.AccessJournal accessJournal);
}
