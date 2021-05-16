package co.com.mercadolibre.MELIChallenge.controllers;

import co.com.mercadolibre.MELIChallenge.dtos.response.ResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.properties"})
class StatControllerTest {

    @Autowired
    StatController statController;

    @Test
    @Sql(scripts = "/database/fill-data-for-dna-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void checkStatistics(){
        ResponseEntity<Object> response = statController.getPopulationsStatistics();
        ResponseDTO responseDTO = (ResponseDTO) response.getBody();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        Assertions.assertEquals(1L, responseDTO.getCountMutantDna());
        Assertions.assertEquals(2L, responseDTO.getCountHumanDna());
        Assertions.assertEquals(new BigDecimal(0.5).doubleValue(), responseDTO.getRatio().doubleValue());
    }
}