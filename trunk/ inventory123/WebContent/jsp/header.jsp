<%@page import="com.untitle.inventory.dto.UserMasterDTO"%>
<%@page import="java.util.*"%>
<%@page import="com.untitle.inventory.dto.MenuMasterDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" media="screen"
	href="<%=request.getContextPath()%>/css/commonCSS.jsp" />
	
<script src="<%=request.getContextPath()%>/includes/js/commonJS.jsp"></script>
<script>
	$(document).ready(function() {
		$("#Menu").supersubs({ 
            minWidth:    10,    
            maxWidth:    20,    
            extraWidth:  1            
        }).superfish();
	});
</script>
</head>
<% UserMasterDTO userDetails = (UserMasterDTO)session.getAttribute("userDetails"); 
if(userDetails !=null)
{
%>
<body>
<div class="container">
<div class="notbottom2">
    <div id="header">
		<div class="header2">
  <%-- <div id="logo"><img src="<%=request.getContextPath()%>/images/ignou-logo.jpg" width="60" height="46" /></div> --%>  
   <div id="logout"><a href="<%=request.getContextPath()%>/logout.action">Logout</a></div>
  
   <div id="hmiddle">Welcome <a href="<%=request.getContextPath()%>/jsp/ChangePassword.jsp"> <%= userDetails.getFirstName() + " " + userDetails.getLastName() %></a></div>
  </div>
  
  <div class="clearer"></div>
    <div class="strip"></div>
	<ul class="sf-menu" id="Menu">
		<%
			List menuDetails = (List) session.getAttribute("menuDetails");
			out.println(getMenuDetails(menuDetails,request.getContextPath()));
		%>
		<%!public String getMenuDetails(List menuDetails,String contextPath)
		{
		
		StringBuilder retValue = new StringBuilder("");
		
		for (int i = 0; i < menuDetails.size(); i++) 
		{
			MenuMasterDTO menu = (MenuMasterDTO) menuDetails.get(i);
			retValue.append("<li>");
			if(menu.getUrl() != null)
				retValue.append("<a href='" + contextPath + menu.getUrl() + "'>" + menu.getDescription() + "</a>");
			else
				retValue.append("<a>"+ menu.getDescription()+"</a>" );
			if (menu.getChildMenu() != null && menu.getChildMenu().size() != 0) {
				retValue.append("<ul>");
				retValue.append(getMenuDetails(menu.getChildMenu(),contextPath));
				retValue.append("</ul>");
			}
			retValue.append("</li>");
		}
		return retValue.toString();
	}%>
	</ul>
     <div class="mid2">
	<span class="marea" style="width:90%">
<%
}
else
{
	response.sendRedirect(request.getContextPath()+"/jsp/HomePage.jsp");
}
%>	