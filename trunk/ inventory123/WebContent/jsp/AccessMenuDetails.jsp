
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menu Access Details</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<form method="post" name="accessMenu" id="accessMenu" title=''
		style="width: 350px; margin: 0px;">
		
		 <table width="330px;" border="0" cellpadding="0" cellspacing="0">
  
    <tr>
      <td align="left" valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="0">
        <tr>
          <td align="left" valign="top" bgcolor="#cbb958"><table width="100%" border="0" cellspacing="1" cellpadding="0">

            <tr>
              <td class="bold">&nbsp;ACCESS CONFIGURATION</td>
            </tr>
            <tr>
              <td align="left" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="4" cellpadding="2">
             	<tr> 
              			<td colspan="2">
              				
						</td>
				</tr>
                <tr>
                  <td><table border="0"  cellpadding="6" cellspacing="0" style="width:100%">
                    <tr>
				<tr>
							<td colspan="2" id="errMsg" style="color: red"></td>
						</tr>
		
		
		  <tr>
                  <td>User Type</td>
					<td><select name="ddlUserType" id="ddlUserType" onchange="changeUserType();">
						 <option value="1">Admin</option>
                         <option value="2">Student</option>
                         <option value="3">Staff</option>
                         </select></td>
                   </tr>
                   <tr>
                   <td>      
					<div class="buttonwrapper">
	                  		<a class="boldbuttons"  id="getData" ><span>Get Menu List </span></a>
			</div>
			</td>
			</tr>
			<div id="menuAccessTabs" style="display: none">
			<ul id="menuAccessTree">
			</ul>
			<div class="buttonwrapper">
	                  		<a class="boldbuttons" id="submit"><span>Submit </span></a>
	                  		<div class="buttonSeperator">&nbsp;</div>
	                  		<a class="boldbuttons" id="bttnCancel"><span>Cancel</span></a>
	                  		<div class="clearer"></div>
	                  	</div>
				<input type="hidden" id= "save" name="save" value= "false">
				</div>
				</div>
				</table>
				</td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
			
		
	</form>
	<jsp:include page="footer.jsp" />
	<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/includes/css/AccessMenuDetailsCSS.jsp" />
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/includes/js/AccessMenuDetailsJS.jsp"></script>
</body>
</html>