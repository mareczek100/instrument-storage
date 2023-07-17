package mareczek100.instrumentstorage.infrastructure.database.repository.jpa;

import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentCategoryJpaRepository extends JpaRepository<InstrumentCategoryEntity, Short> {
    Optional<InstrumentCategoryEntity> findInstrumentCategoryByCategoryName(String instrumentCategoryEntityCategoryName);
}