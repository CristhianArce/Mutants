package co.com.mercadolibre.MELIChallenge.controllers;

import co.com.mercadolibre.MELIChallenge.services.contracts.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stats")
public class StatController {

    @Autowired
    StatService statService;

    @GetMapping(path = "/",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPopulationsStatistics() {
        return ResponseEntity.ok().body(statService.getStatisticsFromPopulationDNA());
    }
}
