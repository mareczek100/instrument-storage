package mareczek100.instrumentstorage.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
import mareczek100.instrumentstorage.infrastructure.database.repository.jpa.InstrumentCategoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InstrumentCategoryRepository {

    private final InstrumentCategoryJpaRepository instrumentCategoryJpaRepository;

    public InstrumentCategoryEntity insertInstrumentCategory(InstrumentCategoryEntity instrumentCategoryEntity) {
        return instrumentCategoryJpaRepository.save(instrumentCategoryEntity);
    }
    public InstrumentCategoryEntity updateInstrumentCategory(InstrumentCategoryEntity instrumentCategoryEntityWithId) {
        return instrumentCategoryJpaRepository.save(instrumentCategoryEntityWithId);
    }
    public List<InstrumentCategoryEntity> findAllCategories(){
        return instrumentCategoryJpaRepository.findAll();
    }
    public Optional<InstrumentCategoryEntity> findCategoryById(Short instrumentCategoryEntityId){
        return instrumentCategoryJpaRepository.findById(instrumentCategoryEntityId);
    }
    public Optional<InstrumentCategoryEntity> findCategoryByName(String instrumentCategoryEntityName){
        return instrumentCategoryJpaRepository.findInstrumentCategoryByName(instrumentCategoryEntityName);
    }
}
