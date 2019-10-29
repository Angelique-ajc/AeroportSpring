package aeroportjpa.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	private Integer numero;
	private String rue; 
	private String ville;
	private String codePostal;
	
	public Adresse() {
		super();
	}

	public Adresse(Integer numero, String rue, String ville, String codePostal) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}



	public Adresse(String ville) {
		super();
		this.ville = ville;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
