package kz.dias.entrance_access_service.mapper;

import kz.dias.entrance_access_service.domain.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee entityToDomain(kz.dias.entrance_access_service.model.Employee employee);
    kz.dias.entrance_access_service.model.Employee domainToEntity(Employee employee);
}
