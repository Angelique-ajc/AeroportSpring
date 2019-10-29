package aeroportSpring.repository;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpring.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("select cp from ClientPhysique cp where cp.adresse.ville =:ville")
	public List <Client> findClientPhysiqueByVille(@Param("ville") String ville);

}
