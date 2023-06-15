<!DOCTYPE html>
<html>
<head>
<title>Electricity Billing System</title>
<script>
	function isAdmin() {
<%if (request.getAttribute("isadmin") != null) {%>
	
<%boolean check = (boolean) request.getAttribute("isadmin");%>
	
<%if (check) {%>
	document.getElementById('vu').style.display = 'block'

		document.getElementById('uc').style.display = 'block'
<%}
}%>
	}
</script>
</head>
<body onload="isAdmin()">
	<h1>Welcome to the Electricity Billing System</h1>
	<p>Here, you can manage your electricity billing information.</p>

	<form id="vu" action="viewUser" style="display: none">
		<br> <input type="submit" value="View Users"></br>
	</form>

	<form action="calbill">
		<br> <input type="submit" value="Calculate Bill"></br>
	</form>

	<form action="billreport">
		<br> <input type="submit" value="Bill Report"></br>
	</form>

	<form action="payment">
		<br> <input type="submit" value="Payment History"></br>
	</form>

	<form id="uc" action="updatecost" style="display: none">
		<br> <input type="submit" value="Update Cost"></br>
	</form>

	<form action="payment">
		<br> <input type="submit" value="Logout"></br>
	</form>

</body>
</html>
