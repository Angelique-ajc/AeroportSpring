package aeroportSpringTest;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aeroportSpring.model.Aeroport;
import aeroportSpring.repository.AeroportRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class AeroportRepositoryTest {

	@Autowired
	private AeroportRepository aeroportRepository;

	@Test
	// créer une entrée
	public void testInsert() {
		Aeroport aeroport = new Aeroport("bibi");
		aeroportRepository.save(aeroport);
		Optional<Aeroport> opt = aeroportRepository.findById(aeroport.getIdAeroport());
		opt.isPresent();
		assertTrue(opt.isPresent());
	}

	@Test
	// on teste qu'on trouve bien un aéroport bibi
	public void testFindByNom() {
		assertNotEquals(0, aeroportRepository.findByNomAeroport("bibi"));
	}

}
