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
public class SpSetContentService implements SpService {
   
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
		//dto.setImnum(System.currentTimeMillis() / 1000L); //unix 타임 스탬프 값
		dto.setUserid("GUEST");
		
		if(req.getParameter("refid") != null) {
			//답글일 경우
			dto.setRefid(Integer.parseInt(req.getParameter("refid")));
			dto.setRenum(Integer.parseInt(req.getParameter("renum"))+1);
			dto.setDepth(Integer.parseInt(req.getParameter("depth"))+1);

            Map<String, Object> params = new HashMap();
            params.put("refid", dto.getRefid());
            params.put("renum", dto.getRenum());
            dao.updateRenum(params);		
		}
		
		dao.insert(dto);
		if(req.getParameter("refid") == null) {
		    dao.updateRefId(dto.getId());
		}
		
		Map<String, Object> paramsFile = new HashMap();
		paramsFile.put("jboard_id", dto.getId());
		paramsFile.put("imnum", dto.getImnum());
		
		udao.updateFile(paramsFile);
		
	}

}
