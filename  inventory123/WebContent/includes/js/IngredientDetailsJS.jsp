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
 					     select.options[select.options.length] = new Option(responseText[i].rangeCode,responseText[i].rangeDesc);
 						}
 						
				}
				});
			
			$.ajax({

                url:"getAllUOM.action",
    			dataType : "json",
 				success: function(responseText) 
 				{
 					var select = document.getElementById("baseUOM");
 					for(var j=0; j< responseText.length;j++)
 						{
 						select.options[select.options.length] = new Option(responseText[j].id,responseText[j].uomName);
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
		
			 $("#submit").click(function()
						{
										jQuery('#ingredientForm').ajaxSubmit(
										{
											dataType : "json",
											url : "ingredientDataModifyAction.action",
											success : function(responseText) {
												
												if (responseText.status == "success") {
													jQuery("#errMsg").text();
													alert("Ingredient Details Saved Successfully!");
													//displayAndReloadGrid();
												} else {
												
												 jQuery("#errMsg").text(responseText.errorMessage);
													//alert(responseText.errorMessage);
												}
											}
										});
								
						}); 
				
				function displayIngredientSearchPopup(selectHandler)
				{
					alert("ssss");
					var columnHeader = ["Ind Code", 
					                 "Ind Desc", 
					                 "range","base uom","purchase price","wiarning quantity" ];
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
				
				function ingSearch(ingCode,ingDesc)
				{
					jQuery('#dialog-modal').dialog( "close" );
					jQuery('#loadingMsg').show();
					alert(ingCode);
					alert(ingDesc);
					jQuery('#loadingMsg').hide();
				 }
		
	 