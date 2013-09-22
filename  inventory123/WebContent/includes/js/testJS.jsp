<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% response.setContentType("text/javascript");%>
	var ids=new Array();
  jQuery(function() {
		var flag = 1;
		
				jQuery("#navgrid").jqGrid({
					colNames : [ 'select','PREQ No', 'PREQ Item','Purchase Grp', 'Material','Plant','Material Grp' ],
					colModel : [             { name: 'select', index: 'select', formatter: 'checkbox',width:30,
		                editable: true, edittype: 'checkbox', editoptions: { value: 'true:false' },
					},
		              {
						name : 'preqNo',
						index : 'preqNo',
						width : 55,
						search : true,
						editable :false,
					}, {
						name : 'preqItem',
						index : 'preqItem',
						width : 150,
						editable : false
					},{
						name : 'purchaseGrp',
						index : 'purchaseGrp',
						width : 150,
						editable : false
					}, {
						name : 'Material',
						index : 'Material',
						width : 150,
						editable : false
					}, {
						name : 'Plant',
						index : 'Plant',
						width : 150,
						editable : false
					}, {
						name : 'materialGrp',
						index : 'materialGrp',
						width : 150,
						editable : false
					} ],
					url : 'testGridDataAction.action',
					datatype : "json",
					sortname : 'Id',
					ignoreCase : true,
					viewrecords : true,
					rownumbers : true,
					sortorder : "desc",
					caption : "REQ Details",
					height : 200,
					width : 900,
					autoWidth : false,
					shrinkToFit : false,
					hidegrid : false,
					 onCellSelect
					    : function(select){
					    //  if(select && select!==lastsel2){
					       // jQuery('#rowed5').restoreRow(lastsel2);
					      jQuery('#navgrid').editRow(select,true); 					          
					    //  } 
					    }					
				});
				
							$.ajax({

                url:"getAllMaterialGroup.action",
    			dataType : "json",
 				success: function(responseText) 
 				{
 					var select = document.getElementById("materialGrp");
 					for(i=0;i < responseText.length ;i++)
 						{
 					     var opt=document.createElement("option");
 					     opt.value=responseText[i].materialGroupCode;
 					     opt.innerHTML=responseText[i].materialGroupDesc;
 					     select.appendChild(opt);
 						}
 						
				}
				});
				
											$.ajax({

                url:"getAllPurchaseGroup.action",
    			dataType : "json",
 				success: function(responseText) 
 				{
 					var select = document.getElementById("purchaseGrp");
 					for(i=0;i < responseText.length ;i++)
 						{
 					     var opt=document.createElement("option");
 					     opt.value=responseText[i].purchaseGroupCode;
 					     opt.innerHTML=responseText[i].purchaseGroupDesc;
 					     select.appendChild(opt);
 						}
 						
				}
				});
				
	});
	$(document).ready(function() {
		//jQuery("#navgrid").hideCol('select');
		
		$("#submit").click(function() { 
			var unselectedIds = new Array();
			var j=0;
		    for (var i = 1; i <= $("#navgrid").getGridParam("reccount"); i++) {
		    	var aa = $('#navgrid').jqGrid('getDataIDs');
		        var ret = $("#navgrid").getRowData(aa[i-1]);
		        alert(aa);
		       alert(ret.select);
		        if(ret.select=="false")
			        {
			        unselectedIds[j++]=i;
			        } 
			          
		    }
		    alert(unselectedIds.length);
		    for(var k=0;k< unselectedIds.length;k++)
		   {
		   alert(k);
		    $('#navgrid').jqGrid('delRowData',unselectedIds[k], {reloadAfterSubmit: true});
		    }
		    jQuery("#navgrid").hideCol('select');
		    jQuery("#tesDiv").show();
		      	
		   });
		$("#cancel").click(function() { 
			jQuery('#testForm')[0].reset();
			  jQuery("#navgrid").setGridParam({url:'testGridDataAction.action',page:1}).trigger('reloadGrid'); 
			  jQuery("#navgrid").hideCol('select');
  		     jQuery("#grid").show();
            });
            
		                   
	  	});