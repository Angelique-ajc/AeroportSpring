package aeroportSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpring.model.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Integer> {

}
