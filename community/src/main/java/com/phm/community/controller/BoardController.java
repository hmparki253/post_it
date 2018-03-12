package com.phm.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.phm.community.dao.FileBean;
import com.phm.community.entity.Board;
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
	
	// 게시글 읽기
	@GetMapping("/view/{idx}")
	public String view(@PathVariable("idx") int idx, Model theModel) {
		Board board = boardService.getBoard(idx);
		theModel.addAttribute("board", board);
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
		// 서비스를 통한 board 추가
		// 추후에는 hidden의 데이터를 이용해야함 
		board.setWriter("테스트맨");
		board.setRegDt(new Date());
		boardService.saveBoard(board);
		// 작성 후 목록페이지로 리다이렉트
		return "redirect:/board/list";
	}
	
	
}
