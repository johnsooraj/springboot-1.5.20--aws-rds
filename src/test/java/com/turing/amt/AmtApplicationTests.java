package com.turing.amt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.turing.amt.user.repository.UserEntityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmtApplicationTests {

	@MockBean
	UserEntityRepository userEntityRepository;
	
	@Test
	public void contextLoads() {
		userEntityRepository.findAll();
	}

}
