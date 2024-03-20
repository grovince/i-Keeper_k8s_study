package com.springdemo.bootboard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.bootboard.mapper.BoardMapper;
import com.springdemo.bootboard.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int writeBoard(BoardVO board) {
		boardMapper.insertBoard(board);
		return board.getBoardIdx();
	}
	
	@Override
	public List<BoardVO> findBoard(HashMap<String, Object> params) {
		return boardMapper.selectBoard(params);
	}
	
	@Override
	public List<BoardVO> findBoardWithPaging(HashMap<String, Object> params) {
		return boardMapper.selectBoardWithPaging(params);
	}

	@Override
	public BoardVO findBoardByBoardIdx(int boardIdx) {
		return boardMapper.selectBoardByBoardIdx(boardIdx);
	}

	@Override
	public void deleteBoard(int boardIdx) {
		boardMapper.deleteBoard(boardIdx);
	}

	@Override
	public void updateBoard(BoardVO board) {
		boardMapper.updateBoard(board);
	}

	@Override
	public void increaseHitCount(int boardIdx) {
		boardMapper.updateHitCount(boardIdx);
	}
	
}














