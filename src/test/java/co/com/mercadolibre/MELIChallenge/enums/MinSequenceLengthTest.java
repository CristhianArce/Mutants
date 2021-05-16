package co.com.mercadolibre.MELIChallenge.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSequenceLengthTest {

    @Test
    void getMinLengthDNASequenceValue(){
        Assertions.assertEquals(3, MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.getMinLength());
    }


    @Test
    void getMinLengthDNASequence(){
        Assertions.assertEquals("MIN_DNA_SEQUENCE_TO_BE_MUTANT", MinSequenceLength.MIN_DNA_SEQUENCE_TO_BE_MUTANT.name());
    }


}