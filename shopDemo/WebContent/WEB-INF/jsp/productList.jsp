<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>艺美网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>
<body>
<div class="container header">
	
	<%@ include file="/html/header.html" %>
	<%@ include file="menu.jsp" %>
	
</div>	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<c:forEach items="${cList }" var="c" >
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/product_findByCid?cid=${c.cid}&page=1">${c.cname}</a>
							</dt>
								<c:forEach var="cs" items="${c.categorySeconds }">
									<dd>
										<a href="${ pageContext.request.contextPath }/product_findByCsid?csid=${cs.csid}&page=1">${cs.csname}</a>
									</dd>
								</c:forEach>	
						</dl>
				</c:forEach>		
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="#" method="get">
					
				<div id="result" class="result table clearfix">
						<ul>
							<c:forEach var="p" items="${pageBean.list }">
								<li>
										<a href="${ pageContext.request.contextPath }/product_findByPid?pid=${p.pid}">
											<img src="${pageContext.request.contextPath}/${p.image}" width="170" height="170"  style="display: inline-block;"/>
											   
											<span style='color:green'>
											 ${p.pname }
											</span>
											 
											<span class="price">
												商城价： ￥${p.shopPrice }
											</span>
											 
										</a>
								</li>
							</c:forEach>	
								
						</ul>
				</div>
	<div class="pagination">
			<input id="totalPage" value="${pageBean.totalPage}" type="hidden"/>
			<span>第 ${pageBean.page}/${pageBean.totalPage} 页</span>
		<c:if test="${cid != null }">
			<c:if test="${pageBean.page != 1 }">
				<a href="${ pageContext.request.contextPath }/product_findByCid?cid=${cid}&page=1" class="firstPage">&nbsp;</a>
				<a href="${ pageContext.request.contextPath }/product_findByCid?cid=${cid}&page=${pageBean.page-1 }" class="previousPage">&nbsp;</a>
			</c:if>
			
			<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
				<c:if test="${pageBean.page != i }">
					<a href="${ pageContext.request.contextPath }/product_findByCid?cid=${cid}&page=${i}">${i}</a>
				</c:if>
				<c:if test="${pageBean.page == i }">
					<span class="currentPage">${i}</span>
				</c:if>
			</c:forEach>
			
			<c:if test="${pageBean.page != pageBean.totalPage }">	
				<a class="nextPage" href="${ pageContext.request.contextPath }/product_findByCid?cid=${cid}&page=${pageBean.page+1 }">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/product_findByCid?cid=${cid}&page=${pageBean.totalPage}">&nbsp;</a>
			</c:if>
		</c:if>	
		<c:if test="${csid != null }">
			<c:if test="${pageBean.page != 1 }">
				<a href="${ pageContext.request.contextPath }/product_findByCsid?csid=${csid}&page=1" class="firstPage">&nbsp;</a>
				<a href="${ pageContext.request.contextPath }/product_findByCsid?csid=${csid}&page=${pageBean.page-1 }" class="previousPage">&nbsp;</a>
			</c:if>
			
			<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
				<c:if test="${pageBean.page != i }">
					<a href="${ pageContext.request.contextPath }/product_findByCsid?csid=${csid}&page=${i}">${i}</a>
				</c:if>
				<c:if test="${pageBean.page == i }">
					<span class="currentPage">${i}</span>
				</c:if>
			</c:forEach>
			
			<c:if test="pageBean.page != pageBean.totalPage">	
				<a class="nextPage" href="${ pageContext.request.contextPath }/product_findByCsid?csid=${csid}&page=${pageBean.page+1}">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/product_findByCsid?csid=${csid}&page=${pageBean.totalPage}">&nbsp;</a>
			</c:if>
		</c:if>	
		<c:if test="${pc != null }">
			
			<script>
				$(function(){
					var pageVal = $(".currentPage").text();
					alert(pageVal);
					$(".firstPage").click(function(){
						$("#page").val(1);
						$("#productCondition").submit();
						return false;
					});
					$(".previousPage").click(function(){
						var iVal = this.text;
						$("#page").val(iVal-1);
						$("#productCondition").submit();
						return false;
					});
					$(".nextPage").click(function(){
						var iVal = this.text;
						$("#page").val(iVal+1);
						$("#productCondition").submit();
						return false;
					});
					$(".lastPage").click(function(){
						var iVal = this.text;
						var lastPage = $("#totalPage").val();
						$("#page").val(lastPage);
						$("#productCondition").submit();
						return false;
					});
					
					
					$(".i_val").click(function(){
						var iVal = this.text;
						$("#page").val(iVal);
						$("#productCondition").submit();
						return false;
					});
					
					
				});
			</script>
			
			<c:if test="${pageBean.page != 1 }">
				<a href="#" class="firstPage">&nbsp;</a>
				<a  href="#" class="previousPage">&nbsp;</a>
			</c:if>
			
			<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
				<c:if test="${pageBean.page != i }">
					<a class="i_val" href="#">${i}</a>
				</c:if>
				<c:if test="${pageBean.page == i }">
					<span class="currentPage">${i}</span>
				</c:if>
			</c:forEach>
			
			<c:if test="pageBean.page != pageBean.totalPage">	
				<a class="nextPage" href="#">&nbsp;</a>
				<a class="lastPage" href="#">&nbsp;</a>
			</c:if>
		</c:if>	
	</div>
			</form>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
	

</body></html>