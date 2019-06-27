<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="assignees.ams" method="post">


		<input type="number" placeholder="Enter  pin" name="pin" required=""><br>
		<br>

		<textarea rows="5" cols="30" 
			placeholder="Enter Coma saperated email here" name="email"
			required="">
 </textarea>
		<br> <br> <input type="submit" value="Assign">

	</form>


</body>
</html>