<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.healthInsurance.model.CompanyPolicies" import=" java.util.List" 
    import=" java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Insurance Policies</p>
 <%
 List<CompanyPolicies> companyPoliciesList = new ArrayList<CompanyPolicies>();
 companyPoliciesList = ( List<CompanyPolicies>)  request.getAttribute("companyPoliciesList");
%>

	<table style="width:100%">
  <tr>
  <th>Policy Id</th>
    <th>Percentage To be paid(%)</th>
    <th>Paying Duration(Months)</th>
    <th>Policy Type</th>
  </tr>
  <%
   for(CompanyPolicies cp :companyPoliciesList){
    %>
    <tr >
    <td><%= cp.getPolicyId() %></td>	
     <td><%= cp.getPercentageToBePaid() %></td>
  	 <td><%= cp.getPolicyDuration() %></td>	
     <td><%= cp.getPolicyBrief() %></td>
  	</tr>
  	
  <%	}%>
</table>

<br>
<div>
	<p>1.Claim settlement ratio of the above policies: 97%</p>
	<p>2.Network hospitals cover: Apollo Hospitals, Diha clinic, Dr. Kamakshi Memorial Hospital, Dr. Mehta's Hospital, Fortis Malar Hospital, Frontier Lifeline Hospital, HCG Cancer Centre, Kauvery Hospital, MIOT International, Nithra Institute of Sleep Sciences, Sankara Nethralaya etc.. </p>
	<p>3.Hospital rooms: Ac Private room or Ac sharing rooms available</p>
	<p>4.Waiting Period for preExistingIllness: 15 months after the policy taken date, customer can use the claim</p>
	<p>5.Miscellenous Charges like ambulance charges, health checkups etc. can be used under the policy claim amount</p>
	<p>6.This is a Family Health Insurance (upto 6 members). so, all the people whose aadhaar Numbers are included in the policy can utillize the Insurance amount.</p>

</div>

<br>
<div>
	<p>Percentage To be paid(%): this much percentage of Insurance Amount (choosen) will be paid Totally in Paying Duration </p>
	<p>Paying Duration: Number of months u have to pay monthly premium </p>
	<p>Policy Id: YY: last 2 digits of the year MM: month of the policy Bought </p>
	<p>policy Type: Health Problem: only health related problems you can use the Insurance amount </p>
	<p>policy Type: Health Problem + Death: If a person dies due to a health releated problem the family can take (Insurance amount/family members)- money spent on him previously</p>

</div>

 <a href="http://localhost:8090/HealthInsurance-MVC/jsp/Home.jsp">Home Page</a>

</body>
</html>