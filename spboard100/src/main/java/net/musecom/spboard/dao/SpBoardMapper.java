package net.musecom.spboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.musecom.spboard.dto.SpBoardDto;

@Mapper
public interface SpBoardMapper {
    //insert
	public int insert(SpBoardDto dto);
    
	//update
	public int update(SpBoardDto dto);
	
	//delete
	public int delete(int selectId);
	
	//전체 게시글 수
	public int selectTotalCount();
	
	//상세보기
	public SpBoardDto selectDetail(int selectId);
	
	//목록보기
	public List<SpBoardDto> selectList(Map<String, Object> params);
	
	//조회수 증가
	public void increaseHit(int selectId);
	
	//refid 업데이트
	public void updateRefId(int id);
	
	//답글 수 증가
	public void updateRenum(Map<String, Object> params);
	
	//비밀번호 검증
	public int validatePass(Map<String, Object> params);
} 
