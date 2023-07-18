package mareczek100.instrumentstorage.api.dto;

import lombok.Builder;
@Builder
public record InstrumentDto(String name,
                            Boolean primarySchoolDegree,
                            Boolean secondarySchoolDegree,
                            InstrumentCategoryDto category) {
}