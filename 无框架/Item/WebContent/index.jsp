<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
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
	<!--banner-->
	<div class="banner">
		<div class="container">
			<h2 class="hdng">Yummy <span>Cakes</span> for u</h2>
			<p>Our best cakes make your day special</p>
			<a href="products">SHOP NOW</a>
			<div class="banner-text">			
				<img src="${mymaxpic}" alt=""/>	
			</div>
		</div>
	</div>			
	<!--//banner-->
	<!--gallery-->
	<div class="gallery">
		<div class="container">
			<div class="gallery-grids">
				<div class="col-md-8 gallery-grid glry-one">
					<a href="produ?pageNum=1"><img src="${mycake[0].bigpic}" class="img-responsive" alt="" />
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
							<a class="shop" href="single">SHOP NOW</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>${mycake[0].name}</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">$${mycake[0].price}.0</h5>
							</div>
							<div class="rating">
								<c:forEach var="i" begin="1" end="${mycake[0].star}">
								<span>☆</span>
								</c:forEach>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4 gallery-grid glry-two">
					<a href="produ?pageNum=1"><img src="${mycake[1].bigpic}" class="img-responsive" alt="" width="379.99px" height="489.25px"/>
						<div class="gallery-info galrr-info-two">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
							<a class="shop" href="single">SHOP NOW</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>${mycake[1].name}</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">$${mycake[1].price}.0</h5>
							</div>
							<div class="rating">
								<c:forEach var="i" begin="1" end="${mycake[1].star}">
								<span>☆</span>
								</c:forEach>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<c:forEach items="${indexcake}" var="ca">
				<div class="col-md-3 gallery-grid ">
					<a href="produ?pageNum=1"><img src="${ca.bigpic}" class="img-responsive" alt="" width="203px" height="213px"/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
							<a class="shop" href="single">SHOP NOW</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>${ca.name}</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">$${ca.price}.0</h5>
							</div>
							<div class="rating">
								<c:forEach var="i" begin="1" end="${ca.star}">
								<span>☆</span>
								</c:forEach>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>	
		</div>
	</div>
	<!--//gallery-->
	<!--subscribe-->
	<div class="subscribe">
		 <div class="container">
			 <h3>Newsletter</h3>
			 <form>
				 <input type="text" class="text" value="Email" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}">
				 <input type="submit" value="Subscribe">
			 </form>
		 </div>
	</div>
	<!--//subscribe-->
	<!--footer-->
	<%@include file="foot.jsp"%>
	<!--//footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.17sucai.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		</div>
	</div>
</body>
</html>