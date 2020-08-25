<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PlanInfo</title>
<style type="text/css">
thead {
	background: black;
}
td {
	background: cyan;
}
</style>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#plan').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	function confirmDelete() {
		return confirm("Are you sure ..You want to delete");
	}
	function confirmActive() {
		return confirm("Are you sure ..You want to Active");
	}
</script>
</head>
<h1  style="color:green">${msg}</h1>
<body>
	<table border="1" id="plan">
		<thead style="color: red;">
			<tr>
				<th>S.NO</th>
				<th>PLAN_NAME</th>
				<th>DESCRIPTION</th>
				<th>START_DATE</th>
				<th>END_DATE</th>
				<th>ACTIONS</th>
			</tr>
		</thead>
		<c:forEach items="${planList}" var="plan" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${plan.planName}</td>
				<td>${plan.planDesc}</td>
				<td>${plan.startDate}</td>
				<td>${plan.endDate}</td>

				<td><a href="editplan?pIanId=${plan.planId}">EDIT</a>
				 <c:choose>
						<c:when test="${plan.activeStatus eq 'Y'}">

							<a href="deleteplan?pIanId=${plan.planId}"
								onClick="return confirmDelete()">DELETE</a>
						</c:when>
						<c:otherwise>
							<a href="activeplan?pIanId=${plan.planId}" onClick="return confirmActive()">ACTIVATE</a>
							  
						</c:otherwise>
					</c:choose>
				       </td>
			</tr>

		</c:forEach>
		<tbody>
		</tbody>
	</table>
</body>
</html>