package aeroportSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpring.model.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Long> {

	@Query("select distinct a from Aeroport a where nomAeroport=:nomAeroport")
	public Aeroport findByNomAeroport(@Param("nomAeroport") String nomAeroport);

}
