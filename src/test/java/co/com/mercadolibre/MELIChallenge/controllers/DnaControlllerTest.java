package co.com.mercadolibre.MELIChallenge.controllers;

import co.com.mercadolibre.MELIChallenge.dtos.request.DnaRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@SpringJUnitConfig
class DnaControlllerTest {
    @Autowired
    DnaControlller dnaControlller;

    @Test
    void TestMethodIsMutant(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        listOfSequences.add("ATGCGA");
        listOfSequences.add("CAGTGC");
        listOfSequences.add("TTATGT");
        listOfSequences.add("AGAAGG");
        listOfSequences.add("CCCCTA");
        listOfSequences.add("TCACTG");
        dnaRequest.setDna(listOfSequences);

        Assertions.assertEquals(HttpStatus.OK, dnaControlller.checkIfIsMutant(dnaRequest).getStatusCode());
    }

    @Test
    void TestMethodIsHuman(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        listOfSequences.add("ATGCGA");
        listOfSequences.add("CAGTGC");
        listOfSequences.add("TTATGT");
        listOfSequences.add("AGATCG");
        listOfSequences.add("CCCATA");
        listOfSequences.add("TCACTG");
        dnaRequest.setDna(listOfSequences);

        Assertions.assertEquals(HttpStatus.FORBIDDEN, dnaControlller.checkIfIsMutant(dnaRequest).getStatusCode());
    }


    @Test
    void testTheDnaSequenceValidationForEmptySequence(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        dnaRequest.setDna(listOfSequences);
        Assertions.assertEquals(HttpStatus.FORBIDDEN, dnaControlller.checkIfIsMutant(dnaRequest).getStatusCode());
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
        Assertions.assertEquals(HttpStatus.FORBIDDEN, dnaControlller.checkIfIsMutant(dnaRequest).getStatusCode());
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
        Assertions.assertEquals(HttpStatus.FORBIDDEN, dnaControlller.checkIfIsMutant(dnaRequest).getStatusCode());
    }

}