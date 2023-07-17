package mareczek100.instrumentstorage.infrastructure.database.repository;

import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentEntity;

import java.util.List;
import java.util.Optional;

public interface InstrumentRepository {
    InstrumentEntity insertInstrument(InstrumentEntity instrumentEntity);

    InstrumentEntity updateInstrument(InstrumentEntity instrumentEntityWithId);

    Optional<InstrumentEntity> findInstrumentById(Integer instrumentEntityId);

    Optional<InstrumentEntity> findInstrumentByName(String instrumentEntityName);

    List<InstrumentEntity> findInstrumentByCategoryName(String instrumentEntityCategory);

    List<InstrumentEntity> findAllInstruments();

    void deleteInstrumentByName(InstrumentEntity instrumentEntity);
}