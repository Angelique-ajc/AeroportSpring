package aeroportSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpring.model.Login;



public interface LoginRepository extends JpaRepository<Login, Long >{
	
	@Query("select distinct l from Login l where login=:login")
    public Login findByLogin(@Param("login") String login);
	
	@Query("select distinct l from Login l left join fetch l.client where l.loginId=:id ")
	public Optional <Login> findByIdWithClient(@Param("id") Long id);
}
