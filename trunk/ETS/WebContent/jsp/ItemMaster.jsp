<!-- 
Author : Dhaval Mehta
Date : 20/07/2013
Purpose : For save items of finished goods and edit details of it including ingrients used in it..

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Master</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<span id="loadingMsg" class="loadingMsg" style="background-color: red; color: white; font-size: 12px; display: none;">
	Loading Data, Please Wait..
	</span>
	<br />

	<div id="itemDiv">
		<form method="post" name="itemMasterForm" id="itemMasterForm" action="itemMasterDataModifyAction" title=''
		style="width: 350px; margin: 0px;">

			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="cbb958">
				<tr>
					<td align="left" valign="top" bgcolor="#FFFFFF">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="bold">Item Details</td>
							</tr>

							<tr>
								<td valign="top" align="left">
									<table cellspacing="10" cellpadding="0" border="0"
										align="center" style="width: 100%">
										<tbody>
											<tr>
												<td colspan="2"><div id="info" class="infoMsg">Fields
														marked with * are compulsory</div>
													<div class="errMsg" id="errMsg"></div></td>
											</tr>

											<tr>
												<td><label class="errMsg">*</label>Item Code:</td>
												<td><input type="text" name="itemCode" id="itemCode"
													value="" readonly="readonly" /> <label id="lblSearch"
													style="cursor: pointer"> <a tabindex="2"> <img
															src="<%=request.getContextPath()%>/images/search_button.jpg"
															title="Search Item"
															style="width: 21px; height: 18px"></a>
												</label></td>
											</tr>
											<tr>
												<td><label class="errMsg">*</label>Item	Description:</td>
												<td><input type="text" name="itemDesc" id="itemDesc"
													width="200%" value="" /></td>
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
												<td><label class="errMsg">*</label>Selling Price:</td>
												<td><input type="text" name="sellingPrice" id="sellingPrice"
													width="200%" value="" /></td>
											</tr>

											<tr>
												<td><label class="errMsg">*</label>Warning Quantity:</td>
												<td><input type="text" name="warQty" id="warQty"
													width="200%" value="" /></td>
											</tr>

											<tr>
												<td colspan="2">
													<div class="buttonwrapper">
														<a class="boldbuttons" id="submit"><span>Save</span></a>
														<div class="buttonSeperator">&nbsp;</div>
														<a class="boldbuttons" id="delete"><span>Delete</span></a>
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
		src="<%=request.getContextPath()%>/includes/js/ItemMasterDetailsJS.jsp"></script>
	<jsp:include page="footer.jsp" />

</body>
</html>