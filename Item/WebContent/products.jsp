<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Products</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->	
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- the jScrollPane script -->
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- //the jScrollPane script -->
<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
<!-- the mousewheel plugin -->		
</head>
<body>
	<!--header-->
	<%@include file="header.jsp"%>
	<!--//header-->
	<!--products-->
	<div class="products">	 
		<div class="container">
			<h2>Our Products</h2>			
			<div class="col-md-9 product-model-sec">
			<c:forEach items="${cakeshow}" var="cs">
				<div class="product-grid">
					<a href="single?scnum=${cs.cnum}">				
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="${cs.bigpic}" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">							
									<button>View</button>
								</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${cs.name}</h4>								
							<span class="item_price">$${cs.price*cs.discount/10}</span>
							<div class="ofr">
								<p class="pric1"><del>$${cs.price}.0</del></p>
								<p class="disc">[${cs.discount}0%Off]</p>
							</div>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
			</c:forEach>
		  	<c:if test="${mcount<=9&&mcount>=0}">
          		<div style="text-align:center;float:left;clear:left">
					There are ${mcount} pieces of date.
				</div>
		  	</c:if>
          	<c:if test="${mcount>9&&mstyle=='type'}">
          		<div style="text-align:center;float:left;clear:left">
					There are ${mcount} pieces of date，A total of ${mtotal} pages:
					<c:forEach var="i" begin="1" end="${mtotal}">
					<a href="products?ctnum=${cakeshow[0].type}&pageNum=${i}">${i}</a>
					</c:forEach>
				</div>
		  	</c:if>
          	<c:if test="${mcount>9&&mstyle=='size'}">
          		<div style="text-align:center;float:left;clear:left">
					There are ${mcount} pieces of date，A total of ${mtotal} pages:
					<c:forEach var="i" begin="1" end="${mtotal}">
					<a href="pro?pageNum=${i}&minsize=${myminsize}&maxsize=${mymaxsize}">${i}</a>
					</c:forEach>
				</div>
		  	</c:if>
          	<c:if test="${mcount>9&&mstyle=='all'}">
          		<div style="text-align:center;float:left;clear:left">
					There are ${mcount} pieces of date，A total of ${mtotal} pages:
					<c:forEach var="i" begin="1" end="${mtotal}">
					<a href="produ?pageNum=${i}">${i}</a>
					</c:forEach>
				</div>
		  	</c:if>		  
			</div>	
			<div class="col-md-3 rsidebar span_1_of_left">			 
				<form action="pro?pageNum=1" method="post">
					MIX SIZE:<input type="text" name="minsize"/>
					MAX SIZE:<input type="text" name="maxsize"/>
					<input type="submit" value="Check">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//products-->
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