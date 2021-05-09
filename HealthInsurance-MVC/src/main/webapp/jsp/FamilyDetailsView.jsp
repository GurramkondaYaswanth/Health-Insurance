<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.healthInsurance.model.FamilyDetails" import=" java.util.List" 
    import="com.healthInsurance.model.PreExistingIllness" import=" java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Family Detailss</title>
</head>
<body>


<p>Insurance Policies</p>
 <%
 List<FamilyDetails> familyDetailslist = new ArrayList<FamilyDetails>();
 familyDetailslist = (List<FamilyDetails>)  request.getAttribute("FamilyDetailslist");
%>

	<table style="width:100%">
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
	<table style="width:100%">
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


 <a href="${pageContext.request.contextPath}/jsp/Home.jsp">Home Page</a>
 
</body>
</html>