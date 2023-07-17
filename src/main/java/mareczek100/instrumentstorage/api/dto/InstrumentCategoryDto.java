package mareczek100.instrumentstorage.api.dto;

import lombok.Builder;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryName;

@Builder
public record InstrumentCategoryDto(InstrumentCategoryName category) {
}