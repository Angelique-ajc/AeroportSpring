package aeroportSpring.model;

import java.util.Date;

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
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", initialValue = 1, allocationSize = 1)
public class Reservation {
	@Id
	@Column(name = "id_reservation")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	private Long id;
	@Column(name = "date_reservation")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "numero_reservation")
	private Integer numero;
	@ManyToOne
	@JoinColumn(name = "id_vol_reservation", foreignKey = @ForeignKey(name = "reservation_id_vol_fk"))
	private Vol vol;
	@ManyToOne
	@JoinColumn(name = "id_client_reservation", foreignKey = @ForeignKey(name = "reservation_id_client_fk"))
	private Client client;
	@ManyToOne
	@JoinColumn(name = "id_passager_reservation", foreignKey = @ForeignKey(name = "reservation_id_passager_fk"))
	private Passager passager;
	@Version
	private int version;

	// constructeur vide
	public Reservation() {
	}

	// getter et setter
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	// hashCode et equals sur l'id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
