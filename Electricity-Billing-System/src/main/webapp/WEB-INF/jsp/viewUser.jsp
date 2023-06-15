<%@page import="com.Electricity.Billing.System.model.User"%>
<%@page import="java.util.List"%>

<%
out.print("User List");
%>
<table>

	<tr>
		<th>id</th>
		<th>username</th>
		<th>email_id</th>
		<th>mobile_no</th>
		<th>address</th>
		<th>password</th>
	</tr>
	<%
	List<User> list = (List<User>) request.getAttribute("Userlist");

	for (User us : list) {
	%>
	<tr>
		<td>
			<%
			out.print(us.getMeterNo());
			%>
		</td>
		<td>
			<%
			out.print(us.getUsername());
			%>
		</td>
		<td>
			<%
			out.print(us.getEmail_id());
			%>
		</td>
		<td>
			<%
			out.print(us.getPhoneNo());
			%>
		</td>
		<td>
			<%
			out.print(us.getAddress());
			%>
		</td>
		<td>
			<%
			out.print(us.getPassword());
			%>
		</td>
	</tr>

	<%
	}
	%>
</table>