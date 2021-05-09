<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="com.healthInsurance.bussinesslogic.MonthlyPremium" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		int InsurPolicyType = Integer.parseInt(request.getParameter("InsuranceType"));
	    int PayDuration = Integer.parseInt(request.getParameter("PayDuration")); 
		long InsuranceAmount = Long.parseLong(request.getParameter("InsuranceAmount")); 
		
		MonthlyPremium monthlyPremium =new MonthlyPremium();
		long monthlyPrem = monthlyPremium.calculationMonthlyPremium(InsuranceAmount, PayDuration, InsurPolicyType);
		
		if(InsurPolicyType == 1){
		out.println("If you choose this plan of Health with "+PayDuration+" years you have to pay "+monthlyPrem+" for "+PayDuration*12 +"months");
		}else{
			out.println("If you choose this plan of Health+Death with "+PayDuration+" years you have to pay "+monthlyPrem+" for "+PayDuration*12 +"months");
		}
				
		%>
		<br>
		<a href="http://localhost:8090/HealthInsurance-MVC/jsp/Home.jsp">Home Page</a>
</body>
</html>