<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Requisition Item Group</TITLE>
</HEAD>
<BODY>
	<jsp:include page="header.jsp" />

	<DIV id="tesDiv">
		<FORM method="post" name="testForm" id="testForm" action=""
			onSubmit="return validateForm(this)" title=''
			style="width: 350px; margin: 0px;">

			<TABLE width="100%" border="0" cellpadding="0" cellspacing="1"
				bgcolor="cbb958">
				<TR>
					<TD align="left" valign="top" bgcolor="#FFFFFF">
						<TABLE width="100%" border="0" cellspacing="0" cellpadding="0"
							class="formTable">
							<TR>
								<TD class="bold" colspan="2">Requisition Item Group</TD>
							</TR>

							<TR>
								<TD colspan="2" id="errMsg" style="color: red"></TD>
							</TR>

							<TR>
								<TD>Material Group:</TD>
								<TD><SELECT name="materialGrp" id="materialGrp"></SELECT></TD>
							</TR>
							<TR>
								<TD>Purchase Group:</TD>
								<TD><SELECT name="purchaseGrp" id="purchaseGrp"></SELECT></TD>
							</TR>
							<TR>
								<TD colspan="2"><DIV class="buttonwrapper"
										id="SubmidAndCancel" name="SubmidAndCancel">
										<A class="boldbuttons" id="submit" tabindex=3><SPAN>Get Data
										</SPAN></A>
										<DIV class="buttonSeperator">&nbsp;</DIV>
										<!-- <A class="boldbuttons" id="cancel" tabindex=4><SPAN>Cancel</SPAN></A>
										<DIV class="clearer"></DIV> -->
									</DIV></TD>
							</TR>

							


						</TABLE>
					</TD>
					
				</TR>
				
			</TABLE>









		</FORM>
		<table><TR>
								<TD height="10px"></TD>
							</TR></table>

		

	</DIV>

<DIV id="grid" >
			<TABLE id="navgrid"></TABLE>
<div id="pagernav"></div>
		</DIV>


	<SCRIPT type="text/javascript"
		src="<%=request.getContextPath()%>/includes/js/testJS.jsp"></SCRIPT>
	<jsp:include page="footer.jsp" />
</BODY>
</HTML>