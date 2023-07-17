package mareczek100.instrumentstorage.api.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import mareczek100.instrumentstorage.api.dto.InstrumentDto;
import mareczek100.instrumentstorage.api.dto.InstrumentsDto;
import mareczek100.instrumentstorage.infrastructure.database.entity.InstrumentEntity;
import mareczek100.instrumentstorage.infrastructure.database.entityDtoMapper.InstrumentEntityDtoMapper;
import mareczek100.instrumentstorage.service.InstrumentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(InstrumentRestController.API_INSTRUMENT)
public class InstrumentRestController {
    public static final String API_INSTRUMENT = "/api/instrument";
    public static final String ADD_INSTRUMENT = "/add";
    public static final String UPDATE_INSTRUMENT = "/update";
    public static final String FIND_INSTRUMENT_BY_ID = "/{instrumentId}/id";
    public static final String FIND_INSTRUMENT_BY_NAME = "/{instrumentName}/name";
    public static final String FIND_INSTRUMENT_BY_CATEGORY = "/{instrumentCategory}/category";
    public static final String DELETE_INSTRUMENT_BY_NAME = "/delete";

    private final InstrumentService instrumentService;
    private final InstrumentEntityDtoMapper instrumentEntityDtoMapper;

    @ApiResponse(code = 200, message = "Instrument storage found all instruments in our base!")
    @Operation(summary = "Find list of available instruments.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public InstrumentsDto allInstrumentList() {
        return InstrumentsDto.builder().instrumentDtoList(
                        instrumentService.findAllInstruments().stream()
                                .map(instrumentEntityDtoMapper::mapToDtoFromEntity)
                                .toList())
                .build();
    }

    @ApiResponse(code = 200, message = "Added new instrument to Instrument storage!")
    @Operation(summary = "Add new instrument to Instrument storage.")
    @PostMapping(ADD_INSTRUMENT)
    public InstrumentDto addInstrumentToExistingInstrumentList(
            @Valid @RequestBody InstrumentDto instrumentDto) {

        InstrumentEntity instrumentEntity = instrumentEntityDtoMapper.mapToEntityFromDto(instrumentDto);
        InstrumentEntity insertedNewInstrument = instrumentService.insertNewInstrument(instrumentEntity);
        return instrumentEntityDtoMapper.mapToDtoFromEntity(insertedNewInstrument);
    }

    @ApiResponse(code = 200, message = "Instrument updated!")
    @Operation(summary = "Update instrument by put old and new-updated name. Use polish diacritical marks if necessary.")
    @PatchMapping(UPDATE_INSTRUMENT)
    public InstrumentDto updateExistingInstrumentByName(
            @RequestParam(name = "oldInstrumentName") String oldInstrumentName,
            @RequestParam(name = "newInstrumentName") String newInstrumentName) {

        InstrumentEntity instrument = instrumentService.findInstrumentByName(oldInstrumentName);
        InstrumentEntity instrumentToUpdate = InstrumentEntity.builder()
                .instrumentId(instrument.getInstrumentId())
                .name(newInstrumentName)
                .build();

        InstrumentEntity updatedInstrument = instrumentService.updateInstrument(instrumentToUpdate);
        return instrumentEntityDtoMapper.mapToDtoFromEntity(updatedInstrument);
    }

    @ApiResponse(code = 200, message = "Instrument storage found instrument by name!")
    @Operation(summary = "Find instrument by instrument id number. Id is an integer between 1 and size of all instrument list.")
    @GetMapping(FIND_INSTRUMENT_BY_ID)
    public InstrumentDto findInstrumentById(
            @PathParam("instrumentId") Integer instrumentId) {

        InstrumentEntity instrumentEntity = instrumentService.findInstrumentById(instrumentId);
        return instrumentEntityDtoMapper.mapToDtoFromEntity(instrumentEntity);
    }

    @ApiResponse(code = 200, message = "Instrument storage found instrument by name!")
    @Operation(summary = "Find instrument by instrument name. To list all instruments use allInstrumentList() method.")
    @GetMapping(FIND_INSTRUMENT_BY_NAME)
    public InstrumentDto findInstrumentByName(
            @PathParam("instrumentName") String instrumentName) {

        InstrumentEntity instrumentEntity = instrumentService.findInstrumentByName(instrumentName);
        return instrumentEntityDtoMapper.mapToDtoFromEntity(instrumentEntity);
    }

    @ApiResponse(code = 200, message = "Instrument storage found instrument by category!")
    @Operation(summary = "List all instruments by category: \"strunowe\", \"dęte\" (with polish diacritical marks) or \"perkusyjne\".")
    @GetMapping(FIND_INSTRUMENT_BY_CATEGORY)
    public InstrumentsDto findInstrumentByCategory(
            @PathParam("instrumentCategory") String instrumentCategory) {

        return InstrumentsDto.builder().instrumentDtoList(
                        instrumentService.findInstrumentByCategory(instrumentCategory).stream()
                                .map(instrumentEntityDtoMapper::mapToDtoFromEntity)
                                .toList())
                .build();
    }
    @ApiResponse(code = 200, message = "Instrument deleted!")
    @Operation(summary = "Delete instrument from our storage by instrument name.")
    @DeleteMapping(DELETE_INSTRUMENT_BY_NAME)
    public void deleteInstrumentByName(
            @RequestParam("instrumentName") String instrumentName) {

        instrumentService.deleteInstrumentByName(instrumentName);
    }

}