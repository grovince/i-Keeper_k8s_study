package com.springdemo.bootboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springdemo.bootboard.vo.BoardVO;

@Mapper
public interface BoardMapper {

	void insertBoard(BoardVO board);
	List<BoardVO> selectBoard(HashMap<String, Object> params);	
	List<BoardVO> selectBoardWithPaging(HashMap<String, Object> params);	
	BoardVO selectBoardByBoardIdx(int boardIdx);
	void deleteBoard(int boardIdx);
	void updateBoard(BoardVO board);
	void updateHitCount(int boardIdx);
	
}
