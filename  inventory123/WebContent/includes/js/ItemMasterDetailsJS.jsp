<!-- 
Author : Dhaval Mehta
Date : 20/07/2013
Purpose : For java script file of Item master..

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setContentType("text/javascript");
%>
<SCRIPT>
	jQuery(document).ready(function() {

		$.ajax({

			url : "getAllRange.action",
			dataType : "json",
			success : function(responseText) {
				var select = document.getElementById("range");
				for (i = 0; i < responseText.length; i++) {
					var opt = document.createElement("option");
					opt.value = responseText[i].rangeCode;
					opt.innerHTML = responseText[i].rangeDesc;
					select.appendChild(opt);
				}
			}
		});

		$.ajax({

			url : "getAllUOM.action",
			dataType : "json",
			success : function(responseText) {
				var select = document.getElementById("baseUOM");
				for (i = 0; i < responseText.length; i++) {
					var opt = document.createElement("option");
					opt.value = responseText[i].id;
					opt.innerHTML = responseText[i].uomName;
					select.appendChild(opt);
				}

			}
		});

		jQuery("#dialog-modal").dialog({
			height : 'auto',
			width : 'auto',
			minwidth : '500px',
			show : 'slide',
			modal : true
		});

		jQuery('#dialog-modal').dialog("close");

		jQuery('#lblSearch').click(function() {
			//alert("ddddd");
			jQuery('#dialog-modal').dialog("open");
			displayItemSearchPopup(itemSearch);
		});

	});

	/*  */
	
	function displayItemSearchPopup(selectHandler) {
		//alert("ssss");
		var columnHeader = [ "Item Code", "Item Desc", "Range", "Base UOM",	"Selling Price", "Warning Quantity" ];
		var columns = [ "itemCode", "itemDesc", "range", "baseUOM", "sellingPrice","warQty" ];
		
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
			} ],
			url : 'itemGridDataAction.action',
			caption : "Select Item",
			selectHandler : selectHandler,
			gridDiv : "#grid"
		});
	}

	/*  */
	
	function itemSearch(itemCode) {
		jQuery('#dialog-modal').dialog("close");
		jQuery('#loadingMsg').show();

		$.ajax({
			url : 'getItemByCode.action?itemCode=' + itemCode,
			success : function(responseText) {
				jQuery('#itemCode').val(responseText.itemCode);
				jQuery('#itemDesc').val(responseText.itemDesc);
				jQuery('#baseUOM').val(responseText.uomMasterDTO.id);
				jQuery('#sellingPrice').val(responseText.sellingPrice);
				jQuery('#warQty').val(responseText.warQry);

				var select = document.getElementById("range");

				var range = responseText.itemRange;
				alert(range);
				var splitRange = range.split(",");
				alert(splitRange);
				alert(splitRange.length);
				for (j = 0; j < splitRange.length; j++) {
					for (i = 0; i < select.options.length; i++) {
						alert(select.options[i].value);
						alert(splitRange[j]);
						if (select.options[i].value == splitRange[j])
							select.options[i].selected = true;
					}
				}
			}
		});
		jQuery('#loadingMsg').hide();
	}
	
	/*  */

	$("#delete").click(function() {
		var itemCode = jQuery('#itemCode').val();
		var res = confirm("Are you sure you want to delete?");
		if (res == true) {
			alert("rrr");
			$.ajax({
				url : 'itemDataDeleteAction.action?id=' + itemCode,
				success : function(responseText) {
					if (responseText.status == "success") {
						jQuery("#errMsg").text();
						alert("Item Details Saved Successfully!");
						resetForm();
					} else {

						jQuery("#errMsg").text(responseText.errorMessage);
						//alert(responseText.errorMessage);
					}
				}
			});
		}
	});
	
	/*  */

	$("#submit").click(function() {
		jQuery('#itemForm').ajaxSubmit({
			dataType : "json",
			url : "itemDataModifyAction.action",
			success : function(responseText) {

				if (responseText.status == "success") {
					jQuery("#errMsg").text();
					alert("Item Details Deleted Successfully!");
					resetForm();
				} else {

					jQuery("#errMsg").text(responseText.errorMessage);
					//alert(responseText.errorMessage);
				}
			}
		});

	});
	
	/*  */

	function resetForm() {
		jQuery('#itemCode').val("");
		jQuery('#itemDesc').val("");
		jQuery('#baseUOM').val("");
		jQuery('#sellingPrice').val("");
		jQuery('#warQty').val("");

		var select = document.getElementById("range");
		for (i = 0; i < select.options.length; i++) {
			select.options[i].selected = false;
		}

	}
</SCRIPT>
