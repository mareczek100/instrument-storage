package mareczek100.instrumentstorage.api.dto;

import lombok.Builder;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
@Builder
public record InstrumentDto(String name,
                            InstrumentCategoryEntity category) {
}