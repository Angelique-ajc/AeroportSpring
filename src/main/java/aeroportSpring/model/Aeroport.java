package aeroportSpring.model;

import java.util.Set;

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
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "idVol")
	private Set<Vol> vols;
	@OneToMany(mappedBy = "key.aeroport")
	private Set<Escale> escales;
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

	public Set<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Vol> getVols() {
		return vols;
	}

	public void setVols(Set<Vol> vols) {
		this.vols = vols;
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
