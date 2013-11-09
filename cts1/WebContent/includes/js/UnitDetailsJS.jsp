<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<% response.setContentType("text/javascript");%>
jQuery(function() 
{			
	jQuery("#navgrid").customgrid({ 
url:'unitGridDataAction.action', 
datatype: "json",
 colNames:['Unit Code','Unit Name','Unit Address','Responsible Person Name','Responsible Person Contact No'],
  colModel:[ {name:'unitCode',index:'unitCode', width:100,editable:false,editoptions:{readonly:true,size:10}},
   {name:'unitName',index:'unitName', width:100,editable:true,editoptions:{size:10}},
   {name:'unitAddress',index:'unitAddress', width:100,editable:true,editoptions:{size:10}},
   {name:'resPerName',index:'resPerName', width:100,editable:true,editoptions:{size:10}},
   {name:'resPerContactNo',index:'resPerContactNo', width:100,editable:true,editoptions:{size:10}},
   ],
       rowNum:10, rowList:[10,20], 
       pager: '#pagernav',
        sortname: 'unitCode',
        Edit:true,
        //multiselect:true,
        editurl:"unitDataDeleteAction.action",
         viewrecords: true, sortorder: "desc",
         formDiv:"#unitDiv",
		 formId:'#unitForm',
		 gridDiv:'#grid', 
         caption:"Unit Details" });	
});	

function validateForm(obj) {

	    var unitCode = jQuery('#rangeCode').val();
		var unitName = jQuery('#unitName').val();
		var unitAddress = jQuery('#unitAddress').val();
		var resPerName = jQuery('#resPerName').val();
		var resPerContactNo = jQuery('#resPerContactNo').val();
		   
		if (!isEmpty(unitName, "Please Fill in your Unit Name", "#unitName")) {
			return false;
		} 
		else if (!isValidName(unitName, "Please Enter valid Unit Name", "#unitName")) {
			return false;
		}
		else if (!isEmpty(unitAddress, "Please Fill in your Unit Address", "#unitAddress")) {
			return false;
		} 
		else if (!isValidName(unitAddress, "Please Enter valid Unit Address", "#unitAddress")) {
			return false;
		}
		else if (!isEmpty(resPerName, "Please Fill in your Responsible Person Name", "#resPerName")) {
			return false;
		} 
		else if (!isValidName(resPerName, "Please Enter valid Responsible Person Name", "#resPerName")) {
			return false;
		}
		else if (!isEmpty(resPerContactNo, "Please Fill in your Responsible Person Contact No", "#resPerContactNo")) {
			return false;
		} 
		/* else if (!isValidName(resPerContactNo, "Please Enter valid Responsible Person Contact No", "#resPerContactNo")) {
			return false;
		} */
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
						jQuery('#unitForm').ajaxSubmit(
						{
							dataType : "json",
							url : "unitDataModifyAction.action",
							success : function(responseText) {
								
								if (responseText.status == "success") {
									jQuery("#errMsg").text();
									alert("Unit Details Saved Successfully!");
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
			jQuery('#unitForm')[0].reset();
			jQuery("#unitDiv").hide();
			jQuery("#grid").show();
		    jQuery('#navgrid').trigger("reloadGrid");
		}
 