package co.com.mercadolibre.MELIChallenge.services.implementations;

import co.com.mercadolibre.MELIChallenge.dtos.request.DnaRequest;
import co.com.mercadolibre.MELIChallenge.services.contracts.DnaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@SpringJUnitConfig
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.properties"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class DnaServiceImplementationTest {


    @Autowired
    private DnaService dnaService;

    @Test
    void testTheDnaSequenceValidationForMutantDNA(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        listOfSequences.add("ATGCGA");
        listOfSequences.add("CAGTGC");
        listOfSequences.add("TTATGT");
        listOfSequences.add("AGAAGG");
        listOfSequences.add("CCCCTA");
        listOfSequences.add("TCACTG");
        dnaRequest.setDna(listOfSequences);

        Assertions.assertTrue(dnaService.isMutant(dnaRequest));
    }

    @Test
    void testTheDnaSequenceValidationForHumanDNA(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        listOfSequences.add("ATGCGA");
        listOfSequences.add("CAGTGC");
        listOfSequences.add("TTATGT");
        listOfSequences.add("AGATCG");
        listOfSequences.add("CCCATA");
        listOfSequences.add("TCACTG");
        dnaRequest.setDna(listOfSequences);

        Assertions.assertFalse(dnaService.isMutant(dnaRequest));
    }

    @Test
    void testTheDnaSequenceValidationForEmptySequence(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        dnaRequest.setDna(listOfSequences);
        Assertions.assertFalse(()-> dnaService.isMutant(dnaRequest));
    }


    @Test
    void testTheDnaSequenceValidationInNonSymmetricSequence(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        listOfSequences.add("ATGCGA");
        listOfSequences.add("CAGTGC");
        listOfSequences.add("TTATGT");
        listOfSequences.add("AGATCGC");
        listOfSequences.add("CCCATA");
        listOfSequences.add("TCACTG");
        dnaRequest.setDna(listOfSequences);

        Assertions.assertFalse(dnaService.isMutant(dnaRequest));
    }

    @Test
    void testTheDnaSequenceValidationWithNotValidBase(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        listOfSequences.add("ATGCGA");
        listOfSequences.add("CAGTGC");
        listOfSequences.add("TTATGT");
        listOfSequences.add("AGATCGC");
        listOfSequences.add("CCCATA");
        listOfSequences.add("TCAFTG");
        dnaRequest.setDna(listOfSequences);

        Assertions.assertFalse(dnaService.isMutant(dnaRequest));
    }

    @Test
    void testTheDnaSequenceValidationForMutantDNAButItWasPreviouslyChecked(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        listOfSequences.add("ATGCGA");
        listOfSequences.add("CAGTGC");
        listOfSequences.add("TTATGT");
        listOfSequences.add("AGAAGG");
        listOfSequences.add("CCCCTA");
        listOfSequences.add("TCACTG");
        dnaRequest.setDna(listOfSequences);

        Assertions.assertTrue(dnaService.isMutant(dnaRequest));
        Assertions.assertTrue(dnaService.isMutant(dnaRequest));
    }

}