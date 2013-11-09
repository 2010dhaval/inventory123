/**
 * Document   : jquery.nifsysautocomplete.js
 * Created on : 9-sep-2011
 * Created By : Rupangi Dave
 * Purpose	  : This is custom plugin developed for eHRMS application. This plugin is internally dependent on Autocomplete.
 */
(function($)
		{
	$.fn.nifsysautocomplete = function (settings){
		var autoComplete = this;
		var config = {
				source: "dummyUrl",
				minLength: 1,
				hiddenFieldId: "hiddenFieldId",
				displayMessage: "displayMessage",
				messageDiv: "messageDiv",
				select: function(event, ui){
					jQuery(config.hiddenFieldId).val(ui.item.id);
				},
				change: function(event, ui) {
					if (!ui.item ){
						jQuery(autoComplete).val("");
						jQuery(config.hiddenFieldId).val("");
						jQuery(config.messageDiv).nifsysDisplayErrMsg({
							msg: config.displayMessage
						});
					}
				}
		};
		if (settings) $.extend(config, settings);
		jQuery(this).autocomplete(config); 
	};
		})(jQuery);