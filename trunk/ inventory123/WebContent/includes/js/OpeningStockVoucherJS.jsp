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
					jQuery('#dialog-modal').dialog( "open");
					
					var type=jQuery('#type').val();
					
					if(type==1)
					displayIngredientSearchPopup(ingSearch);
					else
					displayItemSearchPopup(itemSearch);
				});
			
				jQuery('#lblSearchVoucher').click(function()
				{
				alert("iiiiii");
					jQuery('#dialog-modal').dialog( "open");
					
					displayVoucherSearchPopup(voucherSearch);
					
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
				
				function displayVoucherSearchPopup(selectHandler)
				{
					var columnHeader = ["Voucher Code", 
					                 "Type","Name"];
					var columns =  ["voucheCode","type","name"];
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
							width : 35
						}],
						url : 'voucherGridDataAction.action',
						caption : "Select Voucher",
						selectHandler:selectHandler,
						gridDiv:"#grid"
					});
				}
		
				function voucherSearch(id)
				{
					jQuery('#dialog-modal').dialog( "close" );
					jQuery('#loadingMsg').show();
					
					$.ajax({
	  url: 'getVoucherByCode.action?voucherCode='+id,
	  success:function(responseText)
		 {
		 	alert(responseText.id);
		 	alert(responseText.itemDesc);
			jQuery('#itemCode').val(responseText.id);
			jQuery('#itemDesc').val(responseText.itemDesc);
	     }
		});				
		
				
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
			function typeChange(value)
			{
			if(value==2)
			{
			jQuery('#buyingPriceTD').html("Selling price");
			}
			else
			{
			jQuery('#buyingPriceTD').html("Buying price");
			}
			}