package co.com.mercadolibre.MELIChallenge.services.implementations;

import co.com.mercadolibre.MELIChallenge.dtos.response.ResponseDTO;
import co.com.mercadolibre.MELIChallenge.services.contracts.StatService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.properties"})
class StatServiceImplementationTest {

    @Autowired
    StatService statService;

    @Test
    @Sql(scripts = "/database/fill-data-for-dna-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void checkStatisticsFromDB(){
        
        ResponseDTO responseDTO = statService.getStatisticsFromPopulationDNA();
        Assertions.assertEquals(1L, responseDTO.getCountMutantDna());
        Assertions.assertEquals(2L, responseDTO.getCountHumanDna());
        Assertions.assertEquals(new BigDecimal(0.5).doubleValue(), responseDTO.getRatio().doubleValue());
    }

}