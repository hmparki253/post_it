package com.phm.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phm.community.entity.Board;
import com.phm.community.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model theModel) {
		// db로부터 board 목록 가져오기
		List<Board> boards = boardService.getBoards();
		
		theModel.addAttribute("boards", boards);
		
		return "/board/list";
	}
	
	@GetMapping("/write")
	public String write(Model theModel) {
		return "/board/write";
	}
}
