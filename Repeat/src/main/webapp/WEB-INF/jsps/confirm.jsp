<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Flight Details</h1>
<br/>
Operating Airlines:${flight.operatingAirlines }
<br/>
Departure City:${flight.departureCity }
<br/>
Arrival City:${flight.arrivalCity }
<br/>
Departure Date & Time:${flight.estimatedDepartureTime }


<h2>Enter The Passenger Details</h2>
<form action="findit" method="post">
<pre>
FirstName:<input type="text" name="firstName"/>
LastName:<input type="text" name="lastName"/>
MiddleName:<input type="text" name="middleName"/>
Email:<input type="text" name="email"/>
Phone:<input type="text" name="phone"/>
<input type="hidden" name="flightId" value="${flight.id}"/>
<h3>Enter the Payment Details</h3>
Name:<input type="text" name="name"/>
Card Number:<input type="text" name="cardNumber"/>
CVV Code:<input type="text" name="cvvCode"/>
Amount:<input type="text" name="amount"/>
<input type="submit" value="save"/>
</pre>
</form>
</body>
</html>