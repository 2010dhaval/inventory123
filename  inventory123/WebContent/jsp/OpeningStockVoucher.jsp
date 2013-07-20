<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Opening Stock Voucher</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<span id="loadingMsg" class="loadingMsg"
		style="background-color: red; color: white; font-size: 12px; display: none;">Loading
		Data, Please Wait....</span>
	<br />
	
	<div id="openingStockVoucherDiv">
		<form method="post" name="openingStockVoucherForm" id="openingStockVoucherForm" action=""
			title='' style="width: 350px; margin: 0px;">
			
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="cbb958">
           	 <tr>
             	 <td align="left" valign="top" bgcolor="#FFFFFF">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td class="bold">Opening Stock Voucher</td>
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
							<td><label class="errMsg">*</label>Voucher Code:</td>
							<td><input type="text" name="voucherCode" id="voucherCode" value="" readonly="readonly"/>
							<%-- <label id="lblSearch"  
								style="cursor: pointer" >
								<a tabindex="2"> <img src="<%=request.getContextPath()%>/images/search_button.jpg"
									title="Search Ingredient" style="width: 21px; height: 18px"></a>
							</label> --%>
							</td>
						</tr>
						<tr>
							<td><label class="errMsg">*</label> Select Item:</td>
							<td><input type="text" name="itemDesc" id="itemDesc" width="200%"
								value="" />
								<input type="text" name="itemCode" id="itemCode" style="display: none" width="200%"
								value="" />
								<label id="lblSearch"  
								style="cursor: pointer" >
								<a tabindex="2"> <img src="<%=request.getContextPath()%>/images/search_button.jpg"
									title="Search Item" style="width: 21px; height: 18px"></a>
							</label>
								</td>
						</tr>
						<tr>
							<td><label class="errMsg">*</label>Unit:</td>
							<td><select name="unit" id="unit"></select></td>
					    </tr>
						
						<tr>
							<td><label class="errMsg">*</label>Base UOM:</td>
							<td><select name="baseUOM" id="baseUOM"></select></td>
					    </tr>
						<tr>
							<td><label class="errMsg">*</label>Opening Date:</td>
							<td><input type="text" name="openingDate" id="openingDate" width="200%"
								value="" /></td>
						</tr>
						
						<tr>
							<td><label class="errMsg">*</label>Opening Quantity:</td>
							<td><input type="text" name="openingQty" id="openingQty" width="200%"
								value="" /></td>
						</tr>
						
						<tr>
							<td><label class="errMsg">*</label>Damaged Quantity:</td>
							<td><input type="text" name="damagedQty" id="damagedQty" width="200%"
								value="" /></td>
						</tr>
						
						<tr>
							<td><label class="errMsg">*</label>Damaged Quantity UOM:</td>
							<td><select name="damagedQtyUOM" id="damagedQtyUOM"></select></td>
					    </tr>
						
						<tr>
							<td><label class="errMsg">*</label>Buying Price:</td>
							<td><input type="text" name="buyingPrice" id="buyingPrice" width="200%"
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
		src="<%=request.getContextPath()%>/includes/js/OpeningStockVoucherJS.jsp"></script>
	<jsp:include page="footer.jsp" />
	</body>
		</html> 