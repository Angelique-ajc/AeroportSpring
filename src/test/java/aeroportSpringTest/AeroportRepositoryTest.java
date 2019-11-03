package aeroportSpringTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aeroportSpring.model.Aeroport;
import aeroportSpring.model.Ville;
import aeroportSpring.repository.AeroportRepository;
import aeroportSpring.repository.VilleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
@Rollback(true)
public class AeroportRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private AeroportRepository aeroportRepository;
	@Autowired
	private VilleRepository villeRepository;

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
	public void testFindByNomAeroport() {
		assertNotEquals(0, aeroportRepository.findByNomAeroport("bibi"));
	}

	@Test
	// on teste qu'on trouve tous les aéroports de la ville Osaka
	public void findByVille() {
		Ville v = new Ville("Osaka");
		villeRepository.save(v);
		Aeroport aeroport1 = new Aeroport("Osaka Airport");
		aeroport1.setVilleAeroport(v);
		aeroportRepository.save(aeroport1);
		Aeroport aeroport2 = new Aeroport("Sushi Airport");
		aeroport2.setVilleAeroport(v);
		aeroportRepository.save(aeroport2);
		List<Aeroport> results = aeroportRepository.findByVille(v);
		assertEquals(2, results.size());
	}

	@Test
	// on teste qu'il n'y a pas d'aéroport à Châlons
	public void findByVilleSansAeroport() {
		Ville v = new Ville("Châlons");
		villeRepository.save(v);
		List<Aeroport> aeroports = aeroportRepository.findByVille(v);
		assertEquals(0, aeroports.size());
	}
}
