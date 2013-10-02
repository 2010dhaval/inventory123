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


	<FORM method="post" name="testForm" id="testForm" action=""
		onSubmit="return validateForm(this)" title=''
		style="width: 350px; margin: 0px;">

		<DIV id="tesDiv">


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
										<A class="boldbuttons" id="submit" tabindex=3><SPAN>Get
												Data </SPAN></A>
										<DIV class="buttonSeperator">&nbsp;</DIV><input type="hidden" name="ids" id="ids"><input type="hidden" name="quan" id="quan">
										<!-- <A class="boldbuttons" id="cancel" tabindex=4><SPAN>Cancel</SPAN></A>
										<DIV class="clearer"></DIV> -->
									</DIV></TD>
							</TR>

						</TABLE>
					</TD>
				</TR>
			</TABLE>


			<TABLE>
				<TR>
					<TD height="10px"></TD>
				</TR>
			</TABLE>



		</DIV>

		<DIV id="grid">
			<TABLE id="navgrid"></TABLE>
			<DIV id="pagernav"></DIV>
		</DIV>

		<TABLE>
			<TR>
				<TD height="10px"></TD>
			</TR>
		</TABLE>

		<DIV class="buttonwrapper" id="SubmidAndCancel" name="SubmidAndCancel">
			<A class="boldbuttons" id="create" tabindex=3><SPAN>Filter
					It </SPAN></A>

		</DIV>

		<TABLE>
			<TR>
				<TD height="30px"></TD>
			</TR>
		</TABLE>
		
		<DIV id="grid2">
			<TABLE id="navgrid2"></TABLE>
			<DIV id="pagernav2"></DIV>
		</DIV>
		
		<TABLE>
			<TR>
				<TD height="30px"></TD>
			</TR>
		</TABLE>
		

		<TABLE width="100%" border="0" cellpadding="0" cellspacing="1"
			bgcolor="cbb958" id="headerInput">
			<TR>
				<TD align="left" valign="top" bgcolor="#FFFFFF">
					<TABLE width="100%" border="0" cellspacing="0" cellpadding="0"
						class="formTable">
						<TR>
							<TD class="bold" colspan="2">Header Inputs</TD>
						</TR>


						<TR>
							<TD>Start of Validity Period</TD>
							<TD><INPUT type="text" name="startPeriod" id="startPeriod" /></TD>
						</TR>						
						
						<TR>
							<TD>End of Validity Period</TD>
							<TD><INPUT type="text" name="endPeriod" id="endPeriod" /></TD>
						</TR>
						
						<TR>
							<TD>Company Code</TD>
							<TD><INPUT type="text" name="compCode" id="compCode" /></TD>
						</TR>
						
						<TR>
								<TD colspan="2"><DIV class="buttonwrapper"
										id="SubmidAndCancel" name="SubmidAndCancel">
										<A class="boldbuttons" id="btnSave" tabindex=3>
										<SPAN>	Finally Save  </SPAN></A>
										<DIV class="buttonSeperator">&nbsp;</DIV>
										 <A class="boldbuttons" id="btnCancel" tabindex=4><SPAN>Cancel</SPAN></A>
										<DIV class="clearer"></DIV> 
									</DIV></TD>
									
						</TR>


					</TABLE>
				</TD>
			</TR>
		</TABLE>


	</FORM>



	<SCRIPT type="text/javascript"
		src="<%=request.getContextPath()%>/includes/js/testJS.jsp"></SCRIPT>
	<jsp:include page="footer.jsp" />
</BODY>
</HTML>