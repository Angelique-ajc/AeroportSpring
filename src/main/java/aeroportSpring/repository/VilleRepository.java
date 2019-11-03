package aeroportSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpring.model.Aeroport;
import aeroportSpring.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {

	// retourne l'objet ville dont le nom correspond au nom � renseigner
	@Query("select distinct v from Ville v where nomVille=:nomVille")
	public Ville findByNomVille(@Param("nomVille") String nomVille);

	// retourne l'objet ville dans lequel se trouve l'a�roport � renseigner
	// "member of" �quivaut � un IN en SQL
	@Query("select v from Ville v where :aeroport member of v.aeroports")
	public Ville findByAeroport(@Param("aeroport") Aeroport aeroport);

	// retourne toutes les villes qui poss�dent un a�roport du nom � renseigner
	@Query("select v from Ville v left join fetch v.aeroports a where a.nomAeroport=:nomAeroport")
	public List<Ville> findByNomAeroport(@Param("nomAeroport") String nomAeroport);
}
