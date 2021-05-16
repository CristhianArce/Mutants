package co.com.mercadolibre.MELIChallenge.dtos.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ResponseDTOTest {

    @Test
    void checkGettersAndSetters(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setRatio(new BigDecimal(0));
        responseDTO.setCountHumanDna(10L);
        responseDTO.setCountMutantDna(8L);
        Assertions.assertEquals(new BigDecimal(0).longValue(), responseDTO.getRatio().longValue());
        Assertions.assertEquals(10L, responseDTO.getCountHumanDna());
        Assertions.assertEquals(8L, responseDTO.getCountMutantDna());
    }

}