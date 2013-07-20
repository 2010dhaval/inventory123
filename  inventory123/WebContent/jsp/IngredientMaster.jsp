<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingredient Master</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<span id="loadingMsg" class="loadingMsg"
		style="background-color: red; color: white; font-size: 12px; display: none;">Loading
		Data, Please Wait....</span>
	<br />
	
	<div id="ingredientDiv">
		<form method="post" name="ingredientForm" id="ingredientForm" action="ingredientDataModifyAction"
			title='' style="width: 350px; margin: 0px;">
			
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="cbb958">
           	 <tr>
             	 <td align="left" valign="top" bgcolor="#FFFFFF">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td class="bold">Ingredient Details</td>
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
							<td><label class="errMsg">*</label>Ingredient Code:</td>
							<td><input type="text" name="ingCode" id="ingCode" value="" readonly="readonly"/>
							<label id="lblSearch"  
								style="cursor: pointer" >
								<a tabindex="2"> <img src="<%=request.getContextPath()%>/images/search_button.jpg"
									title="Search Ingredient" style="width: 21px; height: 18px"></a>
							</label>
							</td>
						</tr>
						<tr>
							<td><label class="errMsg">*</label>Ingredient Description:</td>
							<td><input type="text" name="ingDesc" id="ingDesc" width="200%"
								value="" /></td>
						</tr>
						
						<tr>
							<td><label class="errMsg">*</label>Range:</td>
							<td><select multiple name="range" id="range"></select></td>
						</tr>
						
						<tr>
							<td><label class="errMsg">*</label>Base UOM:</td>
							<td><select name="baseUOM" id="baseUOM"></select></td>
					    </tr>
						<tr>
							<td><label class="errMsg">*</label>Purchase Price:</td>
							<td><input type="text" name="purPrice" id="purPrice" width="200%"
								value="" /></td>
						</tr>
						
						<tr>
							<td><label class="errMsg">*</label>Warning Quantity:</td>
							<td><input type="text" name="warQty" id="warQty" width="200%"
								value="" /></td>
						</tr>
						
						<tr>
							<td colspan = "2">
							<div class="buttonwrapper">
	                  		<a class="boldbuttons"  id="submit"><span>Save</span></a>
	                  		<div class="buttonSeperator">&nbsp;</div>
	                  		<a class="boldbuttons"  id="delete"><span>Delete</span></a>
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
	<div id="dialog-modal" style="display: none">
		<div id="grid" class="gridDiv">
			<table id="gridId"></table>
			<div id="pagerId"></div>
		</div>
	</div>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/includes/js/IngredientDetailsJS.jsp"></script>
	<jsp:include page="footer.jsp" />
	</body>
		</html> 