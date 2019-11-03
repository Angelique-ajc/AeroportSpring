package aeroportSpringTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class VilleRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private AeroportRepository aeroportRepository;

	@Test
	// créer une entrée
	public void testInsert() {
		Ville ville = new Ville("Tokyo");
		villeRepository.save(ville);
		Optional<Ville> opt = villeRepository.findById(ville.getIdVille());
		opt.isPresent();
		assertTrue(opt.isPresent());
	}

	@Test
	// on teste qu'on trouve bien la ville Tokyo
	public void findByNomVille() {
		Ville ville = new Ville("Tokyo");
		villeRepository.save(ville);
		assertNotNull(villeRepository.findByNomVille("Tokyo"));
	}

	@Test
	// on teste que l'aéroport AeroTest appartient bien à la ville Tokyo
	public void findByAeroport() {
		Ville ville = new Ville("Tokyo");
		villeRepository.save(ville);
		Aeroport aeroport = new Aeroport("AeroTest");
		aeroport.setVilleAeroport(ville);
		aeroportRepository.save(aeroport);
		Ville result = villeRepository.findByAeroport(aeroport);
		assertNotNull(result);
		assertEquals("Tokyo", result.getNomVille());
	}

	@Test
	// on teste que les deux villes ressortent quand on chetrche l'aéroport
	// AeroTest2
	public void findByNomAeroport() {
		// on crée deux villes différentes
		Ville ville = new Ville("Tokyo");
		villeRepository.save(ville);
		Ville ville1 = new Ville("Paris");
		villeRepository.save(ville1);
		// on crée deux aéroports du même nom dans deux villes différentes
		Aeroport aeroport = new Aeroport("AeroTest2");
		aeroport.setVilleAeroport(ville);
		aeroportRepository.save(aeroport);
		Aeroport aeroport1 = new Aeroport("AeroTest2");
		aeroport1.setVilleAeroport(ville1);
		aeroportRepository.save(aeroport1);
		List<Ville> villes = villeRepository.findByNomAeroport("AeroTest2");
		assertEquals(2, villes.size());
	}
}
