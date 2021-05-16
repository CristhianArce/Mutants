package co.com.mercadolibre.MELIChallenge.controllers;

import co.com.mercadolibre.MELIChallenge.services.contracts.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import co.com.mercadolibre.MELIChallenge.dtos.request.DnaRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/mutant")
public class DnaControlller {

	@Autowired
	private DnaService dnaService;
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity checkIfIsMutant(@NotNull @RequestBody DnaRequest dnaRequest) {
		int status = dnaService.isMutant(dnaRequest) ? HttpServletResponse.SC_OK : HttpServletResponse.SC_FORBIDDEN;
		return ResponseEntity.status(status).build();
	}
	
	

}
