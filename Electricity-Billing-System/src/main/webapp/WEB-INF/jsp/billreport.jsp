<%@page import="com.Electricity.Billing.System.model.CalculateBill"%>
<%@page import="java.util.List"%>
<html>
<head>
</head>
<body>

	<h1 align="center">Bill Report</h1>
	<table border="1px">

		<tr>
			<th>Name</th>
			<th>Unit</th>
			<th>Bill Amount</th>
		
		</tr>
		<%
		if (request.getAttribute("Bill Report") != null) {
		%>
		<%
		List<CalculateBill> list = (List<CalculateBill>) request.getAttribute("Bill Report");
		for (CalculateBill cal : list) {
		%>
		<tr>
			<td>
				<%
				out.print(cal.getName());
				%>
			</td>
			<td>
				<%
				out.print(cal.getUnits());
				%>
			</td>
			<td>
				<%
				out.print(cal.getBill());
				%>
			</td>
		</tr>
		<%
		}
		%>
		<%
		}
		%>
	</table>
</body>
</html>
