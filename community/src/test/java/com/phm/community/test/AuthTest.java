package com.phm.community.test;

import java.util.List;
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
import com.phm.community.entity.Reply;
import com.phm.community.service.BoardService;
import com.phm.community.service.TestTableService;
import com.phm.community.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, SecurityConfig.class })
@WebAppConfiguration
public class AuthTest {

	@Autowired
	UserService userService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	TestTableService testTableService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
//	@Test
//	public void insertTestTable() {
//		String test = "nonenono";
//		testTableService.saveTestTable(new TestTable(test));
//		
//		long idx = testTableService.getLastInsertId();
//		logger.info(idx+"");
//		
//		TestTable testTable = testTableService.getTestTable((int)idx);
//		testTable.setLetters(testTable.getIdx() + "");
//		testTableService.saveTestTable(testTable);
//	}
	
//	@Test
//	public void insertReply() {
//		Reply reply = new Reply(19,1,0,0,0,"goodeyo","content",new Date(),1);
//		boardService.saveOrUpdateReply(reply);
//	}
	
	@Test
	public void selectReplies() {
		List<Reply> replies = boardService.getRepliesByIdx(19);
		for(Reply reply : replies) {
			logger.info("가져온 값은 : " + reply.toString());
		}
	}
	
//	@Test
//	public void getLastInsertId() {
//		long idx = testTableService.getLastInsertId();
//		assertEquals(10, idx);
//	}
//	
//	@Test
//	public void testIdCheckFalse() {
//		String username = ""; // 존재하는 username 
//		boolean result = userService.checkId(username);
//		assertFalse(result);
//	}
//	
//	@Test
//	public void testEmailCheckFalse() {
//		String email = "goodeyo@naver.com"; // 존재하는 email
//		boolean result = userService.checkEmail(email);
//		assertTrue(result);
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
	
//	@Test
//	public void encryptPassword() {
//		String password = "{bcrypt}" + passwordEncoder.encode("fun123");
//		String confirmPassword = "{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K";
//		
//		logger.info("입력 값 : " + password);
//		logger.info("원하는 값 : " + confirmPassword);
//		
//		assertEquals(password, confirmPassword);
//	}
//	
//	@Test
//	public void insertNewUser() {
//		User user = new User("conan", "conandoil", "obrien", "doggystyle@doggy.com", 1);
//		List<Authority> authorities = new ArrayList<>();
//		authorities.add(new Authority("ROLE_SUPER"));
//		authorities.add(new Authority("ROLE_ADMIN"));
//		userService.saveUserAndAuthorities(user, authorities);
//	}
	
//	@Test
//	public void deleteFromBoard(int idx) {
//		boardService.deleteBoard(idx);
//		assertEquals("1","1"); // 뒷 부분의 데이터의 숫자를 확인해줘야한다.
//	}
}
