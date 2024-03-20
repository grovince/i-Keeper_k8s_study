package com.springdemo.bootboard.service;

import java.util.HashMap;
import java.util.List;

import com.springdemo.bootboard.vo.BoardVO;

public interface BoardService {

	int writeBoard(BoardVO board);
	List<BoardVO> findBoard(HashMap<String, Object> params);
	List<BoardVO> findBoardWithPaging(HashMap<String, Object> params);
	BoardVO findBoardByBoardIdx(int boardIdx);
	void deleteBoard(int boardIdx);
	void updateBoard(BoardVO board);
	void increaseHitCount(int boardIdx);
	
}
