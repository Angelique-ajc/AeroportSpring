package aeroportjpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("CEI")
@NamedQueries({
@NamedQuery(name="ClientEI.findAllClientEI", 
		query="select cei from ClientEI cei"),
@NamedQuery(name="ClientEI.findClientEIByVille",
		query="select cei from ClientEI cei where lower(cei.adresse.ville) like :ville")
})
public class ClientEI extends Client {

	@Column(name = "prenom_client",length=100)
	private String prenomEI;

	public ClientEI() {
	}

	public String getPrenomEI() {
		return prenomEI;
	}

	public void setPrenomEI(String prenomEI) {
		this.prenomEI = prenomEI;
	}

}
