/**
 * Document   : jquery.nifsysdisplaymessage.js
 * Created on : 9-sep-2011
 * Created By : Rupangi Dave
 * Purpose	  : This is custom plugin developed for eHRMS application. This plugin is used to display Message
 */
(function($)
		{
	$.fn.nifsysDisplayErrMsg = function(settings)
	{
		var config = {
				msg: "displayMessage"
		};
		if(settings) $.extend(config, settings);
		var errMsg = this;
		jQuery(errMsg).html(config.msg);
	};
		})(jQuery);