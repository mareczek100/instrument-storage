package mareczek100.instrumentstorage.infrastructure.database.repository;

import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentCategoryJpaRepository extends JpaRepository<InstrumentCategoryEntity, Short> {
}
