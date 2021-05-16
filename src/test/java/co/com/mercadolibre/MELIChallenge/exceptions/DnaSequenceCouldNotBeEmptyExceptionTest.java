package co.com.mercadolibre.MELIChallenge.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaSequenceCouldNotBeEmptyExceptionTest {

    @Test
    void testException(){
        DnaSequenceCouldNotBeEmptyException dnaSequenceCouldNotBeEmptyException = Assertions.assertThrows(DnaSequenceCouldNotBeEmptyException.class, () -> fakeMethod());
        Assertions.assertEquals("Hello World!", dnaSequenceCouldNotBeEmptyException.getMessage());
    }

    void fakeMethod() throws DnaSequenceCouldNotBeEmptyException {
         throw new DnaSequenceCouldNotBeEmptyException("Hello World!");
    }
}