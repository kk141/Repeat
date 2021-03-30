<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Booking</title>
</head>
<body>
<form action="ucanbook" method="post">
From:<input type="text" name="from"/>
To:<input type="text" name="to"/>
Departure Date:<input type="text" name="departureDate" placeholder="MM-DD-YYYY"/>
<input type="submit" value="Search">
</form>

</body>
</html>