package co.com.mercadolibre.MELIChallenge.services.implementations;

import co.com.mercadolibre.MELIChallenge.dtos.response.ResponseDTO;
import co.com.mercadolibre.MELIChallenge.enums.DnaType;
import co.com.mercadolibre.MELIChallenge.repository.implementations.IDnaRepository;
import co.com.mercadolibre.MELIChallenge.services.contracts.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StatServiceImplementation implements StatService {

    @Autowired
    IDnaRepository dnaRepository;

    @Override
    public ResponseDTO getStatisticsFromPopulationDNA() {
        ResponseDTO responseDTO = new ResponseDTO();
        Long mutants = dnaRepository.countByTypeOfDNA(DnaType.MUTANT.getType());
        Long humans = dnaRepository.countByTypeOfDNA(DnaType.HUMAN.getType());
        BigDecimal ratio = (humans == 0L)
                ? new BigDecimal(0)
                : BigDecimal.valueOf((double) mutants /humans);

        responseDTO.setCountMutantDna(mutants);
        responseDTO.setCountHumanDna(humans);
        responseDTO.setRatio(ratio);
        return responseDTO;
    }
}
