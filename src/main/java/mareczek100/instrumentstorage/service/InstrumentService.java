package mareczek100.instrumentstorage.service;

import lombok.RequiredArgsConstructor;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentEntity;
import mareczek100.instrumentstorage.infrastructure.database.repository.InstrumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Transactional
    public InstrumentEntity insertNewInstrument(InstrumentEntity instrumentEntity) {
        return instrumentRepository.insertInstrument(instrumentEntity);
    }
    @Transactional
    public List<InstrumentEntity> insertInstrumentList(List<InstrumentEntity> instrumentEntities) {
        return instrumentRepository.insertInstrumentList(instrumentEntities);
    }
    @Transactional
    public Optional<InstrumentEntity> findInstrumentById(Integer instrumentEntityId) {
        return instrumentRepository.findInstrumentById(instrumentEntityId);
    }
    @Transactional
    public Optional<InstrumentEntity> findInstrumentByName(String instrumentEntityName) {
        return instrumentRepository.findInstrumentByName(instrumentEntityName);
    }
    @Transactional
    public List<InstrumentEntity> findInstrumentByCategory(String instrumentEntityCategory) {
        return instrumentRepository.findInstrumentByCategory(instrumentEntityCategory);
    }
    @Transactional
    public List<InstrumentEntity> findAllInstruments() {
        return instrumentRepository.findAllInstruments();
    }
}