<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" media="screen"
	href="<%=request.getContextPath()%>/css/commonCSS.jsp" />
	
<script src="<%=request.getContextPath()%>/includes/js/commonJS.jsp"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<%

String message=(String)(request.getAttribute("loginFailedMessage")==null?"":request.getAttribute("loginFailedMessage"));

%>
<script type="text/javascript">

if("<%=message%>"!="")
alert("<%=message%>");


function form_submit() 
{
	var username=jQuery("#txtUserName").val();
	var password=jQuery("#txtPassword").val();
	
	if(username==null || username=="")
		alert("Please Enter Username");
	else if(password==null || password=="")
		alert("Please Enter Password");
	else
  document.forms["loginForm"].submit();
}
</script>
</head>
<body>
<div class="container">
<div class="notbottom2">


   <div id="header">

		<div class="hdrlog">
  
   <div id="hmiddle"></div>
 
   <div id="logout"></div>
  
   <div id="hmiddle"></div>
  </div>
  <div class="hdrdwn"></div>
  </div>
    <div class="mid2">
	 <span class="boxleft1"></span>

  <%-- <span class="boxleft"><img src="<%=request.getContextPath()%>/images/ignou-logo.jpg" width="219" height="175" /></span> --%>
  <span class="boxmid"></span>
  <span class="boxright">
  <form action="<%=request.getContextPath()%>/loginAction.action" method="post" name="loginForm">
  <table width="330px;" border="0" cellpadding="0" cellspacing="0">
  
    <tr>
      <td align="left" valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="0">
        <tr>
          <td align="left" valign="top" bgcolor="#cbb958"><table width="100%" border="0" cellspacing="1" cellpadding="0">

            <tr>
              <td class="bold">&nbsp;Login</td>
            </tr>
            <tr>
              <td align="left" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="4" cellpadding="2">
             	
                <tr>
                  <td><table border="0"  cellpadding="6" cellspacing="0" style="width:100%">
                    <tr>

                      <td>User Name </td>
                      <td><input name="txtUserName" id="txtUserName" type="text" size="28" /></td>
                    </tr>
                    <tr>
                      <td>Password </td>
					  
                <td colspan="2"> <input type="password" name="txtPassword" id="txtPassword" size="28"> 
				</td>
                    </tr>					
					<!-- 	<tr>					
						
						<td colspan="2"><input type="checkbox" name="checkbox" value="checkbox" />Remember Me </td>
					<tr> -->
                  <td align="left" valign="top" colspan="2">  
                  
                  		
               	<!--  <div class="buttonwrapper"> 
                  		<a class="boldbuttons" id="btnForgot" onClick="forgot_pasword_open()"><span>Forgot Your Password?</span></a></div> 
                 </td> -->
                </tr>
                  </table></td>
                </tr>
                  
                <tr>
                  <td align="left" valign="top" >  
                  	 <div class="buttonwrapper"> 
                  		<a class="boldbuttons" href="#" onClick="javascript:form_submit();"><span>Login</span></a></div>                  		 
                 </td>
                </tr>
      
        
              </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>

  </table>
</form>
</span>
</div>
</div>
</div>


</body>
</html>