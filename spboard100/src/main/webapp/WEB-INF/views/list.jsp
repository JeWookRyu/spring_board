<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <div class="listbox">
                <h1 class="text-center mb-5">게시판</h1>
                <div class="d-flex justify-content-between py-4">
                    <div>
                        <fmt:formatNumber value="${pg.totalPosts }" groupingUsed="true"/>posts /
                        <fmt:formatNumber value="${pg.totalPages }" groupingUsed="true" />pages
                    </div>
                    <div>
                        <a href="#" class="btn btn-primary">목록</a>
                        <a href="write" class="btn btn-primary">글쓰기</a>                      
                    </div>
                </div>
                <table class="table table-hover">
                    <colgroup>
                       <col width="8%">
                       <col>
                       <col width="15%">
                       <col width="10%">
                       <col width="15%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>글쓴이</th>
                            <th>조회수</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach var="list" items="${list }">
                       <c:set var="styleDepth" value="" />
                       <c:set var="commentHit" value="" />
                       <c:set var="reicon" value="" />
                       <c:if test="${list.depth > 0 }">
                          <c:set var="padding" value="${list.depth * 20 }px" />
                          <c:set var="reicon" value="<i class='ri-corner-down-right-line'></i>" />
                          <c:set var="styleDepth" 
                                  value="<span style='display:inline-block;height:1px;width:${padding };'></span>${reicon }"/>
                       </c:if>
                       <c:if test="${list.chit > 0 }">
                          <c:set var="commentHit" value="(${list.chit })" />
                       </c:if>
                       
                       <tr>
                           <td class="text-center">${list.id }</td>
                           <td>${styleDepth} <a href="contents?id=${list.id }&cpg=${cpg}">${list.title }</a>
                            <span>${commentHit }</span>
                           </td>
                            
                           <td class="text-center">${list.writer }</td>
                           <td class="text-center">${list.hit }</td>
                           <td class="text-center"><fmt:formatDate value="${list.wdate }" pattern="yyyy.MM.dd" /></td>
                       </tr>
                       </c:forEach> 
                       <!-- /loop -->
                    </tbody>
                </table>
                <div class="d-flex justify-content-between py-4">
                    <div>
                    </div>
                    
                    <ul class="paging">
                        <li>
                            <a href="?cpg=1"><i class="ri-arrow-left-double-line"></i></a>
                        </li>
                        <li>
                            <a href="?cpg=${pg.startPage-1 > 0? pg.startPage-1:pg.startPage }"><i class="ri-arrow-left-s-line"></i></a>
                        </li>
                        <c:forEach begin="${pg.startPage }" end="${pg.endPage }" var="i">
                        <li>                       
                           <a href="?cpg=${i }" class="${cpg==i?'active':'' }">${i}</a>
                        </li>
                        </c:forEach>
                        
                        <li>
                            <a href="?cpg=${pg.endPage + 1 > pg.totalPages? pg.totalPages : pg.endPage + 1 }"><i class="ri-arrow-right-s-line"></i></a>
                        </li>
                        
                        <li>
                            <a href="?cpg=${pg.totalPages }"><i class="ri-arrow-right-double-line"></i></a>
                        </li>
                    </ul>
                    
                    <div>
                        <a href="#" class="btn btn-primary">목록</a>
                        <a href="write" class="btn btn-primary">글쓰기</a>                      
                    </div>
               </div>
               <form name="searchform" id="searchform" class="searchform" method="get">
                   <div class="input-group my-3">
                        <div class="input-group-prepend">
                            <button type="button" 
                                    class="btn btn-outline-secondary dropdown-toggle" 
                                    data-toggle="dropdown"
                                    value="title">
                                제목검색
                              </button>
                              <div class="dropdown-menu">
                                <a class="dropdown-item" href="writer">이름검색</a>
                                <a class="dropdown-item" href="title">제목검색</a>
                                <a class="dropdown-item" href="content">내용검색</a>
                            </div>
                        </div>
                       <input type="hidden" name="searchname" id="searchname" value="title" />
                       <input type="search" name="searchvalue" class="form-control" placeholder="검색">
                       <div class="input-group-append">
                          <button class="btn btn-primary"><i class="ri-search-line"></i></button>
                       </div>
                   </div>
               </form>
            </div>
            <!-- /listbox-->
