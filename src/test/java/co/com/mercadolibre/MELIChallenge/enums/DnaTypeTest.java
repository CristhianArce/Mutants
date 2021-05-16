package co.com.mercadolibre.MELIChallenge.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaTypeTest {

    @Test
    void getMinLengthDNASequenceValue(){
        Assertions.assertEquals(1L, DnaType.MUTANT.getType());
        Assertions.assertEquals(0L, DnaType.HUMAN.getType());
    }


    @Test
    void getMinLengthDNASequence(){
        Assertions.assertEquals("HUMAN", DnaType.HUMAN.name());
        Assertions.assertEquals("MUTANT", DnaType.MUTANT.name());

    }

}