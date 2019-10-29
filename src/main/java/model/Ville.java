package aeroportjpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ville")
@SequenceGenerator(name = "seqVille", sequenceName = "seq_ville", initialValue = 1, allocationSize = 1)
@NamedQueries({
		@NamedQuery(name = "Ville.findByKeyWithAeroports", query = "select distinct v from Ville v left join fetch v.aeroports where v.idVille=:id"),
		@NamedQuery(name = "Ville.findAllWithAeroports", query = "select distinct v from Ville v left join fetch v.aeroports") })
public class Ville {
	@Id
	@Column(name = "id_ville")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVille")
	private Long idVille;
	@Column(name = "nom_ville", length = 150)
	private String nomVille;
	@OneToMany(mappedBy = "villeAeroport")
	private Set<Aeroport> aeroports;
	@Version
	private int version;

	// constructeur vide
	public Ville() {
	}

	// autres constructeurs
	public Ville(String nomVille) {
		super();
		this.nomVille = nomVille;
	}

	// getter et setter
	public Long getIdVille() {
		return idVille;
	}

	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public Set<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(Set<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}

	// hashCode et equals sur id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVille == null) ? 0 : idVille.hashCode());
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
		Ville other = (Ville) obj;
		if (idVille == null) {
			if (other.idVille != null)
				return false;
		} else if (!idVille.equals(other.idVille))
			return false;
		return true;
	}

}
