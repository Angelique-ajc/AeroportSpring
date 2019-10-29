package aeroportSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpring.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {

	@Query("select distinct v from Ville v where nomVille=:nomVille")
	public Ville findByNomVille(@Param("nomVille") String nomVille);

}
