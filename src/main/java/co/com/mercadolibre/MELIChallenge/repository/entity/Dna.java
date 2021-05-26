package co.com.mercadolibre.MELIChallenge.repository.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adn")
public class Dna implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dnaId;
	@Column(name = "DNA_SEQ", length = 1500, columnDefinition = "LONGTEXT")
	private String dnaSequence;
	@Column(name = "IS_MUTANT", length = 1)
	private Long  isMutant;


	public Long getDnaId() {
		return dnaId;
	}

	public void setDnaId(Long dnaId) {
		this.dnaId = dnaId;
	}


	public String getDnaSequence() {
		return dnaSequence;
	}

	public void setDnaSequence(String dnaSequence) {
		this.dnaSequence = dnaSequence;
	}


	public Long getIsMutant() {
		return isMutant;
	}

	public void setIsMutant(Long isMutant) {
		this.isMutant = isMutant;
	}
}
