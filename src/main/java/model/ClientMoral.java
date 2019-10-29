package aeroportjpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("CM")
@NamedQueries({ @NamedQuery(name = "ClientMoral.findAllClientMoral", query = "select cm from ClientMoral cm"),
		@NamedQuery(name = "ClientMoral.findClientMoralByVille", query = "select cm from ClientMoral cm where lower(cm.adresse.ville) like :ville") })
public class ClientMoral extends Client {

	@Column(name = "siret_client",length=20)
	private String siret;

	public ClientMoral() {
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

}
