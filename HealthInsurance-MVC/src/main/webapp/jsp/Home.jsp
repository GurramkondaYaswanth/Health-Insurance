<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<!--  <h1>Welcome to  </h1> -->
	 <nav>
        <div>Life Health Insurance</div>
        <ul>
        	 <li> <a href="${pageContext.request.contextPath}/CompanyPoliciesView">View ALL Company Policies</a></li>
             <li> <a href="${pageContext.request.contextPath}/PolicyView">View Applied Policy</a></li>
            <li> <a href="${pageContext.request.contextPath}/View">View Profile</a></li>
            <li> <a href="${pageContext.request.contextPath}/FamilyDetailsView">Family Details</a></li>
         </ul>
    </nav>
</body>
</html>