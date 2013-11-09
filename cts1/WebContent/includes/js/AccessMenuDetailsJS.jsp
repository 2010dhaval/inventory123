<%@page import="com.untitle.inventory.dto.MenuMasterDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% response.setContentType("text/javascript");%>
<jsp:include page="../../js/jquery.checkboxtree.js"></jsp:include>
	jQuery(document).ready(function() {
	
		var hashtable = new Array();
		 function getMenuDetails(menuList)
		{
				var i = 0;
			var menuDetails="";
			for (i = 0; i < menuList.length; i++) {
				menuDetails+= "<li id='"+menuList[i].id+"'> <input type='checkbox' id='"+menuList[i].id+"' name='menuIds' value='"+menuList[i].id+"'">;
				if(hashtable[menuList[i].id])
				{
					menuDetails+= " checked='checked' ";
				} 
				menuDetails+=" />"+"<label>" + menuList[i].description + "</label>";
				if(menuList[i].childMenu.length != 0)
				{
					menuDetails+= "<ul>";
					menuDetails+= getMenuDetails(menuList[i].childMenu);
					menuDetails+= "</ul>";
				}
			}
			return menuDetails;
		}
		
		function convertListToMap(accessList)
		{
		
			hashtable = new Array();
			for (i = 0; i < accessList.length; i++)
			{
				hashtable[accessList[i].menuId] = accessList[i];
			}
			return hashtable;
		}	

	function changeUserType()
	{
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: ""
		});
			jQuery("#save").val("false");
			jQuery('#accessMenu')[0].reset();
			jQuery('#menuAccessTree').empty();
			jQuery('#menuAccessTabs').hide();
			jQuery('#getData').show();
	}
	$("#getData").click(function() {
	
		jQuery("#save").val("false");
        var data = $("form").serialize();
		jQuery('#userType').attr('readonly', true);
		jQuery.ajax({
				dataType: 'json',
		  		type: 'POST',
		  		url: 'accessMenuModifyAction.action',
		  		data: data,
		  		success: function(responseText){
		  		if (responseText.success != null)
		  		{
		  			jQuery("#errMsg").text("");
		  			alert(responseText.success);
		  		}
		  		if (responseText.errorMsg != null)
		  		{
		  			alert(responseText.errorMsg);
		  		}
		  		$("#menuAccessTree").empty();
		  			convertListToMap(responseText.accessList)
			  		var menuDetails = getMenuDetails(responseText.menuList);
			  		$("#menuAccessTree").append(menuDetails);
			  		jQuery('#menuAccessTree').checkboxTree({
			  			initializeChecked: 'expanded',
			  			initializeUnchecked: 'collapsed',
						 onCheck: {
			                node: 'expand',
			                descendants:'' 
			            },
			            onUncheck: {
			                node: 'collapse',
			                ancestors:'uncheckIfAll'
			            }
		   			});
		  		jQuery('#getData').hide();
	  			jQuery('#menuAccessTabs').show();
  			}
		});
		});
		
		jQuery("#bttnCancel").click(function() {
			jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: ""
		});
			jQuery("#save").val("false");
			jQuery('#accessMenu')[0].reset();
			jQuery('#menuAccessTree').empty();
			jQuery('#menuAccessTabs').hide();
			jQuery('#getData').show();
		});
		
		
		$("#submit").click(function(event) {
			event.preventDefault();
			jQuery("#save").val("true");
			
			var data = $("form").serialize();
		jQuery('#userType').attr('readonly', true);
		jQuery.ajax({
				dataType: 'json',
		  		type: 'POST',
		  		url: 'accessMenuModifyAction.action',
		  		data: data,
		  		success: function(responseText){
		  		if (responseText.success != null)
		  		{
		  			jQuery("#errMsg").text("");
		  			alert(responseText.success);
		  		}
		  		if (responseText.errorMsg != null)
		  		{
		  			alert(responseText.errorMsg);
		  		}
		  		$("#menuAccessTree").empty();
		  			convertListToMap(responseText.accessList)
			  		var menuDetails = getMenuDetails(responseText.menuList);
			  		$("#menuAccessTree").append(menuDetails);
			  		jQuery('#menuAccessTree').checkboxTree({
			  			initializeChecked: 'expanded',
			  			initializeUnchecked: 'collapsed',
						 onCheck: {
			                node: 'expand',
			                descendants:'' 
			            },
			            onUncheck: {
			                node: 'collapse',
			                ancestors:'uncheckIfAll'
			            }
		   			});
		  		jQuery('#getData').hide();
	  			jQuery('#menuAccessTabs').show();
  			}
		});
		
			//$("#getData").click();
		});
		
});