package aeroportjpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@DiscriminatorValue("CP")
@NamedQueries({
	@NamedQuery(name="ClientPhysique.findAllClientPhysique", 
			query="select cp from ClientPhysique cp"),
	@NamedQuery(name="ClientPhysique.findClientPhysiqueByVille",
			query="select cp from ClientPhysique cp where lower(cp.adresse.ville) like :ville")
})
public class ClientPhysique extends Client {

	@Column(name = "prenom_client",length=100)
	private String prenomCP;

	public ClientPhysique() {
	}

	public String getPrenomCP() {
		return prenomCP;
	}

	public void setPrenomCP(String prenomCP) {
		this.prenomCP = prenomCP;
	}

}
