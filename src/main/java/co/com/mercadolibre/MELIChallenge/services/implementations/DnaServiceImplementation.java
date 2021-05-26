package co.com.mercadolibre.MELIChallenge.services.implementations;

import java.util.Optional;
import java.util.regex.Pattern;

import co.com.mercadolibre.MELIChallenge.dtos.request.DnaRequest;
import co.com.mercadolibre.MELIChallenge.enums.DnaType;
import co.com.mercadolibre.MELIChallenge.exceptions.DnaSequenceCouldNotBeEmptyException;
import co.com.mercadolibre.MELIChallenge.exceptions.DnaSequenceShouldBeSymmetricException;
import co.com.mercadolibre.MELIChallenge.exceptions.NitrogenousBaseNotRecognizedException;
import co.com.mercadolibre.MELIChallenge.repository.entity.Dna;
import co.com.mercadolibre.MELIChallenge.repository.implementations.IDnaRepository;
import co.com.mercadolibre.MELIChallenge.services.contracts.DnaService;
import co.com.mercadolibre.MELIChallenge.utils.DnaSequenceFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnaServiceImplementation implements DnaService {

	private static final Pattern dnaPattern = Pattern.compile("[atcg]+");

	@Autowired
	IDnaRepository dnaRepository;

	@Override
	public boolean isMutant(DnaRequest dnaRequest) {
		try{

			String fullSequence = dnaRequest.getDna()
					.stream()
					.reduce((fullStringSequence, individualSequence) -> {
						return fullStringSequence + individualSequence;
					})
					.orElse("NON");

			Optional<Dna> dnaAlreadyChecked = dnaRepository.findIfTheDnaSequenceAlreadyExistOnDB(fullSequence);

			if(!dnaAlreadyChecked.isPresent()){
				DnaSequenceFinder dnaSequenceFinder = new DnaSequenceFinder(loadDnaSequence(dnaRequest));
				Dna dna = new Dna();
				boolean isMutant = dnaSequenceFinder.validateIfIsMutant();

				dna.setDnaSequence(fullSequence);
				dna.setIsMutant(isMutant ? DnaType.MUTANT.getType() : DnaType.HUMAN.getType());
				dnaRepository.save(dna);
				return isMutant;
			}else{
				boolean isMutant = dnaAlreadyChecked.get().getIsMutant().equals(DnaType.MUTANT.getType());
				return isMutant;
			}

		}catch (Exception e){
			System.err.println("error" + e);
		}
		return false;
	}



	private char[][] loadDnaSequence(DnaRequest dnaRequest) throws Exception {
		if(dnaRequest.getDna().isEmpty()) { throw new DnaSequenceCouldNotBeEmptyException("The given dna sequence is empty, could not be processed"); }
		
		int numberOfRows = dnaRequest.getDna().size();
		int firstLineLength = dnaRequest.getDna().get(0).length();
		boolean isTheDataConsistent = dnaRequest.getDna().stream().allMatch(seq -> seq.length() == firstLineLength);
		int numberOfColumns = isTheDataConsistent ? firstLineLength : 0;
		
		if(numberOfRows != numberOfColumns) {
			String missingField = numberOfColumns > numberOfRows ? "Rows": "Columns";
			String completeField = missingField.equals("Rows") ? "Columns" : "Rows";
			throw new DnaSequenceShouldBeSymmetricException(String.format("The given dna data is incomplete, there is more [%s] than [%s]", missingField, completeField));
		}
		char dnaSeq[][] = new char[numberOfRows][numberOfColumns];
		
		for (int i = 0; i < numberOfRows; i++) {
			String dnaRow = dnaRequest.getDna().get(i).toLowerCase();
			if(!dnaPattern.matcher(dnaRow).matches()) { throw new NitrogenousBaseNotRecognizedException("The provided data does not contain valid nitrogenous base"); }
			dnaSeq[i] = dnaRow.toCharArray();
		}
		return dnaSeq;
	}
}
