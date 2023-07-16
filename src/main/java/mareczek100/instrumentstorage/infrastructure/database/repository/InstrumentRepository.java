package mareczek100.instrumentstorage.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentEntity;
import mareczek100.instrumentstorage.infrastructure.database.repository.jpa.InstrumentJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InstrumentRepository {

    private final InstrumentJpaRepository instrumentJpaRepository;

    public InstrumentEntity insertInstrument(InstrumentEntity instrumentEntity) {
        return instrumentJpaRepository.saveAndFlush(instrumentEntity);
    }
    public List<InstrumentEntity> insertInstrumentList(List<InstrumentEntity> instrumentEntities) {
        return instrumentJpaRepository.saveAllAndFlush(instrumentEntities);
    }
    public Optional<InstrumentEntity> findInstrumentById(Integer instrumentEntityId) {
        return instrumentJpaRepository.findById(instrumentEntityId);
    }
    public Optional<InstrumentEntity> findInstrumentByName(String instrumentEntityName) {
        return instrumentJpaRepository.findInstrumentByName(instrumentEntityName);
    }
    public List<InstrumentEntity> findInstrumentByCategory(String instrumentEntityCategory) {
        return instrumentJpaRepository.findInstrumentByCategory(instrumentEntityCategory);
    }
    public List<InstrumentEntity> findAllInstruments() {
        return instrumentJpaRepository.findAll();
    }

}