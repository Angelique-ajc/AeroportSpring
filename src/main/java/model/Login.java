package aeroportjpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import aeroportjpa.model.Client;

@Entity
@Table(name="login")
@SequenceGenerator(name="seqLogin",sequenceName="seq_login",initialValue=100, allocationSize=5)
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqLogin")
	@Column(name = "id_login")
	private long loginId;
	
	@Column(name = "login_login", length = 15)
	private String login;
	
	@Column(name = "mot_de_passe_login", length = 10)
	private String motDePasse;
	
	@Column(name = "admin_login")
	private Boolean admin;
	
	@OneToOne(mappedBy="loginClient")
	private Client client;
	
	
	@Version
	private int version;

	
	public Login() {
		super();
	}
	
	public Login(long loginId, String login, String motDePasse, Boolean admin) {
		super();
		this.loginId = loginId;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (loginId ^ (loginId >>> 32));
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
		Login other = (Login) obj;
		if (loginId != other.loginId)
			return false;
		return true;
	}
}
