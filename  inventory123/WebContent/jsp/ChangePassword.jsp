<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function validateLoginForm()
{

	var oldPassword=jQuery('#oldPassword').val();
	var newPassword=jQuery('#newPassword').val();
	var confirmPassword=jQuery('#confirmPassword').val();
	
	
	if (!isEmpty(oldPassword, "Please Fill in your Old Password ", "#oldPassword")) {
		return false;
	}
	else if (!isEmpty(newPassword, "Please Fill in your New Password ", "#newPassword")) {
		return false;
	} 
	else if (!isEmpty(confirmPassword, "Please Fill in your Confirm Password ", "#confirmPassword")) {
		return false;
	} 
	
	
	else {
		return true;
		}
		return true;
}

</script>


<title>Change Password Details</title>


</head>
<body>
	<jsp:include page="header.jsp" />
	<br />
	<br />
	<div id="gridwrapper">
		<table id="navgrid"></table>
		<div id="pagernav"></div>
	</div>
	<div id="changepasswordDiv" >
		<!-- <form method="post" name="changepasswordForm" id="changepasswordForm"
		action = "changePasswordDetails" title=''
			style="width: 350px; margin: 0px;">
			 -->
			<!--  action="familyDetailDataModifyAction" -->
			
			
			
			<form action="changePasswordDetails" method="post" name="changepasswordForm" id="changepasswordForm">
			
			 <table width="330px;" border="0" cellpadding="0" cellspacing="0">
  
    <tr>
      <td align="left" valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="0">
        <tr>
          <td align="left" valign="top" bgcolor="#cbb958"><table width="100%" border="0" cellspacing="1" cellpadding="0">

            <tr>
              <td class="bold">&nbsp;Change Password</td>
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
               <td style="display: none">Id<td>
               <input type="hidden" name ="id"  id ="id" value="0">
               </td>
        </tr>
		
		
	   <tr>
               <td>Enter Your Old Password
               <td>
               <input type="password" name ="oldPassword"  id ="oldPassword" value ="">
               </td>
        </tr>
               
               
             <tr>
               <td>Enter New Password
               <td>
               <input type="password" name ="newPassword"  id = "newPassword" value ="">
               </td>
             </tr>
               
               
            <tr>
               <td>Enter Confirm Password
               <td>
               <input type="password" name ="confirmPassword" id="confirmPassword" value ="">
               </td>
            </tr>
	
	 	<tr>
 						<td colspan="2"><div class="buttonwrapper">
	                  		<a class="boldbuttons" id="submit" tabindex="5"><span>Submit </span></a>
	                  		<div class="buttonSeperator">&nbsp;</div>
	                  		<a class="boldbuttons"  id="cancel" tabindex="6"><span>Reset</span></a>
	                  		<div class="clearer"></div>
	                  	</div></td>
				 </tr>
	
</tbody>
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

<script type="text/javascript">
jQuery("#submit").click(saveData);

function saveData() 
{
 if (validateLoginForm() == true)
{
	 jQuery('#changepasswordForm').ajaxSubmit(
				{
					dataType : "json",
					url : "changePasswordDetails.action",
					success : function(responseText) {
						
						if (responseText.status == "success") {
							jQuery("#errMsg").text();
							alert("Password Details Saved Successfully!");
							displayAndReloadGrid();
							
						} else {
							
								alert(responseText.errorMessage);
								//alert("Cnt save password");
						}
					}
				});	
}
  
 else
  return;
}




function displayAndReloadGrid()
{
	jQuery('#changepasswordForm')[0].reset();
	/* jQuery("#familyDetailDiv").hide();
	jQuery("#gridwrapper").show();
    jQuery('#navgrid').trigger("reloadGrid"); */
}


jQuery('#cancel').click(displayAndReloadGrid);



</script>
</div>
					<jsp:include page="footer.jsp" />
					</body>
</html>