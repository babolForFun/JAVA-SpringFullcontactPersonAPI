<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>	

	<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<body>
		<div class="col-md-12" style="text-align:center">
			<div class="text-info">	
				<h1> WHAT INTERNET KNOWS ABOUT YOU </h1>
			</div>
			<br><br>
		</div>
		<div class="container">
			<div class="row">
			    <div class="col-md-4"> </div>
				<div class="col-md-4" style="margin:5%">
					<form role="form" action="web/getfullcontact/by_email" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">
								EMAIL
							</label>
							<input type="text" class="form-control" id="email" name="email" value="bart@fullcontact.com"/>
						</div>
						<button type="submit" class="btn btn-primary" value="Send Request">
							Click here
						</button>
					</form>
				</div>
				<div class="col-md-4"> </div>
			</div>
		</div>
	</body>
	
    <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
		
</html>