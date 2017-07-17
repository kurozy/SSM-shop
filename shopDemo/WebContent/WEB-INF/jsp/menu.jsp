<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<c:if test="${sessionScope.existUser == null}">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/user_loginPage">登录</a>|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_registPage">注册</a>|
			</li>
			</c:if>
			<c:if test="${sessionScope.existUser != null}">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				${sessionScope.existUser.name }
				|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/order_findByUid">我的订单</a>
			|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_exit">退出</a>|
			</li>
			</c:if>
		
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${ pageContext.request.contextPath }/cart_myCart">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index">首页</a> |</li>
		<c:forEach var="cl" items="${sessionScope.cList}">
			<li><a href="${pageContext.request.contextPath}/product_findByCid?cid=${cl.cid }">${cl.cname }</a> |</li>
		</c:forEach>
	</ul>
	<br>
	<form id="productCondition" action="product_findByCondition" method="post">
		<input id="page" type="hidden" name="page" value="1"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		商品类别:<input type="text" name="type" size="10" value="${pc.type }"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		商品价格:<input type="text" name="minPrice" size="10"  value="${pc.minPrice }"/>&nbsp; - &nbsp;
			<input type="text" name="maxPrice" size="10"  value="${pc.maxPrice }"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		商品名称:<input type="text" name="pname" size="10"  value="${pc.pname }"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="搜索"/>
	</form>
	<br>
</div>