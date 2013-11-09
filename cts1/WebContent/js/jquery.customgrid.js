(function($)
{
		
	$.fn.customgrid = function(settings)
	{
		var config = jQuery(this).getCommonConfig();
		var grid = this;
		
		/* Setting default configurations and handlers */
		config.editHandler=function(gsr) {
			jQuery(grid).jqGrid('GridToForm', gsr,
					config.formId);
			jQuery(config.gridDiv).hide();
			jQuery(config.formDiv).show();
		};
		
		config.addHandler=function()
		{
			jQuery(config.formId)[0].reset();
			jQuery(config.gridDiv).hide();
			jQuery(config.formDiv).show();
		};
		config.width = jQuery(this).parent().innerWidth();
		
		
		if (settings) $.extend(config, settings);
		
		$(this).jqGrid(config);
		var del = !config.selgrid;
		jQuery(this).jqGrid('navGrid', config.pager, {
			deltext : "Delete",
			refreshtext : "Refresh",
			add : false,
			view : false,
			del : del,
			edit : false,
			search : false
		},//options
		{/*EDIT OPTION*/}, {/*ADD OPTION*/}, {
			
		},// Delete Options
		{/*SEARCH OPTION*/}, {/*VIEW OPTION*/});
		if(config.selgrid)
		{
			jQuery(this).jqGrid('navButtonAdd', config.pager, {
				caption : "Select",
				title : "Select",
				buttonicon : 'ui-icon-check',
				position : "last",
				onClickButton : function()
				{
					var selectedRowId = jQuery(grid).jqGrid('getGridParam','selrow');
					if (selectedRowId) {
						config.selectHandler(selectedRowId);
					}
					else {
						alert("Please select record");
					}
				}
			});
		}
		else
		{
			jQuery(this).jqGrid(
					'navButtonAdd',
					config.pager,
					{
						caption : "Edit",
						buttonicon : "ui-icon-pencil",
						position : "first",
						onClickButton : function() {
							var gsr = jQuery(grid).jqGrid('getGridParam',
									'selrow');
							if (gsr) {
								config.editHandler(gsr);
							} else {
								alert("Please select record");
							}
						}
					}); // Edit Options

			jQuery(this).jqGrid('navButtonAdd', config.pager, {
				caption : "Add",
				buttonicon : "ui-icon-plus",
				position : "first",
				onClickButton : function() {
					config.addHandler();
				}
			}); // Add Options
			
		}
		jQuery(this).jqGrid('navButtonAdd', config.pager, {
			caption : "Search",
			title : "Toggle Search Toolbar",
			buttonicon : 'ui-icon-search',
			position : "last",
			onClickButton : function() {
				if (flag != 1) {
					jQuery(grid)[0].toggleToolbar();
				} else {
					jQuery(grid).jqGrid('filterToolbar');
					flag = 0;
				}
			}
		} );
		var flag = 1;
		function hideToolbar() {
			jQuery(this)[0].toggleToolbar();
		}
		return this;
	};
	
	$.fn.popupgrid = function(settings)
	{
		var popupgridConfig = jQuery(this).getCommonConfig();
		var appendStr = (new Date()).getTime();
		var gridId = "popupgrid"+appendStr;
		var pagerId = "pagerpopup"+appendStr;
		popupgridConfig.width = jQuery(this).parent().innerWidth();
		
		if (settings) $.extend(popupgridConfig, settings);
		popupgridConfig.selgrid = true;
		popupgridConfig.pager="#"+pagerId;
		jQuery(popupgridConfig.gridDiv).empty();
		jQuery(popupgridConfig.gridDiv).append("<table id=\""+gridId+"\"></table><div id=\""+pagerId+"\"></div>");
		$("#"+gridId).customgrid(popupgridConfig);
		return this;
	};
	
	
	$.fn.getCommonConfig = function()
	{
		return commonConfig = {
				url:"dummyUrl",
				datatype: "json",
				colNames:[],
			   	colModel:[],
		   		rowNum:10,
		   		rowList:[10,20,30],
		   		pager: '#pagernav',
		   		viewrecords: true,
		    	autoWidth:false,
				shrinkToFit:true,
				hidegrid:false,
		   		caption:"Custome Grid",
		    	editurl:"editUrl",
				height:"auto",
				mtype:"POST",
				width:"auto",
				sortname : 'id',
				sortorder : "asc",
				cmTemplate: {classes : 'ui-ellipsis'},
				selgrid:false,
				selectHandler:function(){alert("function not implemented");},
				editHandler:function(gsr) {
					alert("function not implemented");
				},
				addHandler:function() {
					alert("function not implemented");
				},
				formDiv:"#formDiv",
				formId:"#formId",
				gridDiv:"#gridDiv"
		};
		
	};

})(jQuery);