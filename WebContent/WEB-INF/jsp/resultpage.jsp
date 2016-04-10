<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>


<body>

	<div class="row">
		<div class="col-md-12" style="text-align:center">
			<div class="text-info">	
				<h1> WHAT INTERNET KNOWS ABOUT YOU </h1>
				<h4>-${EMAIL_IN}-</h4>
			</div>
			<br><br>
		</div>
	</div>

	
	<div class="container-fluid">
	
		<!-- PHOTOS -->
		<div class="row">
			<div class="col-md-12">	
				<h2 class="text-info"> Photos</h2><br>
				<c:forEach items="${INFO_PHOTOS_ARRAY}" var="photo">
					<div style="display: block;float: left;margin-right: 5px;">
				    	<img src="${photo.url}" class="img-rounded" width="150" height="150"><br>
				     	<div style="text-align:center"><c:out value="${photo.typeName}" /></div>
			     	</div>
			 	</c:forEach>		 	
	  		</div>
		</div>
		
		<!-- CONTACT -->
		<div class="row">
			<div class="col-md-12">
				<br><br><h2 class="text-info"> Contacts</h2><br>
				<ul>
					<c:forEach items="${INFO_CONTACT_ARRAY}" var="contact">
				     	<li>	
				     		<h4><c:out value="${contact.client}" /></h4> 
				     		<c:out value="${contact.handle}" />
				     	</li><br>
				 	</c:forEach>
			 	</ul>
			 </div>
		</div>
		
		<!-- ORGANIZATION -->
		<div class="row">
			<div class="col-md-12">
				<br><br><h2 class="text-info"> Companies</h2><br>
				<ul>
					<c:forEach items="${INFO_ORGANIZATION_ARRAY}" var="organization">
				     	<li>	
				     		<h4><c:out value="${organization.name}" /><br></h4>
				     		Primary company -> 	<c:out value="${organization.isPrimary}" /><br>
				     		Start Date->		<c:out value="${organization.startDate}" /><br>
				     		Your Company Title-><c:out value="${organization.title}" /><br>
				     		Current-> 			<c:out value="${organization.current}" /><br>
				     	</li><br>
				 	</c:forEach>
			 	</ul>
			 </div>
		</div>
		
		<!-- SOCIAL -->
		<div class="row">
			<div class="col-md-12">
				<br><br><h2 class="text-info"> Social profile</h2><br>
				<ul>
					<c:forEach items="${INFO_SOCIAL_ARRAY}" var="account">
				     	<li>	
				     		<h4><c:out value="${account.typeName}" /></h4>
				     		<b>Type: </b><c:out value="${account.type}" /><br>
				     		<b>Id: </b><c:out value="${account.typeId}" /><br>
				     		<b>URL: </b><c:out value="${account.url}" /><br>
				     		<c:if test="${not empty account.username}">
				     			<b>Username: </b><c:out value="${account.username}" /><br>
				     		</c:if>
				     		<c:if test="${not empty account.bio}">
				     			<b>Bio: </b><c:out value="${account.bio}" /><br>
				     		</c:if>
				     		<c:if test="${not empty account.id}">
				     			<b>Account id:</b><c:out value="${account.id}" /><br>
				     		</c:if>
				     		<c:if test="${not empty account.followers}">
							    <b>Followers: </b><c:out value="${account.followers}" /><br>
							</c:if>
							<c:if test="${not empty account.following}">
				     			<b>Following: </b><c:out value="${account.following}" /><br>
				     		</c:if>
				     	</li><br>
				 	</c:forEach>
			 	</ul>
			 </div>
		</div>

	</div>
</body>
	
	
	<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

</html>