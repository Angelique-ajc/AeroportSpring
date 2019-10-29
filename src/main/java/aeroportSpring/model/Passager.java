package aeroportSpring.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passager")
@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", initialValue = 100, allocationSize = 1)
public class Passager {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@Column(name = "id_passager")
	private long idPassager;

	@Column(name = "nom_passager", length = 150)
	private String nomPassager;

	@Column(name = "prenom_passager", length = 150)
	private String prenomPassager;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "numero_passager")),
			@AttributeOverride(name = "rue", column = @Column(name = "rue_passager", length = 255)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_passager")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "codepostal_passager", length = 5)) })
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="reservation_id_reservation", foreignKey= @ForeignKey(name="salle_id_reservation_fk"))
	private Reservation reservation;
	
	public Passager() {
		
	}

	public Passager(long idPassager, String nomPassager, String prenomPassager, Adresse adresse,
			Reservation reservation) {
		super();
		this.idPassager = idPassager;
		this.nomPassager = nomPassager;
		this.prenomPassager = prenomPassager;
		this.adresse = adresse;
		this.reservation = reservation;
	}


	public long getIdPassager() {
		return idPassager;
	}


	public void setIdPassager(long idPassager) {
		this.idPassager = idPassager;
	}


	public String getNomPassager() {
		return nomPassager;
	}


	public void setNomPassager(String nomPassager) {
		this.nomPassager = nomPassager;
	}


	public String getPrenomPassager() {
		return prenomPassager;
	}


	public void setPrenomPassager(String prenomPassager) {
		this.prenomPassager = prenomPassager;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPassager ^ (idPassager >>> 32));
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
		Passager other = (Passager) obj;
		if (idPassager != other.idPassager)
			return false;
		return true;
	}

}
