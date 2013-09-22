<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Branch Wise Holidays</title>
	</head>
<body>
<jsp:include page="header.jsp" />
	<div id="grid" >
			<table id="navgrid"></table>
					
		</div>
	<div id="tesDiv">
		<form method="post" name="testForm" id="testForm" action="" onSubmit="return validateForm(this)"
			title='' style="width: 350px; margin: 0px;">
			<fieldset>
				<legend></legend>
				<table>
					<tbody>
						<tr>
							<td colspan="2" id="errMsg" style="color: red"></td>
						</tr>
					
							<tr >
							<td>Material Group:</td>
							<td><select name="materialGrp" id="materialGrp"></select></td>
						</tr>
							<tr >
							<td>Purchase Group:</td>
							<td><select name="purchaseGrp" id="purchaseGrp"></select></td>
						</tr>
						
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>	
		<table>
		<tbody>
		
		
		<tr>
 <td colspan="2"><div class="buttonwrapper" id = "SubmidAndCancel" name = "SubmidAndCancel" >
	                  		<a class="boldbuttons" id="submit" tabindex=3><span>Submit </span></a>
	                  		<div class="buttonSeperator">&nbsp;</div>
	                  		<a class="boldbuttons"  id="cancel" tabindex=4><span>Cancel</span></a>
	                  		<div class="clearer"></div>
	                  	</div></td>
 </tr>

    
    
    </tbody>
    </table>
   <script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/testJS.jsp"></script>   
    <jsp:include page="footer.jsp" />
</body>
</html>