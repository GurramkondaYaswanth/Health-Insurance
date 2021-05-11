<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.healthInsurance.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Customer customer =  (Customer) session.getAttribute("customerDetails");
 String emailDB = customer.getEmail();
 String nameDB = customer.getName();
 String phonenumberDB = customer.getPhoneNumber();
 String addressDB = customer.getAddress();
 String cityDB = customer.getCity();
%>
<!--  <tr><td> email</td>
  <td><input type="text" name="email"  value ="${emailDB}"/></td>
  </tr> -->
<form name="customerUpdate" method="post" action="../ProfileUpdate">
<table>

	 <tr><td> name</td>
  <td><input type="text" name="name"  value =<%=nameDB %> ></td>
  </tr>

	<tr><td>Password<td>
	<td><input type="password" name="password"></td>
	</tr>

   <tr><td> phoneNumber</td>
  <td><input type="text" name="phoneNumber"  value = <%=phonenumberDB %> /></td>
  </tr>
   
   <tr><td> address</td>
  <td><input type="text" name="address"  value = <%=addressDB %> /></td>
  </tr>
 
   <tr><td> customer_city</td>
  <td><input type="text" name="city"  value = <%=cityDB %> /></td>
  </tr>
	
  <tr><td><input type="submit" value="Submit"/></td>
  </tr>
  

</table>
</form>
<br>
 <a href="http://localhost:8090/HealthInsurance-MVC/jsp/Home.jsp">Home Page</a>
</body>
</html>