package aeroportSpring.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
public class Vol {

	@Id
	@Column(name = "id_vol")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	private Long idVol;

	@Column(name = "date_depart_vol")
	@Temporal(TemporalType.DATE)
	private Date dateDepartVol;

	@Column(name = "date_arrivee_vol")
	@Temporal(TemporalType.DATE)
	private Date dateArriveeVol;

	@Column(name = "heure_depart_vol")
	@Temporal(TemporalType.TIME)
	private Date heureDepartVol;

	@Column(name = "heure_arrivee_vol")
	@Temporal(TemporalType.TIME)
	private Date heureArriveeVol;

	@ManyToOne
	@JoinColumn(name = "id_aeroport_depart", foreignKey = @ForeignKey(name = "aeroport_id_aeroport_depart_fk"))
	private Aeroport aeroportDepart;

	@ManyToOne
	@JoinColumn(name = "id_aeroport_arrivee", foreignKey = @ForeignKey(name = "aeroport_id_aeroport_arrivee_fk"))
	private Aeroport aeroportArrivee;

	@OneToMany(mappedBy = "key.vol")
	private Set<CompagnieAerienneVol> compagnieAerienneVols;

	@OneToMany(mappedBy = "vol")
	private Set<Reservation> reservations;

	@OneToMany(mappedBy = "key.vol")
	private Set<Escale> escales;

	@ManyToOne
	@JoinColumn(name = "id_vol_compagnieAerienne", foreignKey = @ForeignKey(name = "id_vol_compagnieAerienne_fk"))
	private CompagnieAerienne compagnieAerienne;
	@Version
	private int version;

	public Vol() {
		super();
	}

	public Long getIdVol() {
		return idVol;
	}

	public void setIdVol(Long idVol) {
		this.idVol = idVol;
	}

	public Date getDateDepartVol() {
		return dateDepartVol;
	}

	public void setDateDepartVol(Date dateDepartVol) {
		this.dateDepartVol = dateDepartVol;
	}

	public Date getDateArriveeVol() {
		return dateArriveeVol;
	}

	public void setDateArriveeVol(Date dateArriveeVol) {
		this.dateArriveeVol = dateArriveeVol;
	}

	public Date getHeureDepartVol() {
		return heureDepartVol;
	}

	public void setHeureDepartVol(Date heureDepartVol) {
		this.heureDepartVol = heureDepartVol;
	}

	public Date getHeureArriveeVol() {
		return heureArriveeVol;
	}

	public void setHeureArriveeVol(Date heureArriveeVol) {
		this.heureArriveeVol = heureArriveeVol;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<CompagnieAerienneVol> getCompagnieAerienneVols() {
		return compagnieAerienneVols;
	}

	public void setCompagnieAerienneVols(Set<CompagnieAerienneVol> compagnieAerienneVols) {
		this.compagnieAerienneVols = compagnieAerienneVols;
	}

	public Set<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVol == null) ? 0 : idVol.hashCode());
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
		Vol other = (Vol) obj;
		if (idVol == null) {
			if (other.idVol != null)
				return false;
		} else if (!idVol.equals(other.idVol))
			return false;
		return true;
	}
}
