package aeroportSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpring.model.Login;


public interface LoginRepository extends JpaRepository<Login, Long >{

	
	
	
	//	public Optional<Salle> findByNom(String nom);
//
//	public List<Salle> findByNomLike(String nom);
//
//	@Query("select s from Salle s where s.nom=:nomDeLaSalle")
//	public List<Salle> findCustomByNomDeLaSalle(@Param("nomDeLaSalle") String nomDeLaSalle);
//	
//	@Query("select distinct s from Salle s left join fetch s.personnes")
//	public List<Salle> findAllCustomWithPersonnes();
//	 
//	@Query("select distinct s from Salle s left join fetch s.personnes where s.id=:id ")
//	public Optional <Salle> findByIdWithPersonnes(@Param("id") Integer id);
}
