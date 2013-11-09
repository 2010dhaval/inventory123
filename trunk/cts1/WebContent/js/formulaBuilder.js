/*
 * jQuery plugin: fieldSelection - v0.1.0 - last change: 2006-12-16
 * (c) 2006 Alex Brem <alex@0xab.cd> - http://blog.0xab.cd
 */

(function() {

	var fieldSelection = {

		getSelection: function() {

			var e = this.jquery ? this[0] : this;

			return (

				/* mozilla / dom 3.0 */
				('selectionStart' in e && function() {
					var l = e.selectionEnd - e.selectionStart;
					return { start: e.selectionStart, end: e.selectionEnd, length: l, text: e.value.substr(e.selectionStart, l) };
				}) ||

				/* exploder */
				(document.selection && function() {

					e.focus();

					var r = document.selection.createRange();
					if (r == null) {
						return { start: 0, end: e.value.length, length: 0 }
					}

					var re = e.createTextRange();
					var rc = re.duplicate();
					re.moveToBookmark(r.getBookmark());
					rc.setEndPoint('EndToStart', re);

					return { start: rc.text.length, end: rc.text.length + r.text.length, length: r.text.length, text: r.text };
				}) ||

				/* browser not supported */
				function() {
					return { start: 0, end: e.value.length, length: 0 };
				}

			)();

		},

		replaceSelection: function() {

			var e = this.jquery ? this[0] : this;
			var text = arguments[0] || '';

			return (

				/* mozilla / dom 3.0 */
				('selectionStart' in e && function() {
					e.value = e.value.substr(0, e.selectionStart) + text + e.value.substr(e.selectionEnd, e.value.length);
					return this;
				}) ||

				/* exploder */
				(document.selection && function() {
					e.focus();
					document.selection.createRange().text = text;
					return this;
				}) ||

				/* browser not supported */
				function() {
					e.value += text;
					return this;
				}

			)();

		}
		,
		setSelection: function(pos) {
		    if ($(this).get(0).setSelectionRange) {
		      $(this).get(0).setSelectionRange(pos.start, pos.end);
		    } else if ($(this).get(0).createTextRange) {
		      var range = $(this).get(0).createTextRange();
		      range.collapse(true);
		      range.moveEnd('character', pos.start);
		      range.moveStart('character', pos.end);
		      range.select();
		    }
		}
	};

	jQuery.each(fieldSelection, function(i) { jQuery.fn[i] = this; });

})();

var sal=new Array();
;(function(jQuery){
	$.fn.formulabuilder = function(op){
		
	
	
		var fb = $.fn.formulabuilder;
		fb.defaults = {
			editorWidth	: 300,
			editorHeight : 50,
			array:[],
			onInit		: function(){}
		};
		var o = $.extend({},fb.defaults,op);
		
		sal=o.array;
		var FormulaEditorTextarea = function(parent){
			this.currentPos={ start: 0, end: 0, length: 0 };
			this.data="";
			this.display=$("<textarea id='formulaEditorText' style='width:"+o.editorWidth+";height:"+o.editorHeight+"'></textarea>");
			this.display.blur(function()
			{
				this.parent.currentPos = $(this).getSelection();
				
			});
			this.display.get(0).parent = this;
		}	
		var Operator = function(key,value,parent)
		{
			this.key=key;
			this.value=value;
			this.display = $("<li>");
			this.display.html(value);
			this.display.click(function()
				{
				    for(var i=0;i<sal.length;i++)
					{
						if(sal[i]==this.parent.value)
							this.parent.value="{"+this.parent.value+"}";
					}
					formulaEditortextarea = this.parent.parent.parent.objFormulaEditorTextarea;
					$(formulaEditortextarea.display).setSelection(formulaEditortextarea.currentPos);
					$(formulaEditortextarea.display).replaceSelection(this.parent.value);
					$(formulaEditortextarea.display).focus();
				});
			this.display.get(0).parent = this;
			this.parent = parent;
		}
		
		var Operators= function(parent)
		{
			this.operatorList = {};
			this.operatorList[0]=new Operator("add",'+',this);
			this.operatorList[1]=new Operator("sub",'-',this);
			this.operatorList[2]=new Operator("mul",'*',this);
			this.operatorList[3]=new Operator("div",'/',this);
			this.operatorList[4]=new Operator("open",'(',this);
			this.operatorList[5]=new Operator("close",')',this);
			alert(sal.length);
			/*for(var i=6;i<(6+sal.length);i++)
				{
				
				this.operatorList[i]=new Operator(sal[i-6],sal[i-6],this);
				}
			this.display = $("<ul class='operator'></ul>");*/
			this.display=$("<ul class='operator'></ul>");
			this.operatorList1 = {};
			for(var i=0;i<sal.length;i++)
			{
			this.operatorList1[i]=new Operator(sal[i],sal[i],this);
			}
			this.display = $("<ul class='operator'></ul>");
			jQuery.data(this.display,"parent",this);
			this.parent = parent;
			jQuery.each(this.operatorList,function()
			{
				$(this.parent.display).append(this.display);
			});
			jQuery.each(this.operatorList1,function()
					{
						$(this.parent.display).append(this.display);
					}
					
			);
			
		}
		
		this.objFormulaEditorTextarea = new FormulaEditorTextarea(this);
		this.objOperators = new Operators(this);
		var objOperators = this.objOperators;
		var objFormulaEditorTextarea = this.objFormulaEditorTextarea;
		return this.each(
			function()
			{
				$(this).append(objOperators.display);
				$(this).append("<div style='clear:both'></div>")
				$(this).append(objFormulaEditorTextarea.display);
			}
		);
		
		
	};
	
	
	
	})(jQuery);
