package mareczek100.instrumentstorage.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(InstrumentRestController.API_INSTRUMENT)
public class InstrumentRestController {
    public static final String API_INSTRUMENT = "/api/instrument";
}