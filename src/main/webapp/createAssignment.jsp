<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="createAssignment.ams" method="post">

		<select name="course">
			<option>-----select-----</option>
			<option>Core Java</option>
			<option>Hibernate</option>
			<option>Spring</option>
			<option>JEE</option>
			<option>SQL</option>
			<option>Web technology</option>
		</select><br>
		<br> <select name="topic">
			<option>-----select-----</option>

			<optgroup label="Core Java">

				<option value="oops">OOPS</option>
				<option value="threads">Thread</option>
				<option value="strings">Strings</option>
				<option value="collection">Collection</option>
				<option value="fileHandling">FileHandling</option>

			</optgroup>

			<optgroup label="Hibernate">

				<option value="components">Components</option>
				<option value="ORM">ORM</option>
				<option value="JPA">JPA</option>
				<option value="cache">Cache</option>

			</optgroup>

			<optgroup label="spring">

				<option value="spring containers">spring containers</option>
				<option value="scope of spring bean">scopes of spring bean</option>
				<option value="dependency injection">dependency injection</option>
				<option value="mvc architecture">mvc architecture</option>

			</optgroup>

			<optgroup label="jee">

				<option value="servlet life cycle">servlet life cycle</option>
				<option value="session">session</option>
				<option value="jdbc connection">jdbc connection</option>
				<option value="cache">Crud operation</option>

			</optgroup>

			<optgroup label="sql">

				<option value="commands">Commands</option>
				<option value="operators">Operators</option>
				<option value="Joins">Joins</option>
				<option value="normalization">normalization</option>

			</optgroup>


			<optgroup label="web technologies">

				<option value="html tags">html tags</option>
				<option value="forms">forms</option>
				<option value="css">css</option>

			</optgroup>
		</select><br>
		<br>

		<textarea rows="4" cols="50" name="description"
			placeholder="description">
</textarea>
		<br>
		<br> <input type="date" name="deadLine" placeholder="deadLine"><br>
		<br> <select name="uploadType">
			<option>GIT</option>
			<option>ZIP</option>
			<option>File</option>
		</select><br>
		<br> <input type="submit" value="submit">

	</form>

</body>
</html>