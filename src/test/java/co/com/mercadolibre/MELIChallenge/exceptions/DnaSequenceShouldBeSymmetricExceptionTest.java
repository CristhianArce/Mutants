package co.com.mercadolibre.MELIChallenge.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaSequenceShouldBeSymmetricExceptionTest {
    @Test
    void testException(){
        DnaSequenceShouldBeSymmetricException dnaSequenceShouldBeSymmetricException = Assertions.assertThrows(DnaSequenceShouldBeSymmetricException.class, () -> fakeMethod());
        Assertions.assertEquals("Hello World!", dnaSequenceShouldBeSymmetricException.getMessage());
    }

    void fakeMethod() throws DnaSequenceShouldBeSymmetricException {
        throw new DnaSequenceShouldBeSymmetricException("Hello World!");
    }
}