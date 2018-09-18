package com.phm.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.phm.community.dao.FileBean;
import com.phm.community.entity.Board;
import com.phm.community.entity.Reply;
import com.phm.community.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// 게시글 목록 가져오기 
	@GetMapping("/list")
	public String list(Model theModel) {
		List<Board> boards = boardService.getBoards();
		theModel.addAttribute("boards", boards);
		return "/board/list";
	}
	
	// 현재 페이지 기준 게시글 목록 가져오기
	@GetMapping("/list/{curPage}")
	public String list(@PathVariable("curPage") int curPage, Model theModel) {
		final int writingSize = 10; // 한 페이지에서 보여질 게시글의 갯수 
		final int pageSize = 5; // 한 페이지에서 보여질 pagination의 갯수  
		
		List<Board> boards = boardService.getBoardByPagination(curPage, writingSize); // 현재 페이지에 보여질 게시글 objects 
		long totalBoardCount = boardService.getBoardsCount(); // * 총 게시물 갯수
		int totalPageCount = (int) (((totalBoardCount - 1) / writingSize) + 1); // * 총 페이지 수
		
		// ex) 현재 페이지가 3페이지 일 경우 -> 1. 2. 3. 4. 5
		int startPage = ((curPage - 1) / pageSize) * pageSize + 1; // 페이지 시작번호 
		int endPage = Math.min(startPage + pageSize - 1, totalPageCount);
		
		boolean isPre = startPage != 1;
		boolean isNext = endPage < totalPageCount ;
		
		theModel.addAttribute("boards", boards);
		theModel.addAttribute("curPage", curPage);
		theModel.addAttribute("startPage", startPage);
		theModel.addAttribute("endPage", endPage);
		theModel.addAttribute("isPre", isPre);
		theModel.addAttribute("isNext", isNext);
		
		return "/board/list";
	}
	
	// 게시글 읽기
	@GetMapping("/view/{idx}")
	public String view(@PathVariable("idx") int idx, Model theModel) {
		Board board = boardService.getBoard(idx); // 게시글 정보 불러오기 
		
		// 리플들 불러오기
		List<Reply> replies = boardService.getRepliesByIdx(idx);
		
		// 빈 reply object 생성 
		Reply reply = new Reply();
		
		// 조회수 증가 
		board.setHit(board.getHit() + 1); 
		boardService.saveBoard(board);
		
		theModel.addAttribute("board", board);
		theModel.addAttribute("reply", reply);
		theModel.addAttribute("replies", replies);
		
		return "/board/view";
	}
	
	// 게시글 작성 페이지
	@GetMapping("/write")
	public String write(Model theModel) {
		// 뷰에 전달할 객체 생성 및 model에 할당 
		Board board = new Board();
		theModel.addAttribute("board", board);
		return "/board/write";
	}
	
	@PostMapping("/fileUpload")
	public String procFileUpload(FileBean fileBean, HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String rootPath = session.getServletContext().getRealPath("/"); // 웹 애플리케이션 root 경로 얻기 
		String attachPath = "resources/files/attach/";
		
		MultipartFile upload = fileBean.getUpload();
		String fileName = "";
		String CKEditorFuncNum = "";
		
		if(upload != null) {
			fileName = upload.getOriginalFilename();
			fileBean.setFilename(fileName);
			CKEditorFuncNum = fileBean.getCKEditorFuncNum();
			
			try {
				logger.info("====== 저장 경로는? : " + rootPath + attachPath + fileName);
				File file = new File(rootPath + attachPath + fileName);
				logger.info("====== 파일 객체 정보는 ? : " + file.getPath());
				upload.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String filePath = "/community/" + attachPath + fileName;
		logger.info("====== 전달하는 파일 경로는? : " + filePath);
		model.addAttribute("filePath", filePath);
		model.addAttribute("CKEditorFuncNum", CKEditorFuncNum);
		
		return "/board/fileupload";
	}
	
	// 게시글 저장 
	@PostMapping("/saveBoard")
	public String saveBoard(@ModelAttribute("board") Board board) {
		board.setRegDt(new Date());
		board.setEnabled(1);
		boardService.saveBoard(board);
		// 작성 후 목록페이지로 리다이렉트
		return "redirect:/board/list";
	}
	
	// 게시글 삭제 
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("idx") String idx) {
		boardService.deleteBoard(Integer.parseInt(idx));
		return "redirect:/board/list";
	}
	
	// 게시글 수정 
	@GetMapping("/modifyBoard")
	public String modifyBoard(@RequestParam("idx") String idx, Model model) {
		Board board = boardService.getBoard(Integer.parseInt(idx));
		model.addAttribute("board", board);
		return "/board/modify";
	}
	
	@PostMapping("/addReply")
	public String addReply(@RequestParam("boardIdx") String boardIdx,
			@ModelAttribute("reply") Reply reply) {
		// 덧글 새로 입력 function
		logger.info("@@@@@@@@@@@@@recognition here!!!@@@@@@@@@");
		
		// boardIdx 관련 값 세팅
		reply.setBoardIdx(Integer.parseInt(boardIdx));
		reply.setFamily(0);	// family 값 0 세팅
		// 작성시간 세팅
		reply.setRegDt(new Date());
		// enabled값 세팅
		reply.setEnabled(1);
		
		boardService.saveOrUpdateReply(reply);		
		reply.setFamily((int)boardService.getLastInsertId()); // 최근 insert 되었던 family 값으로 update 
		boardService.saveOrUpdateReply(reply);
		
		// 작성 후 해당 게시글로 redirection   
		return "redirect:/board/view/" + boardIdx;
	}
	
	@PostMapping("/addRereply")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String addRereply(@RequestBody Reply reply) {
		reply.setIndent(reply.getIndent() + 1);
		reply.setDepth(reply.getDepth() + 1);
		reply.setRegDt(new Date());
		reply.setEnabled(1);
		logger.info("--------------------------------------------------------------------------------------");
		logger.info(reply.toString());
		logger.info("--------------------------------------------------------------------------------------");
		boardService.saveOrUpdateReply(reply);
		return "ok";
	}
	
	
	// 남은 작업
	// 2. 가져온 리플목록 family와 depth에 따라 css 처리 및 화면 디자인
	
}
