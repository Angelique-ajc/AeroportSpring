package aeroportSpring;

import java.util.Optional;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aeroportSpring.model.Login;
import aeroportSpring.repository.LoginRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class LoginRepositoryTest {

	@Autowired
	private LoginRepository loginRepository;

	@Test
	public void testInsert() {
		Login login = new Login("login1");
		loginRepository.save(login);
		Optional<Login> opt = loginRepository.findById(login.getLoginId());
		assertTrue(opt.isPresent());
	}
}
