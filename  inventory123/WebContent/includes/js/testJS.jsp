<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setContentType("text/javascript");
%>



	var refNos=new Array();
	
	//--for start validity date picker--
	    				  $( "#startPeriod" ).datepicker({
	    				// minDate: new Date(currentYear, currentMonth, currentDate)
	    				changeMonth: true,
						changeYear: true,
	    				 });
	    				 
	    				 //--for end validity date picker--
	    				  $( "#endPeriod" ).datepicker({
	    				// minDate: new Date(currentYear, currentMonth, currentDate)
	    				changeMonth: true,
						changeYear: true,
	    				 });
	
	jQuery(function() {
		var flag = 1;

		jQuery("#navgrid").jqGrid(
				{
					colNames : [ 'select', 'PREQ No', 'PREQ Item',
							'Purchase Grp', 'Material', 'Plant',
							'Material Grp', 'Quantity', 'Date','id' ],
					colModel : [ {
						name : 'select',
						index : 'select',
						formatter : 'checkbox',
						width : 30,
						editable : true,
						edittype : 'checkbox',
						editoptions : {
							value : 'true:false'
						},
						formatoptions: {disabled : false}
					}, {
						name : 'preqNo',
						index : 'preqNo',
						//width : 70,
						search : true,
						editable : false,
					}, {
						name : 'preqItem',
						index : 'preqItem',
						//width : 50,
						editable : false
					}, {
						name : 'purchaseGrp',
						index : 'purchaseGrp',
						//width : 100,
						editable : false
					}, {
						name : 'Material',
						index : 'Material',
						//width : 50,
						editable : false
					}, {
						name : 'Plant',
						index : 'Plant',
						//width : 50,
						editable : false
					}, {
						name : 'materialGrp',
						index : 'materialGrp',
						width : 90,
						editable : false
					}, {
						name : 'quantity',
						index : 'quantity',
						width : 50,
						editable : false
					}, {
						name : 'delivDate',
						index : 'delivDate',
						width : 150,
						editable : false
					},{
						name : 'id',
						index : 'id',
						width : 0,
						editable : false
					}],
					
					//url : 'testGridDataAction.action?materialId='+'%%'+'&purchaseId='+'%%',
					pager : '#pagernav',
					datatype : "json",
					sortname : 'Id',
					ignoreCase : true,
					viewrecords : true,
					rownumbers : true,
					sortorder : "desc",
					caption : "REQ Details",
					//height : 400,
					//width : 900,
					autoWidth : true,

					shrinkToFit : true,
					//hidegrid : false,
					onCellSelect : function(select) {
						//  if(select && select!==lastsel2){
						// jQuery('#rowed5').restoreRow(lastsel2);
						//jQuery('#navgrid').editRow(select, true);
						//  } 
					}
				});
				
				//For second Grid...----------------
				
				jQuery("#navgrid2").jqGrid(
				{
					colNames : [ 'select','PREQ No', 'PREQ Item',
							'Purchase Grp', 'Material', 'Plant',
							'Material Grp', 'Quantity', 'Date','id' ],
					colModel : [{
						name : 'select',
						index : 'select',
						formatter : 'checkbox',
						width : 30,
						editable : true,
						edittype : 'checkbox',
						editoptions : {
							value : 'true:false'
						},
						formatoptions: {disabled : false}
					},  {
						name : 'preqNo',
						index : 'preqNo',
						//width : 70,
						search : true,
						editable : false,
					}, {
						name : 'preqItem',
						index : 'preqItem',
						//width : 50,
						editable : false
					}, {
						name : 'purchaseGrp',
						index : 'purchaseGrp',
						//width : 100,
						editable : false
					}, {
						name : 'Material',
						index : 'Material',
						//width : 50,
						editable : false
					}, {
						name : 'Plant',
						index : 'Plant',
						//width : 50,
						editable : false
					}, {
						name : 'materialGrp',
						index : 'materialGrp',
						//width : 90,
						editable : false
					}, {
						name : 'quantity',
						index : 'quantity',
						//width : 50,
						editable : true,
						
					}, {
						name : 'delivDate',
						index : 'delivDate',
						//width : 150,
						editable : false
					},{
						name : 'id',
						index : 'id',
						width : 0,
						editable : false
					}
					],
					
					//url : 'testGridDataAction.action?materialId='+'%%'+'&purchaseId='+'%%',
					pager : '#pagernav2',
					datatype : "json",
					sortname : 'Id',
					ignoreCase : true,
					viewrecords : true,
					rownumbers : true,
					sortorder : "desc",
					caption : "REQ Group",
					//height : 400,
					//width : 900,
					autoWidth : true,
					cellEdit: true,
					shrinkToFit : true,
					//hidegrid : false,
					onCellSelect : function(select) {
						//  if(select && select!==lastsel2){
						// jQuery('#rowed5').restoreRow(lastsel2);
						jQuery('#navgrid').editRow(select, true);
						//  } 
					}
				});
				//-------second grid over -------

		$.ajax({

			url : "getAllMaterialGroup.action",
			dataType : "json",
			success : function(responseText) {
				var select = document.getElementById("materialGrp");
				for (i = 0; i < responseText.length; i++) {
					var opt = document.createElement("option");
					opt.value = responseText[i].materialGroupCode;
					opt.innerHTML = responseText[i].materialGroupDesc;
					select.appendChild(opt);
				}

			}
		});

		$.ajax({

			url : "getAllPurchaseGroup.action",
			dataType : "json",
			success : function(responseText) {
				var select = document.getElementById("purchaseGrp");
				for (i = 0; i < responseText.length; i++) {
					var opt = document.createElement("option");
					opt.value = responseText[i].purchaseGroupCode;
					opt.innerHTML = responseText[i].purchaseGroupDesc;
					select.appendChild(opt);
				}

			}
		});

	});

	$(document).ready(function() {
		jQuery("#navgrid2").hideCol('select');

		$("#create").click(function() {
		/*  old code----
			var unselectedIds = new Array();
			var j=0;
		    for (var i = 1; i <= $("#navgrid").getGridParam("reccount"); i++) {
		    	var aa = $('#navgrid').jqGrid('getDataIDs');
		        var ret = $("#navgrid").getRowData(aa[i-1]);
		        //alert(aa);
		       //alert(ret.select);
		        if(ret.select=="false")
			        {
			        unselectedIds[j++]=i;
			        } 
			          
		    }
		    //alert(unselectedIds.length);
		    for(var k=0;k< unselectedIds.length;k++)
		   {
		    //alert(k);
		    $('#navgrid').jqGrid('delRowData',unselectedIds[k], {reloadAfterSubmit: false});
		   //$('#navgrid').delRowData(unselectedIds[i]);
		    }
		   
		    
		    //jQuery("#navgrid").showCol('input');
		    jQuery("#tesDiv").hide();
		    jQuery("#headerInput").show();
		     --------------------- 	*/
		     var j=0;
			//alert($("#navgrid").getGridParam("reccount"));
		    for (var i = 1; i <= $("#navgrid").getGridParam("reccount"); i++) {
		    	var aa = $('#navgrid').jqGrid('getDataIDs');
		        var ret = $("#navgrid").getRowData(aa[i-1]);
		        
		        //alert("Select" + ret.select);
		        if(ret.select == "true")
			        {
			        refNos[j] = aa[i-1];
			        //alert(refNos[j]);
			        $('#navgrid2').jqGrid('addRowData',j,ret);
			        j++;
			        }   
		 	
		}
		      	
		      	
		   });

		$("#cancel").click(function() {
			/* jQuery('#testForm')[0].reset();
			  jQuery("#navgrid").setGridParam({url:'testGridDataAction.action',page:1}).trigger('reloadGrid'); 
			  jQuery("#navgrid").hideCol('select');
			   jQuery("#grid").show();*/
		});
		
		//jQuery("#grid").hide();

	});

	//-- for getting data of that material and purchase group--

	$("#submit").click(
			function() {

				var materialId = document.getElementById("materialGrp").value;
				var purchaseId = document.getElementById("purchaseGrp").value;
				//var toDate = document.getElementById("toDate").value;

				//alert(materialId);
				//alert(purchaseId);
				//alert(toDate);

				// alert("else called");
				jQuery("#navgrid").setGridParam(
						{
							url : 'testGridDataAction.action?materialId='
									+ materialId + '&purchaseId=' + purchaseId,
							page : 1
						}).trigger('reloadGrid');
				//jQuery("#grid").jqGrid.trigger('reloadGrid');
				//jQuery("#navgrid").showCol('select');
				//jQuery("#grid").show();
				//jQuery("#divStartJoiningProcess").show();
				//jQuery("#grid").show();
				
				jQuery("#grid").show();

			});
			
			
			$("#btnSave").click(function() {
			var ids = new Array();
			var quant = new Array();
			var j=0;
			//alert($("#navgrid2").getGridParam("reccount"));
		    for (var i = 1; i <= $("#navgrid2").getGridParam("reccount"); i++) {		    
		    	var aa = $('#navgrid2').jqGrid('getDataIDs');
		        var ret = $("#navgrid2").getRowData(aa[i-1]);
		        //alert(ret.id);
		        //alert(ret.preqItem);
			        ids[j] = ret.id;
			        quant[j]=ret.quantity;
			        j++;
			}
			$("#ids").val(ids);	
			$("#quan").val(quant);	
			
			jQuery('#testForm').ajaxSubmit(
						{
							dataType : "json",
							url : "testDataModifyAction.action"
							
						});	
			alert('Data saved successfully..!!');
							location.reload();
				
		});
