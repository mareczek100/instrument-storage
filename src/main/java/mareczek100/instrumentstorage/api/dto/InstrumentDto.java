package mareczek100.instrumentstorage.api.dto;

import lombok.Builder;
@Builder
public record InstrumentDto(String name,
                            InstrumentCategoryDto category) {
}