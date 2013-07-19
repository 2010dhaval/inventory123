<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta http-equiv="pragma" content="no-cache" />
    <title></title>
    <link rel="stylesheet" href="../css/style1.css" type="text/css" />
    <script type="text/javascript" language="JavaScript" src="../js/common1.js"></script>
    <link rel="stylesheet" media="screen"
	href="<%=request.getContextPath()%>/css/commonCSS.jsp" />
	
<script src="<%=request.getContextPath()%>/includes/js/commonJS.jsp"></script>
    
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

function register()
{
	document.forms["loginForm"].action="register.action";
	document.forms["loginForm"].submit(); 
}
</script>
  
</head> 
<body class="loginbody">
  <form action="<%=request.getContextPath()%>/loginAction.action" method="post" id="loginForm" name="loginForm">
        <!-- <div id="updPanel">
            <div class="title"><div class="logo">  <a href="http://www.ignou.ac.in/" target="_blank"><img src="../images/logo.gif" class="image" alt="IGNOU" /></a></div></div> -->
        <div id="login_header">
            <div id="header_line1"></div>
        </div>
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

                      <td>User Name</td>
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
                <!--    <td align="left" valign="top" colspan="2">  
                  
                  		
               	<div class="buttonwrapper"> 
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
              <!--   <tr>
                <td align="left" valign="top" colspan="2">  
                  
               	<div class="buttonwrapper"> 
                  		<a href="javascript:register();">Register!</a>  </div>
                 </td>
                 </tr> -->
              </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>

  </table>
</form> 
</body>

</html>
