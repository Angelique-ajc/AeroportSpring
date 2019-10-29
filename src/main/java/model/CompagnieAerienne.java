package aeroportjpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "compagnie_aerienne")
@SequenceGenerator(name = "seqCompagnieAerienne", sequenceName = "seq_compagnie_aerienne", initialValue = 100, allocationSize = 1)
public class CompagnieAerienne {
	@Id
	@Column(name = "id_compagnie_aerienne")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnieAerienne")
	private Long idCompagnieAerienne;
	@Column(name = "nom_compagnie_aerienne", length = 150)
	private String nomCompagnieAerienne;

	@OneToMany(mappedBy = "compagnieAerienne")
	private Set<Vol> vols;

	@Version
	private int version;

	public CompagnieAerienne() {
		super();
	}

	public CompagnieAerienne(Long idCompagnieAerienne, String nomCompagnieAerienne) {
		super();
		this.idCompagnieAerienne = idCompagnieAerienne;
		this.nomCompagnieAerienne = nomCompagnieAerienne;
	}

	public Long getIdCompagnieAerienne() {
		return idCompagnieAerienne;
	}

	public void setIdCompagnieAerienne(Long idCompagnieAerienne) {
		this.idCompagnieAerienne = idCompagnieAerienne;
	}

	public String getNomCompagnieAerienne() {
		return nomCompagnieAerienne;
	}

	public void setNomCompagnieAerienne(String nomCompagnieAerienne) {
		this.nomCompagnieAerienne = nomCompagnieAerienne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCompagnieAerienne == null) ? 0 : idCompagnieAerienne.hashCode());
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
		CompagnieAerienne other = (CompagnieAerienne) obj;
		if (idCompagnieAerienne == null) {
			if (other.idCompagnieAerienne != null)
				return false;
		} else if (!idCompagnieAerienne.equals(other.idCompagnieAerienne))
			return false;
		return true;
	}

}
