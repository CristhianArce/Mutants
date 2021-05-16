package co.com.mercadolibre.MELIChallenge.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseDTO {
    @JsonProperty("count_mutant_dna")
    Long countMutantDna;
    @JsonProperty("count_human_dna")
    Long countHumanDna;
    @JsonProperty("ratio")
    BigDecimal ratio;
}
