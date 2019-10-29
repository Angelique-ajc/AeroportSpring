package aeroportSpring;

import java.util.Optional;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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
		Login login = new Login("login5");
		loginRepository.save(login);
		Optional<Login> opt = loginRepository.findById(login.getLoginId());
		assertTrue(opt.isPresent());
	}
	
	@Test
	public void testFindAll() {
		Pageable page0Avec2Element = PageRequest.of(0, 1, Sort.by(Order.asc("login")));
		Page<Login> page = loginRepository.findAll(page0Avec2Element);
		assertEquals(0, page.getContent().size());
		System.out.println(page);
	}
	
	
	@Test
	public void findByLogin() {
		  assertNotEquals(0, loginRepository.findByLogin("login1"));
	}

}
