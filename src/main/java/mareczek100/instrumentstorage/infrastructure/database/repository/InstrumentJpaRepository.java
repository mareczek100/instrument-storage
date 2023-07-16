package mareczek100.instrumentstorage.infrastructure.database.repository;

import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentJpaRepository extends JpaRepository<InstrumentEntity, Integer> {
}
