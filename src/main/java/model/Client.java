package aeroportjpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_client", discriminatorType = DiscriminatorType.STRING, length = 3)
public abstract class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "id_client")
	private Long idClient;

	@Column(name = "nom_client", length = 150)
	private String nomClient;

	@Column(name = "num_tel_client")
	private int numeroTel;

	@Column(name = "num_fax_client")
	private int numeroFax;

	@Column(name = "email_client", length = 100)
	private String email;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "numero_client")),
			@AttributeOverride(name = "rue", column = @Column(name = "rue_client", length = 255)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_client")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "codepostal_client", length = 5)) })
	private Adresse adresse;

	@Enumerated(EnumType.STRING)
	@Column(name = "titre", length = 2)
	private Titre titre;

	@OneToOne
	@JoinColumn(name="id_login",foreignKey = @ForeignKey(name = "client_id_login_fk"))
	private Login loginClient;

	@Version
	private int version;

	public Client() {
		super();
	}

	public Client(Long idClient, String nomClient, int numeroTel, int numeroFax, String email) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public int getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(int numeroTel) {
		this.numeroTel = numeroTel;
	}

	public int getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(int numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public Login getLogin() {
		return loginClient;
	}

	public void setLogin(Login login) {
		this.loginClient = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		return true;
	}
}
