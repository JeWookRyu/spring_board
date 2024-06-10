package net.musecom.spboard.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import net.musecom.spboard.dao.SpBoardDao;
import net.musecom.spboard.dao.UploadDao;
import net.musecom.spboard.dto.SpBoardDto;

@Service
public class SpSetContentEditService implements SpService {
   
	@Autowired
    SpBoardDao dao;	
	
	@Autowired
	UploadDao udao;

    @Override
	public void excute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest) map.get("request");
		
		SpBoardDto dto = new SpBoardDto();
		
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setWriter(req.getParameter("writer"));
		dto.setPass(req.getParameter("pass"));
		dto.setImnum(req.getParameter("imnum"));
		dto.setId(Integer.parseInt(req.getParameter("id")));
		
		dao.update(dto);
		
		Map<String, Object> paramsFile = new HashMap<>();
		paramsFile.put("jboard_id", dto.getId());
		paramsFile.put("imnum", dto.getImnum());
		
		udao.updateFile(paramsFile);
		
	}

}
