package mareczek100.instrumentstorage.service;

import lombok.RequiredArgsConstructor;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
import mareczek100.instrumentstorage.infrastructure.database.repository.InstrumentCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstrumentCategoryService {

    private final InstrumentCategoryRepository instrumentCategoryRepository;
    @Transactional
    public List<InstrumentCategoryEntity> findAllInstrumentCategories() {
        List<InstrumentCategoryEntity> allInstrumentCategories = instrumentCategoryRepository.findAllCategories();
        if (allInstrumentCategories.isEmpty()){
            throw new RuntimeException("We have no instrument categories right now. Sorry!");
        }
        return allInstrumentCategories;
    }
    @Transactional
    public InstrumentCategoryEntity findInstrumentCategoryById(Short instrumentCategoryEntityId){
        return instrumentCategoryRepository.findCategoryById(instrumentCategoryEntityId).orElseThrow(
                () -> new RuntimeException("Instrument category with id number [%s] doesn't exist!"
                        .formatted(instrumentCategoryEntityId))
        );
    }
    @Transactional
    public InstrumentCategoryEntity findInstrumentCategoryByName(String instrumentCategoryEntityName) {
        return instrumentCategoryRepository.findCategoryByName(instrumentCategoryEntityName).orElseThrow(
                () -> new RuntimeException("Instrument category [%s] doesn't exist, sorry!"
                        .formatted(instrumentCategoryEntityName)));
    }
}