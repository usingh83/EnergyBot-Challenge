<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>WetherApi | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">weather By Station id</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				</ul>
			</div>
		</div>
	</div>
	<div class="container text-center">
				<h3>Enter Stationid</h3>
				<hr>
				<form class="form-horizontal" method="GET" action="/home${weather.stationid}">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Stationid</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="Stationid"
								value="${weather.stationid }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Stationid" />
					</div>
					</form>
					</div>
	<c:choose>
		<c:when test="${mode=='ALL_USERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Weather By Station</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>StationId</th>
								<th>Year-Month</th>
								<th>element</th>
								<th>Value1</th>
								<th>Mflag1</th>
								<th>Qflag1</th>
								<th>Sflag1</th>
								<th>Value2</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="weather" items="${weathers}">
								<tr>
									<td>${weather.id}</td>
									<td>${weather.stationid}</td>
									<td>${weather.yearmonth}</td>
									<td>${weather.element}</td>
									<td>${weather.value1}</td>
									<td>${weather.mflag1}</td>
									<td>${weather.qflag1}</td>
									<td>${weather.sflag1}</td>
									<td>${weather.value2}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
	</c:choose>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>