<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../../js/jquery-1.6.2.min.js"></jsp:include>
<jsp:include page="../../js/i18n/grid.locale-en.js"></jsp:include>
<jsp:include page="../../js/jquery.jqGrid.min.js"></jsp:include>
<jsp:include page="../../js/jquery-ui-1.8.15.custom.min.js"></jsp:include>
<jsp:include page="../../js/jquery.form.js"></jsp:include>
<jsp:include page="../../js/hoverIntent.js"></jsp:include>
<jsp:include page="../../js/supersubs.js"></jsp:include>
<jsp:include page="../../js/superfish.js"></jsp:include> 

<jsp:include page="../../js/jquery.jqGrid.min.js"></jsp:include>
<jsp:include page="../../js/validation.js"></jsp:include>

/*============== Custom Grid Plugin ================ */
<jsp:include page="../../js/jquery.customgrid.js"></jsp:include>

/*============== Custom Nifsys Display Message Plugin ================ */
<jsp:include page="../../js/jquery.nifsysdisplaymessage.js"></jsp:include>

/*============== Custom Nifsys AutoComplete Plugin ================ */
<jsp:include page="../../js/jquery.nifsysautocomplete.js"></jsp:include>


function autoCompleteCB_appendAll(data){
	var tempData = new Array();
	tempData = tempData.concat([{id:"null",value:"All"}],data);
	return tempData ;
}