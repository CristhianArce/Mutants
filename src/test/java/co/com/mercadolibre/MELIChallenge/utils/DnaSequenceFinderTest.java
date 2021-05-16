package co.com.mercadolibre.MELIChallenge.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig
class DnaSequenceFinderTest {
    
    @Test
    void testSequenceValidatorForMutantDna(){
        char[][] matrix = {{'A','T','G','C','G','A'},
                {'C', 'A', 'G', 'T', 'G', 'C'},
                {'T', 'T', 'A', 'T', 'G', 'T'},
                {'A', 'G', 'A', 'A', 'G', 'G'},
                {'C', 'C', 'C', 'C', 'T', 'A'},
                {'T', 'C', 'A', 'C', 'T', 'G'}
        };
        DnaSequenceFinder dnaSequenceFinder = new DnaSequenceFinder(matrix);
        Assertions.assertTrue(dnaSequenceFinder.validateIfIsMutant());
    }

    @Test
    void testSequenceValidatorForHumanDna(){
        char[][] matrix = {{'A','T','G','C','G','A'},
                {'C', 'A', 'G', 'T', 'G', 'C'},
                {'T', 'T', 'A', 'T', 'T', 'T'},
                {'A', 'G', 'A', 'C', 'G', 'G'},
                {'G', 'C', 'G', 'T', 'C', 'A'},
                {'T', 'C', 'A', 'C', 'T', 'G'}
        };
        
        DnaSequenceFinder dnaSequenceFinder = new DnaSequenceFinder(matrix);
        Assertions.assertFalse(dnaSequenceFinder.validateIfIsMutant());
    }



    @Test
    void testSequenceValidatorForMutantDna2(){
        char[][] matrix = { {'A', 'T', 'G', 'C', 'G', 'A'},
                            {'C', 'A', 'G', 'T', 'A', 'C'},
                            {'T', 'T', 'A', 'A', 'T', 'T'},
                            {'A', 'G', 'A', 'C', 'G', 'G'},
                            {'C', 'C', 'C', 'C', 'C', 'A'},
                            {'T', 'C', 'A', 'C', 'T', 'G'}
        };

        DnaSequenceFinder dnaSequenceFinder = new DnaSequenceFinder(matrix);
        Assertions.assertTrue(dnaSequenceFinder.validateIfIsMutant());
    }
}