package mareczek100.instrumentstorage.infrastructure.database.entityDtoMapper;

import mareczek100.instrumentstorage.api.dto.InstrumentCategoryDto;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class InstrumentCategoryEntityDtoMapper {
    public InstrumentCategoryEntity mapToEntityFromDto (InstrumentCategoryDto instrumentCategoryDto) {
        return InstrumentCategoryEntity.builder()
                .categoryName(instrumentCategoryDto.category())
                .build();
    }
    public InstrumentCategoryDto mapToDtoFromEntity (InstrumentCategoryEntity instrumentCategoryEntity) {
        return InstrumentCategoryDto.builder()
                .category(instrumentCategoryEntity.getCategoryName())
                .build();
    }
}