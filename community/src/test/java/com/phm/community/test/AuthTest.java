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
import com.phm.community.entity.Board;
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
	
	// Pagination Testing
	// 1번 페이지의 경우 11번부터 2번까지의 row를 가져오는지 확인해준다. 
//	@Test
//	public void selectByNumber() {
//		List<Board> boards = testTableService.getBoardByPagination(2, 10);
//		for(Board board : boards) {
//			logger.info("가져온 값은 : " + board.toString());
//		}
//	}
	
	// pagination testing 실패의 경우를 확인해보기
	// 현재 데이터로 2번 페이지 까지는 1개의 row라도 나오지만 문제는 그 다음 3번 페이지다
//	@Test
//	public void selectByNumberPageThr() {
//		List<Board> boards = testTableService.getBoardByPagination(3, 10);
//		for(Board board : boards) {
//			logger.info("성공입니까 실패입니까? : " + board.toString());
//		}
//	}
	
	@Test
	public void paginationTest() {
		final int curPage = 2;
		final int writingSize = 10;
		final int pageSize = 5;
		
//		List<Board> boards = boardService.getBoardByPagination(curPage, writingSize);
		long totalBoardCount = boardService.getBoardsCount(); // * 총 게시물 갯수
		int totalPageCount = (int) (((totalBoardCount - 1) / writingSize) + 1); // * 총 페이지 수
		
		// ex) 현재 페이지가 3페이지 일 경우 -> 1. 2. 3. 4. 5
		int startPage = ((curPage - 1) / pageSize) * pageSize + 1; // 페이지 시작번호 
		int endPage = Math.min(startPage + pageSize - 1, totalPageCount);
		
		boolean isPre = startPage != 1;
		boolean isNext = endPage < totalPageCount ;
		logger.info("전체 게시글 숫자 : " + totalBoardCount); // 11
		logger.info("전체 페이지 숫자 : " + totalPageCount); // 12
		logger.info("시작 페이지 숫자 : " + startPage); // 1
		logger.info("끝나는 페이지 숫자 : " + endPage); // 12
		logger.info("이전 페이지가 있습니까? : " + isPre);
		logger.info("다음 페이지가 있습니까? : " + isNext);
	}
	
	// 전체 카운트 가져오는 Test function
//	@Test
//	public void selectBoardsCount() {
//		long count = testTableService.getBoardsCount();
//		logger.info("나온 값이 무엇입니까? : " + count);
//	}
	
	// 페이지에 필요한건 해당 게시물들 object, 총 게시물 숫자
	
	
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
	
//	@Test
//	public void selectReplies() {
//		List<Reply> replies = boardService.getRepliesByIdx(19);
//		for(Reply reply : replies) {
//			logger.info("가져온 값은 : " + reply.toString());
//		}
//	}
	
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
