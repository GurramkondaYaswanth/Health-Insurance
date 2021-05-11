<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.healthInsurance.model.FamilyDetails" import=" java.util.List" 
    import="com.healthInsurance.model.PreExistingIllness" import=" java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#familyDetails, #Preillness {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#familyDetails td, #familyDetails th, #Preillness td , #Preillness th {
  border: 1px solid #ddd;
  padding: 8px;
}

#familyDetails tr:nth-child(even){background-color: #f2f2f2;}

#familyDetails tr:hover {background-color: #ddd;}

#Preillness tr:nth-child(even){background-color: #f2f2f2;}

#Preillness tr:hover {background-color: #ddd;}

#familyDetails th,  #Preillness th {
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
<title>Family Detailss</title>
</head>
<body>


<h3>Insurance Policies</h3>
 <%
 List<FamilyDetails> familyDetailslist = new ArrayList<FamilyDetails>();
 familyDetailslist = (List<FamilyDetails>)  request.getAttribute("FamilyDetailslist");
%>

	<table style="width:100%" id="familyDetails">
  <tr>
  <th>Customer Id</th>
    <th>Aadhaar Number</th>
    <th>Date of birth</th>
    <th>Name</th>
     <th>Gender</th>
  </tr>
  <%
   for(FamilyDetails fd :familyDetailslist){
    %>
    <tr >
    <td><%= fd.getFamilyMemberId().getCusId() %></td>	
     <td><%= fd.getFamilyMemberId().getAadhaarNumber() %></td>	
  	 <td><%= fd.getDob() %></td>	
     <td><%= fd.getNames() %></td>	
  	 <td><%= fd.getGender() %></td>	
  	</tr>
  	
  <%	}%>
</table>
<br>

<h3>Pre-Existing Illness of family Members</h3>
	<table style="width:100%" id="Preillness">
  <tr>
  <th>Aadhaar Number</th>
    <th>Name</th>
    <th>Illness</th>
  </tr>
  <%
   for(FamilyDetails fd :familyDetailslist){
	   for(PreExistingIllness pei :fd.getPreExistingIllness()){
    %>
    <tr >
    <td><%= pei.getIllnessIdentity().getAadhaarNumber() %></td>	
      <td><%= fd.getNames() %></td>	
  	 <td><%= pei.getIllnessIdentity().getPreExistingIllness() %></td>	
     
  	</tr>
  	
  <%	}}%>
</table>


 <a href="http://localhost:8090/HealthInsurance-MVC/jsp/Home.jsp">Home Page</a>
 
</body>
</html>