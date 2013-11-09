<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<% response.setContentType("text/javascript");%>
jQuery(function() 
{			
	jQuery("#navgrid").customgrid({ 
url:'rangeGridDataAction.action', 
datatype: "json",
 colNames:['Range Code','Range Description'],
  colModel:[ {name:'rangeCode',index:'rangeCode', width:100,editable:false,editoptions:{readonly:true,size:10}},
   {name:'rangeDesc',index:'rangeDesc', width:100,editable:true,editoptions:{size:10}},],
       rowNum:10, rowList:[10,20], 
       pager: '#pagernav',
        sortname: 'rangeCode',
        Edit:true,
        //multiselect:true,
        editurl:"rangeDataDeleteAction.action",
         viewrecords: true, sortorder: "desc",
         formDiv:"#rangeDiv",
		 formId:'#rangeForm',
		 gridDiv:'#grid', 
         caption:"Range Details" });	
});	

function validateForm(obj) {

	    var rangeCode = jQuery('#rangeCode').val();
		var rangeDesc = jQuery('#rangeDesc').val();
		   
		if (!isEmpty(rangeCode, "Please Fill in your Range Code", "#rangeCode")) {
			return false;
		} 
		else if (!isValidName(rangeCode, "Please Enter valid Range Code", "#rangeCode")) {
			return false;
		}
		else if (!isEmpty(rangeDesc, "Please Fill in your Range Description", "#rangeDesc")) {
			return false;
		} 
		else if (!isValidName(rangeDesc, "Please Enter valid Range Description", "#rangeDesc")) {
			return false;
		}
		else
		{
		return true; 
		}	
	}
	
	
 $("#submit").click(function()
		{
		if (validateForm(document.forms[0]) == true)
        {
		      		// bind 'myForm' and provide a simple callback function 
						jQuery('#rangeForm').ajaxSubmit(
						{
							dataType : "json",
							url : "rangeDataModifyAction.action",
							success : function(responseText) {
								
								if (responseText.status == "success") {
									jQuery("#errMsg").text();
									alert("Range Details Saved Successfully!");
									displayAndReloadGrid();
								} else {
								
								 jQuery("#errMsg").text(responseText.errorMessage);
									//alert(responseText.errorMessage);
								}
							}
						});
				}
		}); 
		jQuery('#cancel').click(displayAndReloadGrid);
	
function displayAndReloadGrid()
		{
		jQuery("#errMsg").text("");
			jQuery('#rangeForm')[0].reset();
			jQuery("#rangeDiv").hide();
			jQuery("#grid").show();
		    jQuery('#navgrid').trigger("reloadGrid");
		}
 