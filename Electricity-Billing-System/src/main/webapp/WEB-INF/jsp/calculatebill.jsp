<title>Bill Calculated</title>

<form action="calbill">

<!-- <br>Meter No <input type="text" name="meterNo"></br>
 --><br> Name <input type="text" name="name"></br>
<br> Unit <input type="text" name="units" id="unit"></br>

<br><input type="submit" value="calculate"></br>
<h3>Final Bill = <%if(request.getAttribute("fbill")!=null) out.print(request.getAttribute("fbill")); %></h3>
</form>