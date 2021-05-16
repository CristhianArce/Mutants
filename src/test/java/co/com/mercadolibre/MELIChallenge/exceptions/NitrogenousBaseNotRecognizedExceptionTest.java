package co.com.mercadolibre.MELIChallenge.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NitrogenousBaseNotRecognizedExceptionTest {
    @Test
    void testException(){
        NitrogenousBaseNotRecognizedException nitrogenousBaseNotRecognizedException = Assertions.assertThrows(NitrogenousBaseNotRecognizedException.class, () -> fakeMethod());
        Assertions.assertEquals("Hello World!", nitrogenousBaseNotRecognizedException.getMessage());
    }

    void fakeMethod() throws NitrogenousBaseNotRecognizedException {
        throw new NitrogenousBaseNotRecognizedException("Hello World!");
    }
}