package mareczek100.instrumentstorage.api.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import mareczek100.instrumentstorage.api.dto.InstrumentCategoriesDto;
import mareczek100.instrumentstorage.api.dto.InstrumentCategoryDto;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentCategoryEntity;
import mareczek100.instrumentstorage.infrastructure.database.entityDtoMapper.InstrumentCategoryEntityDtoMapper;
import mareczek100.instrumentstorage.service.InstrumentCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(InstrumentCategoryRestController.API_INSTRUMENT_CATEGORY)
public class InstrumentCategoryRestController {
    public static final String API_INSTRUMENT_CATEGORY = "/api/instrument/category";
    public static final String FIND_INSTRUMENT_CATEGORY_BY_ID = "/{instrumentId}/id";
    public static final String FIND_INSTRUMENT_CATEGORY_BY_CATEGORY_NAME = "/{instrumentName}/category";

    private final InstrumentCategoryService instrumentCategoryService;
    private final InstrumentCategoryEntityDtoMapper instrumentCategoryEntityDtoMapper;
    @ApiResponse(code = 200, message = "Instrument storage found all instrument category in our base!")
    @Operation(summary = "Find list of available instrument category.")
    @GetMapping
    public InstrumentCategoriesDto allInstrumentCategoryList() {
        return InstrumentCategoriesDto.builder().instrumentCategoryDtoList(
                        instrumentCategoryService.findAllInstrumentCategories().stream()
                                .map(instrumentCategoryEntityDtoMapper::mapToDtoFromEntity)
                                .map(instrumentCategoryDto -> instrumentCategoryDto.category().name())
                                .toList())
                .build();
    }

    @ApiResponse(code = 200, message = "Instrument storage found instrument category by id!")
    @Operation(summary = "Find instrument category by name. Id is an integer between 1 and 3 - just main categories (without instrument category added by customers).")
    @GetMapping(FIND_INSTRUMENT_CATEGORY_BY_ID)
    public InstrumentCategoryDto findInstrumentCategoryById(
            @PathParam("instrumentCategoryId") Short instrumentCategoryId) {

        InstrumentCategoryEntity instrumentCategoryEntity = instrumentCategoryService.findInstrumentCategoryById(instrumentCategoryId);
        return instrumentCategoryEntityDtoMapper.mapToDtoFromEntity(instrumentCategoryEntity);
    }

    @ApiResponse(code = 200, message = "Instrument storage found instrument category by name!")
    @Operation(summary = "Find instrument category by name (with polish diacritical marks). To list all instrument category use allInstrumentCategoryList() method.")
    @GetMapping(FIND_INSTRUMENT_CATEGORY_BY_CATEGORY_NAME)
    public InstrumentCategoryDto findInstrumentCategoryByCategoryName(
            @PathParam("instrumentCategoryName") String instrumentCategoryName) {

        InstrumentCategoryEntity instrumentCategoryEntity = instrumentCategoryService.findInstrumentCategoryByName(instrumentCategoryName);
        return instrumentCategoryEntityDtoMapper.mapToDtoFromEntity(instrumentCategoryEntity);
    }

}