package co.com.mercadolibre.MELIChallenge.dtos.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DnaRequestTest {

    @Test
    void checkGetterAndSetters(){
        DnaRequest dnaRequest = new DnaRequest();
        List<String> listOfSequences = new ArrayList<>();
        dnaRequest.setDna(listOfSequences);
        Assertions.assertEquals(listOfSequences, dnaRequest.getDna());
        Assertions.assertTrue(dnaRequest.getDna().isEmpty());
    }
}