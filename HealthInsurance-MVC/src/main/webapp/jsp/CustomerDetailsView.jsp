<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.healthInsurance.model.Customer"  %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

a:link {
  text-decoration: none;
  color: blue;
}

</style>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>


 <%
Customer custDetails = new Customer();
custDetails = (Customer) request.getAttribute("customerDetails");
session.setAttribute("customerDetails", custDetails);

%>
<table style="width:100%" id="customers">
  <tr>
  <th>Customer Id</th>
    <th>Email</th>
    <th>Name</th>
    <th>Address</th>
     <th>City</th>
    <th>Phone Number</th>
  </tr>
    <tr >
    <td><%=custDetails.getCusId() %></td>	
     <td><%=custDetails.getEmail() %></td>
  	 <td><%=custDetails.getName() %></td>	
   	 <td><%=custDetails.getAddress() %></td>
  	 <td><%=custDetails.getCity() %></td>	
  	 <td><%=custDetails.getPhoneNumber() %></td>
  	</tr>
</table>
<br>

 <a href="http://localhost:8090/HealthInsurance-MVC/jsp/UpdateProfile.jsp">update profile</a>
<br>
 <a href="http://localhost:8090/HealthInsurance-MVC/jsp/Home.jsp">Home Page</a>
</body>
</html>