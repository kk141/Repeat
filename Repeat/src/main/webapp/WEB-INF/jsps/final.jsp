<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Your Ticket Is Confirmed</h2>
<table>
<tr>
<td>Passenger FirstName</td>
<td>${firstName }</td>
</tr>
<tr>
<td>Passenger LastName</td>
<td>${lastName }</td>
</tr>
<tr>
<td>Passenger MiddleName</td>
<td>${middleName }</td>
</tr>
<tr>
<td>Passenger Email</td>
<td>${email }</td>
</tr>
<tr>
<td>Passenger Phone</td>
<td>${phone }</td>
</tr>
<tr>
<td>Operating Airlines</td>
<td>${operatingAirlines }</td>
</tr>
<tr>
<td> Departure City</td>
<td>${departureCity }</td>
</tr>
<tr>
<td>ArrivalCity</td>
<td>${arrivalCity }</td>
</tr>
<tr>
<td>Estimated Departure Time</td>
<td>${estimatedDepartureTime }</td>
</tr>
</table>

</body>
</html>