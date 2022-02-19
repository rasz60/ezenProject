<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/products.css" type="text/css">
    <title>EDT_SHOP</title>
    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
    <script type="text/javascript" src="resources/js/fetch/fetch.js"></script>
</head>

<body>
    <%@include file="header.jsp"%>
    
    <nav id="gender_menu">
		<ul>
			<li class="chck_gender" data-value="'M'">MAN</li>
			<li class="chck_gender" data-value="'W'">WOMAN</li>
			<li class="chck_gender" data-value="'KIDS'">KIDS</li>
		</ul>
    </nav>    
    <section id="products">
        <div class="kind_menu">
            <h1>BRAND</h1>
            <ul>
           		<li class="brand_menu"><a href="products">ALL BRAND</a></li>
                <li class="brand_menu"><a href="?brand='JORDAN'">JORDAN</a></li>
                <li class="brand_menu"><a href="?brand='NIKE'">NIKE</a></li>
                <li class="brand_menu"><a href="?brand='ADIDAS'">ADIDAS</a></li>
                <li class="brand_menu"><a href="?brand='NEW BALANCE'">NEW BALANCE</a></li>
            </ul>
        </div>
        <%@include file="dbconn.jsp" %>
        <div id="prod">
	        <div id="filter_box">
				<span class="filter" data-value="p_date" >최신순</span>
				<span class="filter" data-value="p_hit DESC" >인기순</span>
				<span class="filter" data-value="p_price" >낮은 가격순</span>
				<span class="filter" data-value="p_price DESC" >높은 가격순</span>
	        </div>
			<c:forEach var="product" items="${pVos} }">
			<div class="product">	        
			    <div class="wrap">      
			        <a href="product.jsp?p_id=${product.pId} }"><img src="resources/img/p_img/${product.pImage}" alt="no"></a>
		   		</div>
		   	</div>
		   	
		    <div class="product_info">
		      	<p class="brand"><a href="products.jsp?brand='${product.pBrand}'">${product.pBrand}</a></p>
		        <p class="ename"><a href="#">${product.pEname}</a></p>
		        <p class="kname">${product.pKname}</p>
		        <h3><a href="#"><fmt:formatNumber value="${product.pPrice}" pattern="#,###"/>원</a></h3>
		    </div>
		    </c:forEach>
		</div>
    </section>
    
	<%@include file="footer.jsp"%>
</body>
</html>