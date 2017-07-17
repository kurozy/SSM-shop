<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="container header">

		<%@ include file="/html/header.html" %>
		<%@ include file="menu.jsp"%>

	</div>

	<div class="container cart">

		<div class="span24">

			<div class="step step1">
				<ul>

					<li class="current"></li>
					<li>我的订单</li>
				</ul>
			</div>

			<table>
				<tbody>
					<c:forEach items="${pageBean.list }" var="order">
						<tr>
							<th colspan="5">订单编号:${order.oid} &nbsp;&nbsp;&nbsp;&nbsp;订单金额:<font
								color="red">${order.total}
							</font>
							&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">
								<c:if test="${order.state == 1 }">
									<a href="${ pageContext.request.contextPath }/order_findByOid?oid=${order.oid} />">待付款</a>
								</c:if>
								<c:if test="${order.state == 2 }">
									已付款
								</c:if>
								<c:if test="${order.state == 3 }">
									<a href="${ pageContext.request.contextPath }/order_updateState?oid=${order.oid}">确认收货</a>
								</c:if>
								<c:if test="${order.state == 4 }">
									交易成功
								</c:if>
							</font>
							</th>
						</tr>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${order.orderItems }" var="orderItem">
							<tr>
								<td width="60"><img
									src="${ pageContext.request.contextPath }/${orderItem.product.image}" />
								</td>
								<td>${orderItem.product.pname}</td>
								<td>${orderItem.product.shopPrice}</td>
								<td class="quantity" width="60">${orderItem.count}</td>
								<td width="140"><span class="subtotal">￥${orderItem.subtotal }
								</span></td>
							</tr>
						</c:forEach>
					</c:forEach>
					<tr>
						<th colspan="5">
						<div class="pagination">
							<span>第${pageBean.page }/${pageBean.totalPage}页 </span>
								<c:if test="${pageBean.page > 1 }">
									<a
										href="${ pageContext.request.contextPath }/order_findByUid?page=1"
										class="firstPage">&nbsp;</a>
									<a
										href="${ pageContext.request.contextPath }/order_findByUid?page=1"
										class="previousPage">&nbsp;</a>
								</c:if>
							<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
								<c:if test="${pageBean.page != i }">
									<a
										href="${ pageContext.request.contextPath }/order_findByUid?page=${i }">${i }
									</a>
								</c:if>
								<c:if test="${pageBean.page == i }">
									<span class="currentPage">${i }
									</span>
								</c:if>
								</c:forEach>
							<c:if test="${pageBean.page != pageBean.totalPage }">
								<a class="nextPage"
									href="${ pageContext.request.contextPath }/order_findByUid?page=${pageBean.page+1}">&nbsp;</a>
								<a class="lastPage"
									href="${ pageContext.request.contextPath }/order_findByUid?page=${pageBean.totalPage }">&nbsp;</a>
							</c:if>
							</div>
							</th>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
	
	<%@ include file="footer.jsp" %>
	
	
</body>
</html>