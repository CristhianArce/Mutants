package co.com.mercadolibre.MELIChallenge.repository.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaTest {
    @Test
    void checkGettersAndSetters(){
        Dna dna = new Dna();
        dna.setDnaId(1L);
        dna.setDnaSequence("ABCDEFG");
        dna.setIsMutant(1L);

        Assertions.assertEquals(1L, dna.getDnaId());
        Assertions.assertEquals("ABCDEFG", dna.getDnaSequence());
        Assertions.assertEquals(1L, dna.getIsMutant());
    }

}