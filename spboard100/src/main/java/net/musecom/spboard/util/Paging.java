package net.musecom.spboard.util;

import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
@Setter
public class Paging {

	/* 가져올 변수 들 */
	private int currentPage; //받아올 현재 페이지 번호
	private int totalPosts; //전체 글 수
	private int postsPerPage; //한 화면에 보여줄 블럭 수
	private int pagesPerBlock; //한 화면에 보여줄 페이지 수
	
	//전체 글 수
	public int getTotalPosts() {
		return this.totalPosts;
	}
	
	//전체 페이지 수
	public int getTotalPages() {
		return (int) Math.ceil((double) totalPosts / postsPerPage);
	}
	
	//시작페이지
	public int getStartPage() {
		return ((currentPage - 1) / pagesPerBlock) * pagesPerBlock + 1;
	}
	
	//끝 페이지
	public int getEndPage() {
		int endPage = getStartPage() + pagesPerBlock - 1;
		int totalPages = getTotalPages();
		return (endPage > totalPages)? totalPages : endPage;
	}

	@Override
	public String toString() {
		return "Paging [currentPage=" + currentPage + ", totalPosts=" + totalPosts + ", postsPerPage=" + postsPerPage
				+ ", pagesPerBlock=" + pagesPerBlock + ", getTotalPosts()=" + getTotalPosts() + ", getTotalPages()="
				+ getTotalPages() + ", getStartPage()=" + getStartPage() + ", getEndPage()=" + getEndPage() + "]";
	}
	
	
}
