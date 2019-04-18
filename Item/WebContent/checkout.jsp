<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Checkout</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
</head>
<body>
	<!--header-->
	<%@include file="header.jsp"%>
	<!--//header-->
	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
			<h2>My Shopping Cart(3)</h2>
			<c:forEach items="${mcart}" var="mc">
			<div class="cart-header">
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="${mc.bigpic}" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="single?scnum=${mc.cnum}">${mc.name}</a><span>Pickup time:${mc.time}</span></h3>
						<ul class="qty">
							<li><p>Min. order value:$${mc.rprice*mc.discount/10}</p></li>
							<li><p>FREE delivery</p></li>
						</ul>
						<div class="delivery">
							<p>Service Charges : $10.00</p>
							<div class="clearfix"></div>
						</div>	
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
	<!--//checkout-->	
	<!--footer-->
	<%@include file="foot.jsp"%>
	<!--footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.17sucai.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		</div>
	</div>
</body>
</html>