<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<% response.setContentType("text/javascript");%>
jQuery(function() 
{			
	jQuery("#navgrid").customgrid({ 
url:'taxGridDataAction.action', 
datatype: "json",
 colNames:['Tax Code','Tax Description','Tax Percentage'],
  colModel:[ {name:'taxCode',index:'taxCode', width:100,editable:false,editoptions:{readonly:true,size:10}},
   {name:'taxDesc',index:'taxDesc', width:100,editable:true,editoptions:{size:10}},{name:'taxPer',index:'taxPer', width:100,editable:true,editoptions:{size:10}}, ],
       rowNum:10, rowList:[10,20], 
       pager: '#pagernav',
        sortname: 'taxCode',
        Edit:true,
        //multiselect:true,
        editurl:"taxDataDeleteAction.action?taxCode"+taxCode,
         viewrecords: true, sortorder: "desc",
         formDiv:"#taxDiv",
		 formId:'#taxForm',
		 gridDiv:'#grid', 
         caption:"Tax Details" });	
});	

function validateForm(obj) {

	    var taxCode = jQuery('#taxCode').val();
		var taxDesc = jQuery('#taxDesc').val();
		var taxPer = jQuery('#taxPer').val();
		   
		if (!isEmpty(taxCode, "Please Fill in your Tax Code", "#taxCode")) {
			return false;
		} 
		else if (!isValidName(taxCode, "Please Enter valid Tax Code", "#taxCode")) {
			return false;
		}
		else if (!isEmpty(taxDesc, "Please Fill in your Tax Description", "#taxDesc")) {
			return false;
		} 
		else if (!isValidName(taxDesc, "Please Enter valid Tax Description", "#taxDesc")) {
			return false;
		}
		else if (!isEmpty(taxPer, "Please Fill in your Tax Percentage", "#taxPer")) {
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
						jQuery('#taxForm').ajaxSubmit(
						{
							dataType : "json",
							url : "taxDataModifyAction.action",
							success : function(responseText) {
								
								if (responseText.status == "success") {
									jQuery("#errMsg").text();
									alert("Tax Details Saved Successfully!");
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
			jQuery('#taxForm')[0].reset();
			jQuery("#taxDiv").hide();
			jQuery("#grid").show();
		    jQuery('#navgrid').trigger("reloadGrid");
		}
 