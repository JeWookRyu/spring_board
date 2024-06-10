package net.musecom.spboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.musecom.spboard.dto.SpBoardDto;

@Repository
public class SpBoardDao implements SpBoardMapper {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(SpBoardDto dto) {
		// TODO Auto-generated method stub
		return session.insert("insert", dto);
	}

	@Override
	public int update(SpBoardDto dto) {
		// TODO Auto-generated method stub
		return session.update("update", dto);
	}

	@Override
	public int delete(int selectId) {
		// TODO Auto-generated method stub
		return session.delete("delete", selectId);
	}

	@Override
	public int selectTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("selectTotalCount");
	}

	@Override
	public SpBoardDto selectDetail(int selectId) {
		return session.selectOne("selectDetail", selectId);
	}

	@Override
	public List<SpBoardDto> selectList(Map<String, Object> params) {
		return session.selectList("selectList", params);
	}
	
	@Override
	public void increaseHit(int selectId) {
		session.update("increaseHit", selectId);
	}
	
	@Override
	public void updateRefId(int id) {
		session.update("updateRefId", id);		
	}

	@Override
	public void updateRenum(Map<String, Object> params) {
		session.update("updateRenum", params);
		
	}
	
	@Override
	public int validatePass(Map<String, Object> params) {
		return session.selectOne("validatePass", params);
	}
}
