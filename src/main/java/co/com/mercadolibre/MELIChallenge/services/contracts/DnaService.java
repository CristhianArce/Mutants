package co.com.mercadolibre.MELIChallenge.services.contracts;

import co.com.mercadolibre.MELIChallenge.dtos.request.DnaRequest;


public interface DnaService {
	boolean isMutant(DnaRequest dnaRequest);
}
