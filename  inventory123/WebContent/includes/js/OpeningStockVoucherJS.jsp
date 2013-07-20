<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<% response.setContentType("text/javascript");%>
<jsp:include page="../../js/datepicker.js"></jsp:include>

	jQuery(document).ready(function() 
				{	
			
				var d = new Date();
	
	var curr_year = d.getFullYear();
	var month = d.getMonth();
	var day = d.getDate();
	var current_date = month+"/"+day+"/"+curr_year;
	
	$( "#openingDate").datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange: '1900:curr_year'
	});
			
			
			$.ajax({

                url:"getAllUOM.action",
    			dataType : "json",
 				success: function(responseText) 
 				{
 					var select = document.getElementById("baseUOM");
 					var damagedQtyUOM = document.getElementById("damagedQtyUOM");
 					for(i=0;i < responseText.length ;i++)
 						{
 					     var opt=document.createElement("option");
 					     opt.value=responseText[i].id;
 					     opt.innerHTML=responseText[i].uomName;
 					     select.appendChild(opt);
 					     var opt1=document.createElement("option");
 					     opt1.value=responseText[i].id;
 					     opt1.innerHTML=responseText[i].uomName;
 					     damagedQtyUOM.appendChild(opt1);
 						}
 						
				}
				});
				
							$.ajax({

                url:"getAllUnit.action",
    			dataType : "json",
 				success: function(responseText) 
 				{
 					var select = document.getElementById("unit");
 					for(i=0;i < responseText.length ;i++)
 						{
 					     var opt=document.createElement("option");
 					     opt.value=responseText[i].unitCode;
 					     opt.innerHTML=responseText[i].unitName;
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
					displayItemSearchPopup(itemSearch);
				});
				
						});
				
				function displayItemSearchPopup(selectHandler)
				{
					alert("ssss");
					var columnHeader = ["Item Code", 
					                 "Item Name"];
					var columns =  ["itemCode","itemDesc"];
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
						}],
						url : 'itemGridDataAction.action',
						caption : "Select Ingredient",
						selectHandler:selectHandler,
						gridDiv:"#grid"
					});
				}
				
				function itemSearch(id)
				{
				alert("fff");
					jQuery('#dialog-modal').dialog( "close" );
					jQuery('#loadingMsg').show();
					
					$.ajax({
	  url: 'getItemByCode.action?itemCode='+id,
	  success:function(responseText)
		 {
		 	alert(responseText.id);
		 	alert(responseText.itemDesc);
			jQuery('#itemCode').val(responseText.id);
			jQuery('#itemDesc').val(responseText.itemDesc);
	     }
		});				
					jQuery('#loadingMsg').hide();
				 }
				
				 $("#delete").click(function()
						{
		
		});
		
		$("#submit").click(function()
						{
		
						}); 
		
	 
	 function resetForm()
	 {
	 	   
	 }
	 