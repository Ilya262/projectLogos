<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>
    
    <style type="text/css">
 		.price { text-align: right; color = lightgrey; background-color: white; }
 		.flex-container { 
 			display: flex; 
 			flex-wrap: wrap;
 			flex-direction: row;
 			justify-content: flex-start;
 		}
 	</style>

    <%-- <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"> --%>
   <!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 15%">
		  <div style="user-select: none; border-bottom: 2px solid gray;"><h4 class="w3-bar-item">Menu</h4></div>
		  <a href="/home" class="w3-bar-item w3-button"><i class="fa fa-home w3-large"></i> Home</a>
		  <a href="create-periodical" class="w3-bar-item w3-button"><i class="fa fa-book w3-large"></i> Create periodical</a>
		  <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cart-arrow-down w3-large"></i> Bucket</a>
		</div>

		<%-- <c:choose>
			<c:when test="${pageContext.request.userPrincipal.authenticated}">Show something</c:when>
			<c:otherwise>Show something else</c:otherwise>
		</c:choose> --%>

		<!-- Page Content -->
		<div style="margin-left: 15%">
			<div class="w3-container w3-blue-grey">
				<h3>Periodicals</h3>
			</div>

			<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>

					<h4>
						Welcome ${pageContext.request.userPrincipal.name} | 
						<a href="#"	onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h4>
				</c:if>

				<div class="flex-container">
					<c:if test="${not empty periodicals}">
						<c:forEach items="${periodicals}" var="currentPeriodical">
							
	
								<div class="w3-card-4" style="margin: 15px;	width: 20%; min-width: 150px; border-radius: 7px;">
									<header class="w3-container w3-light-grey">
										<%-- <h4 style="white-space: nowrap;">${currentPeriodical.name}</h4> --%>
										<h4 style="white-space: nowrap; overflow: hidden;">${currentPeriodical.name}</h4>
									</header>
									<img src="https://findicons.com/files/icons/366/icomic/128/images.png" alt="image" style="width: 80%; margin: 0 10%;">
									<!-- <img src="/images/default.png" alt="image" style="width: 80%; margin: 0 10%;">  --> 
									<div class="w3-container w3-center" style="align: bottom;">
										<p>${currentPeriodical.description}</p>
										<hr>
										<p class="price w3-text-dark-grey"><b>Price:</b> ${currentPeriodical.price}</p>
									</div>
									<button class="w3-button w3-block w3-dark-grey" style="border-radius: 0 0 7px 7px; align: bottom;">+ Add to Bucket</button>
								</div>
		
								<%-- <div class="w3-card-4" style="width: 70%">
									<header class="w3-container w3-light-grey">
										<h3>${currentPeriodical.name}</h3>
									</header>
									
									<div class="w3-container">
										<p>Some text</p>
										<hr>
										<img src="https://findicons.com/files/icons/366/icomic/128/images.png"
											alt="photo" class="w3-left w3-circle w3-margin-right"
											style="width: 60px">
										<p>${currentPeriodical.description}</p>
										<br>
										<hr>
										<p class="price"><b>Price:</b> ${currentPeriodical.price}</p>
									</div>
									<button class="w3-button w3-block w3-dark-grey">+
										Add to Bucket</button>
								</div> --%>
							
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>

	</div>
<!-- /container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<%-- <script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>

</body>
</html>