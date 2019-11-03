package aeroportSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpring.model.Aeroport;
import aeroportSpring.model.Ville;

public interface AeroportRepository extends JpaRepository<Aeroport, Long> {

	// retourne l'objet aeroport dont le nom correspond au nom à renseigner
	@Query("select distinct a from Aeroport a where nomAeroport=:nomAeroport")
	public Aeroport findByNomAeroport(@Param("nomAeroport") String nomAeroport);

	// retourne les aéroports présents dans la ville à renseigner
	@Query("select distinct a from Aeroport a left join fetch a.villeAeroport where a.villeAeroport=:villeAeroport")
	public List<Aeroport> findByVille(@Param("villeAeroport") Ville villeAeroport);

}
