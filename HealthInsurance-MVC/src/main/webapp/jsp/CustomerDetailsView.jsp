<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.healthInsurance.model.Customer"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>


 <%
Customer custDetails = new Customer();
custDetails = (Customer) request.getAttribute("customerDetails");
%>
<table style="width:80%">
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


 <a href="${pageContext.request.contextPath}/jsp/Home.jsp">Home Page</a>
</body>
</html>