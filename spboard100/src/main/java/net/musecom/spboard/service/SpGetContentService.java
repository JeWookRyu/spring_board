package net.musecom.spboard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import net.musecom.spboard.dao.SpBoardDao;
import net.musecom.spboard.dao.UploadDao;
import net.musecom.spboard.dto.SpBoardDto;

@Service
public class SpGetContentService implements SpService {

	@Autowired
	SpBoardDao dao;
	
	@Override
	public void excute(Model model) {
	  Map<String, Object> map = model.asMap();
	  HttpServletRequest req = (HttpServletRequest) map.get("req");
	  int selectId = Integer.parseInt(req.getParameter("id"));
	  boolean increaseHit = (boolean) map.get("increaseHit");
	  if(increaseHit) { //쿠키가 없을 때만 조회수를 증가한다.
	     dao.increaseHit(selectId);
	  }
	  SpBoardDto dto = dao.selectDetail(selectId);
	  model.addAttribute("dto", dto);
	}

}
