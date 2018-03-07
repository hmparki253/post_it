package com.phm.community.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phm.community.entity.Board;
import com.phm.community.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
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
