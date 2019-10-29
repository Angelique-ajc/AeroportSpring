package aeroportSpringTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aeroportSpring.model.Ville;
import aeroportSpring.repository.VilleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class VilleRepositoryTest {

	@Autowired
	private VilleRepository villeRepository;

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
		assertNotEquals(0, villeRepository.findByNomVille("Tokyo"));
	}

}
