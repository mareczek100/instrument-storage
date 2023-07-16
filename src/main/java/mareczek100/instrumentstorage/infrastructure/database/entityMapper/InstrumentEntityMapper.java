package mareczek100.instrumentstorage.infrastructure.database.entityMapper;

import mareczek100.instrumentstorage.api.dto.InstrumentDto;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentEntity;

public interface InstrumentEntityMapper {

    default InstrumentEntity mapToEntityFromDto (InstrumentDto instrumentDto) {
        return null;
    }
    default InstrumentDto mapToDtoFromEntity (InstrumentEntity instrumentEntity) {
        return null;
    }

}