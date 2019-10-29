package aeroportSpring;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aeroportSpring.model.Client;
import aeroportSpring.model.ClientEI;
import aeroportSpring.model.ClientMoral;
import aeroportSpring.model.ClientPhysique;
import aeroportSpring.model.Login;
import aeroportSpring.repository.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class ClientRepositoryTest {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	public void testInsertClientEI() {
		ClientEI clientEI = new ClientEI("clientEI2");
		clientRepository.save(clientEI);
		Optional<Client> opt = clientRepository.findById(clientEI.getIdClient());
		assertTrue(opt.isPresent());
	}
	
	@Test
	public void testInsertClientMoral() {
		ClientMoral clientM = new ClientMoral("siret 1");
		clientRepository.save(clientM);
		Optional<Client> opt = clientRepository.findById(clientM.getIdClient());
		assertTrue(opt.isPresent());
	}
	
	@Test
	public void testInsertClientPhysique() {
		ClientPhysique clientP = new ClientPhysique("client physique 1");
		clientRepository.save(clientP);
		Optional<Client> opt = clientRepository.findById(clientP.getIdClient());
		assertTrue(opt.isPresent());
	}
	
	@Test 
	public void testFindClientPhysiqueByVille() {
		assertNotEquals(0, clientRepository.findClientPhysiqueByVille("paris"));
	}
	
}
