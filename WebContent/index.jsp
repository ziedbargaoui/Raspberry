<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Raspberry Pi</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>

<script src="js/app-ajax.js" type="text/javascript"></script>

</head>
<body>
<% 
	String heatDegree =  request.getParameter("heatDegree");
 %>
	<div class="jumbotron text-center">
		<h1>Raspberry Pi</h1>
		<p>Enter the wanted temperature, or get the current one</p>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-md-4 col-lg-4">
     			<!--  -->
				<form action="Heat" method="post">
  					<div class="form-group">
    					<label for="heat_degree">Heat Degree:</label>
						<input type="text" name="heatDegree" class="form-control" id="heatDegree" /> 
  					</div>
					<button type="submit" class="btn btn-default">Submit</button>

				</form>
				
				
				<h3>You set the temperature to <%= heatDegree %></h3>
			</div>
			<div class="col-sm-6 col-md-6 col-lg-6">
				
				<label>To get the current temperature</label>
				<br>
				<button id="getTemperature" type="submit" class="btn btn-default">Click Here</button>
				
				<div id="ajaxHeatResponse"></div>
			</div>
		</div>
	</div>

</body>
</html>