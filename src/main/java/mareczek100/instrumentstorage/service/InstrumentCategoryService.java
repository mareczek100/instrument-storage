package mareczek100.instrumentstorage.service;

import lombok.RequiredArgsConstructor;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
import mareczek100.instrumentstorage.infrastructure.database.repository.InstrumentCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstrumentCategoryService {

    private final InstrumentCategoryRepository instrumentCategoryRepository;

    @Transactional
    public InstrumentCategoryEntity insertNewInstrumentCategory(InstrumentCategoryEntity instrumentCategoryEntity) {
        return instrumentCategoryRepository.insertInstrumentCategory(instrumentCategoryEntity);
    }
    @Transactional
    public InstrumentCategoryEntity updateInstrumentCategory(InstrumentCategoryEntity instrumentCategoryEntityWithId) {
        return instrumentCategoryRepository.updateInstrumentCategory(instrumentCategoryEntityWithId);
    }
    @Transactional
    public List<InstrumentCategoryEntity> findAllCategories() {
        return instrumentCategoryRepository.findAllCategories();
    }
    @Transactional
    public Optional<InstrumentCategoryEntity> findCategoryById(Short instrumentCategoryEntityId){
        return instrumentCategoryRepository.findCategoryById(instrumentCategoryEntityId);
    }
    @Transactional
    public Optional<InstrumentCategoryEntity> findCategoryByName(String instrumentCategoryEntityName) {
        return instrumentCategoryRepository.findCategoryByName(instrumentCategoryEntityName);
    }
}
