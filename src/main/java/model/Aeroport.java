package aeroportjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "aeroport")
@SequenceGenerator(name = "seqAeroport", sequenceName = "seq_aeroport", initialValue = 1, allocationSize = 1)
@NamedQueries({
		@NamedQuery(name = "Aeroport.findByKeyWithVilles", query = "select distinct a from Aeroport a left join fetch a.villeAeroport where a.idAeroport=:id"),
		@NamedQuery(name = "Aeroport.findAllWithVilles", query = "select distinct a from Aeroport a left join fetch a.villeAeroport") })
public class Aeroport {
	@Id
	@Column(name = "id_aeroport")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	private Long idAeroport;
	@Column(name = "nom_aeroport", length = 150)
	private String nomAeroport;
	@ManyToOne
	@JoinColumn(name = "id_ville_aeroport", foreignKey = @ForeignKey(name = "aeroport_id_ville_fk"))
	private Ville villeAeroport;
	@Version
	private int version;

	// constructeur vide
	public Aeroport() {
	}

	// autres constructeurs
	public Aeroport(String nomAeroport) {
		super();
		this.nomAeroport = nomAeroport;
	}

	// Getter et setter
	public Long getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(Long idAeroport) {
		this.idAeroport = idAeroport;
	}

	public String getNomAeroport() {
		return nomAeroport;
	}

	public void setNomAeroport(String nomAeroport) {
		this.nomAeroport = nomAeroport;
	}

	public Ville getVilleAeroport() {
		return villeAeroport;
	}

	public void setVilleAeroport(Ville villeAeroport) {
		this.villeAeroport = villeAeroport;
	}

	// hashCode et equals sur id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAeroport == null) ? 0 : idAeroport.hashCode());
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
		Aeroport other = (Aeroport) obj;
		if (idAeroport == null) {
			if (other.idAeroport != null)
				return false;
		} else if (!idAeroport.equals(other.idAeroport))
			return false;
		return true;
	}

}
