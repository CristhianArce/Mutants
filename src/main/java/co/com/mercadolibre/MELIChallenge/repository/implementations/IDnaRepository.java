package co.com.mercadolibre.MELIChallenge.repository.implementations;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.mercadolibre.MELIChallenge.repository.entity.Dna;

import java.util.Optional;

@Repository
public interface IDnaRepository extends CrudRepository<Dna, String> {
    @Query("SELECT e FROM Dna e WHERE e.dnaSequence=:dnaSequence")
    Optional<Dna> findIfTheDnaSequenceAlreadyExistOnDB(String dnaSequence);

    @Query("SELECT COUNT(e) FROM Dna e WHERE e.isMutant=:isMutant")
    Long countByTypeOfDNA(Long isMutant);
}
