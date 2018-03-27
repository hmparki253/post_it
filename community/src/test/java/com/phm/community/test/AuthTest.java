package com.phm.community.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.phm.community.config.AppConfig;
import com.phm.community.config.SecurityConfig;
import com.phm.community.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, SecurityConfig.class })
@WebAppConfiguration
public class AuthTest {

	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
//	@Test
//	public void testIdCheckFalse() {
//		String username = "goodeyo6163"; // 존재하는 username 
//		boolean result = userService.checkId(username);
//		assertFalse(result);
//	}
//	
//	@Test
//	public void testEmailCheckFalse() {
//		String email = "goodeyo1232@naver.com"; // 존재하는 email
//		boolean result = userService.checkEmail(email);
//		assertFalse(result);
//	}
//	
//	@Test
//	public void testIdCheckTrue() {
//		String username = "goodeyo";
//		boolean result = userService.checkId(username);
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testEmailCheckTrue() {
//		String email = "goodeyo@naver.com";
//		boolean result = userService.checkEmail(email);
//		assertTrue(result);
//	}
	
	@Test
	public void encryptPassword() {
		String password = "{bcrypt}" + passwordEncoder.encode("fun123");
		String confirmPassword = "{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K";
		
		logger.info("입력 값 : " + password);
		logger.info("원하는 값 : " + confirmPassword);
		
		assertEquals(password, confirmPassword);
	}
//	
//	@Test
//	public void insertNewUser() {
//		User user = new User("conan", "conandoil", "obrien", "doggystyle@doggy.com", 1);
//		List<Authority> authorities = new ArrayList<>();
//		authorities.add(new Authority("ROLE_SUPER"));
//		authorities.add(new Authority("ROLE_ADMIN"));
//		userService.saveUserAndAuthorities(user, authorities);
//	}
}
