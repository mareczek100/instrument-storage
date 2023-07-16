package mareczek100.instrumentstorage.infrastructure.database.repository.jpa;

import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstrumentJpaRepository extends JpaRepository<InstrumentEntity, Integer> {
    Optional<InstrumentEntity> findInstrumentByName(String instrumentEntityName);
    List<InstrumentEntity> findInstrumentByCategory(String instrumentEntityCategory);
}