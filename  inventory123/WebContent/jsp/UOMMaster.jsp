<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Master</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="grid">
		<table id="navgrid"></table>
		<div id="pagernav"></div>
	</div>
	<div id="uomDiv" style="display: none">
		<form method="post" name="uomForm" id="uomForm" action="uomDataModifyAction"
			title='' style="width: 350px; margin: 0px;">
			
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="cbb958">
           	 <tr>
             	 <td align="left" valign="top" bgcolor="#FFFFFF">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td class="bold">UOM Details</td>
					</tr>
					
					<tr>
					<td valign="top" align="left" >
						<table cellspacing="10" cellpadding="0" border="0" align="center" style="width:100%">
					<tbody>
						<tr>
							<td colspan="2"><div id ="info" class="infoMsg">Fields marked with * are compulsory</div>
				<div class = "errMsg" id = "errMsg"></div></td>
						</tr>
						
						<tr>
							<td><label class="errMsg">*</label>UOM Code:</td>
							<td><input type="text" name="id" id="id" value="" />
							</td>
						</tr>
						
						
						<tr>
							<td><label class="errMsg">*</label>UOM Description:</td>
							<td><input type="text" name="uomName" id="uomName" width="200%"
								value="" /></td>
						</tr>
						
						<tr>
							<td colspan = "2">
							<div class="buttonwrapper">
	                  		<a class="boldbuttons"  id="submit"><span>Save </span></a>
	                  		<div class="buttonSeperator">&nbsp;</div>
	                  		<a class="boldbuttons"  id="cancel"><span>Cancel</span></a>
	                  		<div class="clearer"></div>
	                  		
	                  	</div>
							</td>
							</tr>
					
						
					</tbody>
				</table>
				</td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
			
		</form>
	</div>
		<script type="text/javascript"
		src="<%=request.getContextPath()%>/includes/js/UOMDetailsJS.jsp"></script>
	<jsp:include page="footer.jsp" />
	</body>
</html>