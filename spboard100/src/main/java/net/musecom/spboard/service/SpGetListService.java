package net.musecom.spboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import net.musecom.spboard.dao.SpBoardDao;
import net.musecom.spboard.dto.SpBoardDto;
import net.musecom.spboard.util.Paging;

@Service
public class SpGetListService implements SpService {

	@Autowired
	Paging pg;
	@Autowired
	SpBoardDao dao;
	
	@Override
	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		int currentPage = (int) map.get("cpg");
		int postsPerPage = 10; 
		int pagesPerBlock = 5; 
		int totalPosts = dao.selectTotalCount();
		pg.setCurrentPage(currentPage);
		pg.setPagesPerBlock(pagesPerBlock);
		pg.setPostsPerPage(postsPerPage);
		pg.setTotalPosts(totalPosts);
		int limitCount = (currentPage - 1) * postsPerPage;
		
        map.put("currentPage", limitCount);
        map.put("listCount", postsPerPage);    
		
		List<SpBoardDto> list = dao.selectList(map);
		model.addAttribute("pg", pg);
		model.addAttribute("list", list);
	}

}                       