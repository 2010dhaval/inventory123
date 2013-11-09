<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<% response.setContentType("text/javascript");%>
jQuery(function() 
{			
	jQuery("#navgrid").customgrid({ 
url:'uomGridDataAction.action', 
datatype: "json",
 colNames:['UOM Code','UOM Description'],
  colModel:[ {name:'id',index:'id', width:100,editable:false,editoptions:{readonly:true,size:10}},
   {name:'uomName',index:'uomName', width:100,editable:true,editoptions:{size:10}}, ],
       rowNum:10, rowList:[10,20], 
       pager: '#pagernav',
        sortname: 'id',
        Edit:true,
        //multiselect:true,
        editurl:"uomDataDeleteAction.action",
         viewrecords: true, sortorder: "desc",
         formDiv:"#uomDiv",
		 formId:'#uomForm',
		 gridDiv:'#grid', 
         caption:"UOM Details" });	
});	

function validateForm(obj) {
		var UOMCode = jQuery('#id').val();
		var UOMDesc = jQuery('#uomName').val();
		   
		if (!isEmpty(UOMCode, "Please Fill in your UOM Code", "#id")) {
			return false;
		} 
		else if (!isValidName(UOMCode, "Please Enter valid UOM Code", "#id")) {
			return false;
		}
		else if (!isEmpty(UOMDesc, "Please Fill in your UOM Description", "#uomName")) {
			return false;
		} 
		else if (!isValidName(UOMDesc, "Please Enter valid UOM Description", "#uomName")) {
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
						jQuery('#uomForm').ajaxSubmit(
						{
							dataType : "json",
							url : "uomDataModifyAction.action",
							success : function(responseText) {
								
								if (responseText.status == "success") {
									jQuery("#errMsg").text();
									alert("UOM Details Saved Successfully!");
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
			jQuery('#uomForm')[0].reset();
			jQuery("#uomDiv").hide();
			jQuery("#grid").show();
		    jQuery('#navgrid').trigger("reloadGrid");
		}
 