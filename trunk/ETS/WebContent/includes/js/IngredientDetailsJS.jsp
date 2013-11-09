<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<% response.setContentType("text/javascript");%>
	jQuery(document).ready(function() 
				{	
			
			$.ajax({

                url:"getAllRange.action",
    			dataType : "json",
 				success: function(responseText) 
 				{
 					var select = document.getElementById("range");
 					for(i=0;i < responseText.length ;i++)
 						{
 					     var opt=document.createElement("option");
 					     opt.value=responseText[i].rangeCode;
 					     opt.innerHTML=responseText[i].rangeDesc;
 					     select.appendChild(opt);
 						}
				}
				});
			
			$.ajax({

                url:"getAllUOM.action",
    			dataType : "json",
 				success: function(responseText) 
 				{
 					var select = document.getElementById("baseUOM");
 					for(i=0;i < responseText.length ;i++)
 						{
 					     var opt=document.createElement("option");
 					     opt.value=responseText[i].id;
 					     opt.innerHTML=responseText[i].uomName;
 					     select.appendChild(opt);
 						}
 						
				}
				});
				
							jQuery( "#dialog-modal" ).dialog({
		height: 'auto',
		width: 'auto',
		minwidth:'500px',
		show: 'slide',
		modal: true
	});
	 
			 jQuery('#dialog-modal').dialog( "close" );
				
				jQuery('#lblSearch').click(function()
				{
					alert("ddddd");
					jQuery('#dialog-modal').dialog( "open");
					displayIngredientSearchPopup(ingSearch);
				});
				
						});
				
				function displayIngredientSearchPopup(selectHandler)
				{
					alert("ssss");
					var columnHeader = ["Ind Code", 
					                 "Ind Desc", 
					                 "Range","Base UOM","Purchase Price","Warning Quantity" ];
					var columns =  ["ingCode","ingDesc","range","baseUOM","purPrice","warQty"];
					jQuery("#grid").popupgrid({
						colNames : columnHeader,
						colModel : [ {
							name : columns[0],
							index : columns[0],
							width : 35
						}, {
							name : columns[1],
							index : columns[1],
							width : 35
						}, {
							name : columns[2],
							index : columns[2],
							width : 30
						}, {
							name : columns[3],
							index : columns[3],
							width : 30
						}, {
							name : columns[4],
							index : columns[4],
							width : 30
						}, {
							name : columns[5],
							index : columns[5],
							width : 30
						}],
						url : 'ingGridDataAction.action',
						caption : "Select Ingredient",
						selectHandler:selectHandler,
						gridDiv:"#grid"
					});
				}
				
				function ingSearch(ingCode)
				{
					jQuery('#dialog-modal').dialog( "close" );
					jQuery('#loadingMsg').show();
					
					$.ajax({
	  url: 'ingredientGetByCode.action?ingCode='+ingCode,
	  success:function(responseText)
		 {
			jQuery('#ingCode').val(responseText.ingCode);
			jQuery('#ingDesc').val(responseText.ingDesc);
			jQuery('#baseUOM').val(responseText.uomMasterDTO.id);
			jQuery('#purPrice').val(responseText.purPrice);
			jQuery('#warQty').val(responseText.warQry);
			
			var select = document.getElementById("range");
 					
			var range = responseText.ingRange;
			alert(range);
			var splitRange=range.split(",");
			alert(splitRange);	
			alert(splitRange.length);		
					for(j=0;j < splitRange.length ;j++)
 					{
 					for(i=0;i < select.options.length ;i++)
 					{
 					alert(select.options[i].value);
 					alert(splitRange[j]);
 					if(select.options[i].value==splitRange[j])
 					select.options[i].selected=true;
 					}
 					}
	     }
		});				
					jQuery('#loadingMsg').hide();
				 }
				
				 $("#delete").click(function()
						{
			 	  var ingCode=jQuery('#ingCode').val();
				  var res=confirm("Are you sure you want to delete?");
				 if(res==true)
				 {
				 alert("rrr");
					$.ajax({
	  url: 'ingDataDeleteAction.action?id='+ingCode,
	  success:function(responseText)
		 {
		if (responseText.status == "success") {
													jQuery("#errMsg").text();
													alert("Ingredient Details Saved Successfully!");
													resetForm();
												} else {
												
												 jQuery("#errMsg").text(responseText.errorMessage);
													//alert(responseText.errorMessage);
												}
		}
		});
		}
		});
		
		$("#submit").click(function()
						{
										jQuery('#ingredientForm').ajaxSubmit(
										{
											dataType : "json",
											url : "ingredientDataModifyAction.action",
											success : function(responseText) {
												
												if (responseText.status == "success") {
													jQuery("#errMsg").text();
													alert("Ingredient Details Deleted Successfully!");
													resetForm();
												} else {
												
												 jQuery("#errMsg").text(responseText.errorMessage);
													//alert(responseText.errorMessage);
												}
											}
										});
								
						}); 
		
	 
	 function resetForm()
	 {
	 	jQuery('#ingCode').val("");
			jQuery('#ingDesc').val("");
			jQuery('#baseUOM').val("");
			jQuery('#purPrice').val("");
			jQuery('#warQty').val("");
			
					var select = document.getElementById("range");
 					for(i=0;i < select.options.length ;i++)
 					{
 					select.options[i].selected=false;
 					}
	    
	 }
	 