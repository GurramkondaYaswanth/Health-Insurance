<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.healthInsurance.model.InsurancePolicy" import=" java.util.List" import=" java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insurance policy</title>
</head>
<body>

<p>Insurance Policies</p>
 <%
 List<InsurancePolicy> insurancePolicylist = new ArrayList<InsurancePolicy>();
 insurancePolicylist = (List<InsurancePolicy>)  request.getAttribute("InsurancePolicylist");
%>

	<table style="width:100%">
  <tr>
  <th>Customer Id</th>
    <th>Policy Id</th>
    <th>Insurance Amount</th>
    <th>Monthly Premium</th>
     <th>Total Months to pay</th>
    <th>Months Paid </th>
    <th>Family Members Included</th>
    <th>Policy Active</th>
  </tr>
  <%
   for(InsurancePolicy ip :insurancePolicylist){
    %>
    <tr >
    <td><%= ip.getInsurancePolicyId().getCustId() %></td>	
     <td><%=ip.getInsurancePolicyId().getPolicyId() %></td>
  	 <td><%=ip.getInsuranceAmount() %></td>	
   	 <td><%=ip.getMonthlyPremium() %></td>
  	 <td><%=ip.getNoOfMonths() %></td>	
  	 <td><%=ip.getNoOfMonthsPaid() %></td>
  	 <td><%=ip.getFamilyMembers() %></td>	
  	 <td><%=ip.isPolicyActive() %></td>
  	</tr>
  	
  <%	}%>
</table>


 <a href="http://localhost:8090/HealthInsurance-MVC/jsp/Home.jsp">Home Page</a>

</body>
</html>