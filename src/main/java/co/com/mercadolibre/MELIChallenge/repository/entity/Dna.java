package co.com.mercadolibre.MELIChallenge.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "adn")
public class Dna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dnaId;
	private String dnaSequence;
	private Long  isMutant;


	public Long getDnaId() {
		return dnaId;
	}

	public void setDnaId(Long dnaId) {
		this.dnaId = dnaId;
	}

	@Column(name = "DNA_SEQ", length = 400)
	public String getDnaSequence() {
		return dnaSequence;
	}

	public void setDnaSequence(String dnaSequence) {
		this.dnaSequence = dnaSequence;
	}

	@Column(name = "IS_MUTANT", length = 1)
	public Long getIsMutant() {
		return isMutant;
	}

	public void setIsMutant(Long isMutant) {
		this.isMutant = isMutant;
	}
}
