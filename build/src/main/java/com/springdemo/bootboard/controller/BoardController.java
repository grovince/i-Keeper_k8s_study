package com.springdemo.bootboard.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.bootboard.service.BoardService;
import com.springdemo.bootboard.ui.ThePager;
import com.springdemo.bootboard.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	BoardService boardService;
	
	@GetMapping("/list")
	public String showBoardList(Model model, HttpServletRequest req,	
	@RequestParam(defaultValue = "1") int pageNo,
	@RequestParam(required = false) String searchType,
	@RequestParam(required = false) String searchKey) {
		
		int pageSize = 3;
		int pagerSize = 3;
		HashMap<String, Object> params = new HashMap<>();
		int beginning = (pageNo - 1) * pageSize + 1;
		params.put("beginning", beginning);
		params.put("end", beginning + pageSize);
		params.put("searchType", searchType);
		params.put("searchKey", searchKey);
		
		//List<BoardVO> boards = boardService.findBoardWithPaging(params);
		List<BoardVO> boards = boardService.findBoard(params);

//		if (boards.size() > 0) {
//			ThePager pager = new ThePager(boards.size(), pageNo, pageSize, pagerSize, "list.action", req.getQueryString());
//			model.addAttribute("pager", pager);
//		}
		
		model.addAttribute("boards", boards);

		return "board/list";
	}
	
	@GetMapping("/write")
	public String showWriteForm() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String writeBoard(BoardVO board) {
		 if (board == null) return "redirect:/board/list";
		 boardService.writeBoard(board);
		 
		 return "redirect:/board/detail/" + board.getBoardIdx();
	}
	
	@GetMapping(path = {"/detail/{boardIdx}"})
	public String showDetail(@PathVariable("boardIdx") int boardIdx, Model model) {
		BoardVO board = boardService.findBoardByBoardIdx(boardIdx);
		if (board == null) return "redirect:/board/list";
		
		boardService.increaseHitCount(boardIdx);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@GetMapping("/edit/{boardIdx}")
	public String showEditForm(@PathVariable("boardIdx") int boardIdx, Model model) {
		model.addAttribute("board", boardService.findBoardByBoardIdx(boardIdx));
		
		return "board/edit";
	}
	
	@PostMapping("/edit")
	public String editBoard(BoardVO board) {
		
		board.setUpdaterId(board.getCreatorId());
		System.out.println(board.toString());
		boardService.updateBoard(board);
		
		return "redirect:/board/detail/" + board.getBoardIdx();
	}
	
	@GetMapping("/delete/{boardIdx}")
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) {
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/list";
	}
}
