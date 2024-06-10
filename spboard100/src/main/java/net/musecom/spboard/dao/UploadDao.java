package net.musecom.spboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.musecom.spboard.dto.UploadFileDto;

@Repository
public class UploadDao implements UploadMapper {

	@Autowired
	private SqlSession session;  
	
	@Override
	public int insertFile(UploadFileDto uDto) {
		// TODO Auto-generated method stub
		return session.insert("insertFile", uDto);
	}

	@Override
	public int deleteFile(int uploadId) {
		// TODO Auto-generated method stub
		return session.delete("deleteFileById", uploadId);
	}

	@Override
	public int deleteFileByBoardId(int boardId) {
		// TODO Auto-generated method stub
		return session.delete("deleteFileByJboardId", boardId);
	}

	@Override
	public int deleteTrashFile() {
		// TODO Auto-generated method stub
		return session.delete("deleteTrashFile");
	}

	@Override
	public UploadFileDto selectFileById(int uploadId) {
		// TODO Auto-generated method stub
		return session.selectOne("selectById", uploadId);
	}

	@Override
	public List<UploadFileDto> selectFileByBoardId(int boardId) {
		// TODO Auto-generated method stub
		return session.selectList("selectByBoardId", boardId);
	}

	@Override
	public void updateFile(Map<String, Object> params) {
		
		session.update("updateFile", params);
		
	}

}
