package kz.dias.entrance_access_service.repository;

import kz.dias.entrance_access_service.model.AccessJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessJournalRepository extends JpaRepository<AccessJournal, Long> {
}
