package net.musecom.spboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.musecom.spboard.dto.UploadFileDto;

@Mapper
public interface UploadMapper {
   
	public int insertFile(UploadFileDto uDto);
	
	public int deleteFile(int uploadId);
	
	public int deleteFileByBoardId(int boardId);
	
	public int deleteTrashFile();
	
	public UploadFileDto selectFileById(int uploadId);
	
	public List<UploadFileDto> selectFileByBoardId(int boardId);
	
	public void updateFile(Map<String, Object> params);
	
}
