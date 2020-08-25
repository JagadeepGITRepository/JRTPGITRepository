<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
	
</script>

<title>Plan Registration</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script>
  $( function() {
    $( "#datepicker1" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );

  $( function() {
	    $( "#datepicker2" ).datepicker({
	      changeMonth: true,
	      changeYear: true
	    });
	  } );
  </script>


</head>
<c:if test="${!empty msg}">
				<div class="card-footer bg-info text-white text-center p-1">
					<h3 style="color:green">${msg}</h3>
				</div>
			</c:if>

<body>

	<form:form action="registerPlan" method="POST"
		modelAttribute="planDtls">

		<div class="container p-3 mb-2 bg-light text-dark "
			style="background-image: url('../images/');">


			<div class="card">
				<div
					class="card-header bg-primary text-white text-uppercase text-center">
					<h2  style="color:red">Register Plan</h2>
				</div>
			</div>


			<div class="row">
				<div class="col-4 ">
					<label for="pname"><b style="color: blue;">Plan Name</b></label>
				</div>
				<div class="col-4 p-1">
					 <form:hidden path="planId" /> 
					<form:input type="text" class="form-control" placeholder="Plan Name"
						path="planName" id="pname"/>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="pdesc"><b style="color: blue;">Plan Description</b></label>
				</div>

				<div class="col-4 p-1">
					<form:input type="text" class="form-control" placeholder="Write Some Description Here"
						path="planDesc" id="pdesc"></form:input>
				</div>

			</div>

			<div class=" row">
				<div class="col-4">
					<label for="planStartDate"><b style="color: blue;">Plan StartDate </b></label>
				</div>
				<div class="col-4 p-1">
					<form:input type="text" class="form-control" id="datepicker1"
						placeholder="Start Date" path="startDate"></form:input>
				</div>

			</div>
			
			
				<div class=" row">
				<div class="col-4">
					<label for="planEndDate"><b style="color: blue;">Plan EndDate </b></label>
				</div>
				<div class="col-4 p-1">
					<form:input type="text" class="form-control" id="datepicker2"
						placeholder="End Date" path="endDate"></form:input>
				</div>

			</div>
		

				<div class="col-4 ">
					<input type="submit" value="REGISTER" class="btn btn-primary"
						id="register">
				</div>

			</div>

	</form:form>
</body>
</html>
