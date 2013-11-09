function $(objId){return document.getElementById(objId)}
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g, "");}
String.prototype.ltrim=function(){return this.replace(/(^\s*)/g,"");}
String.prototype.rtrim=function(){return this.replace(/(\s*$)/g,"");}

var MSGID_1	="1";	            //Are you sure to exit from the current page ?
var MSGID_2	="2";		        //Are you sure to save the data to database ?
var MSGID_3	="3";		        //Are you sure to delete it ?
var MSGID_4	="4";		        //Are you sure to print \1 ?
var MSGID_11	="11";	            //Succeed to process \1
var MSGID_12	="12";	            //the data is not existed.
var MSGID_13	="13";	            //the file has been existed, are you sure to rewrite it ?
var MSGID_21 = "21";	            //Error\n:\1 should be entered
var MSGID_22	="22";	            //Error\n:Please input \1 in the alpha character. 
var MSGID_23	="23";	            //Error\n:Only 3 important factors could be selected. 
var MSGID_24	="24";	            //The upload failed for the size of file is more than 3M.
var MSGID_25	="25";	            //Error\n:Please input \1 in the numeric character. 
var MSGID_26	="26";	            //Error\n:Failed to create application number. 
var MSGID_27	="27";	            //the input code is not existed in master table \1, please make sure of master table \1
var MSGID_28	="28";	            //The range of input \1 is not right.
var MSGID_29	="29";	            //please select the line which you want to \1.
var MSGID_30	="30";	            //please input the search condition.
var MSGID_31	="31";	            //You are not permited to  \1 more than one line.
var MSGID_32	="32";	            //The data being processed could being updated or deleted, \n please try once again.
var MSGID_33	="33";	            //Are you sure to update this user's authority ?
var MSGID_34	="34";	            //the upload file \1 is not existed.
var MSGID_901="901";		        //It failed to connect with the database.			ZZZZ	2008/05/01	ZZZZ	2008/05/01
var MSGID_902="902";		        //It failed to initialize the form. 			ZZZZ	2008/05/01	ZZZZ	2008/05/01
var MSGID_903="903";		        //The system error occurred. Please contact the person in charge of the system. \n\1		\1=error.description	ZZZZ	2008/05/01	ZZZZ	2008/05/01
var MSGID_904="904";		        //The exception error occurred. Please contact the system administrator. \n\1		\1=システムエラーメッセージ	ZZZZ	2008/05/01	ZZZZ	2008/05/01

var MSGID_1000001 ="1000001";		//Error\n:The input of \1 is wrong. Please correct it.
var MSGID_1000002 ="1000002";		//Error\n:The application number of \1 is not existed in table of t_applicant. Please check your uploaded file and try once again.
var MSGID_1000003 ="1000003";		//Error\n: Days Remaining input must be the range of -60 and 60.
var MSGID_1000004 ="1000004";		//Warning\n: Are you sure to change the mailing template?
var MSGID_1000005 = "1000005";		//Warning\n: Because the applicant whose application No. is \1 has not paid for the application fee, it's interview status could not be update to success.
var MSGID_1000006 =	"1000006";	    //Warning:\n Your are not permitted to change the referee's e-mail.						
var MSGID_1000007=	"1000007";	    //Warning:\n Your are not permitted to upload the material.						
var MSGID_1000008=	"1000008";	    //Warning:\n The e-mail you input is not correct, please check it and try once again.						
var MSGID_1000009=	"1000009";	    //Warning:\n The e-mail you input has been used by another user, please change it and input again.						
var MSGID_1000010=	"1000010";	    //Warning:\The system has not been able to validate your Password.Please make sure that you have supplied your Username and try again.						

var MSGID_1000011="1000011";		//The begin date must be larger than the end date.
var MSGID_1000012="1000012";		//Please input any one of the three items \1,\2 and \3
var MSGID_1000013="1000013";		//You need to press the "I Agree" checkbox.
var MSGID_1000015="1000015";        //Warning:\The \1 must be entered.
var MSGID_1000016="1000016";        //Warning:\The supported formats could only be gif, jpg, jpeg, png, please check your picture file and try once again.

var MSGID_1000018 = "1000018";      //Warning:\The emails you checked have been successfully send out.
var MSGID_1000019 = "1000019";      //Warning:\It's Regretable that mail you have checked has failed to send out,\1
var MSGID_1000020 = "1000020";      //please select the email which you want to send out.
var MSGID_1000021 = "1000021";      //There is not any record in according with your search condition.
var MSGID_1000024 = "1000024";      //Error:The email of the first referee should not be the same as that of the second referee, please check it and try once again.

var MSGID_1000025 = "1000025";      //Error:It's regretable that you have not any authority to access the system.
var MSGID_1000026 = "1000026";      //Error:The save of information failed for the size of picture is more than 200K.
var MSGID_1000027 = "1000027";      //Warning:The supported formats could only be csv, please check your material and try once again.
var MSGID_1000028 = "1000028";      //\1 is not existed in \2
var MSGID_1000029 = "1000029";      //The program code should be 3 bytes, please check it and try once again.
var MSGID_1000030 = "1000030";      //The program code should be 3 bytes, please check it and try once again.
var MSGID_1000031 = "1000031";      //The program code should be 3 bytes, please check it and try once again.
var MSGID_1000032 = "1000032";      //The program code should be 3 bytes, please check it and try once again.
var MSGID_1000033 = "1000033";      //Error:\1 \2 :The application time limit was passed. 
var MSGID_1000034 = "1000034";
var MSGID_1000035 = "1000035";
var MSGID_1000036 = "1000036";
var MSGID_1000037 = "1000037";
var MSGID_1000038 = "1000038";
var MSGID_1000039 = "1000039";

var MSGID_1000040 = "1000040";      //The application No should be 6 bytes, please check it and try once again.
var MSGID_1000041 = "1000041";      //The email address (application No is \1) does not exist, please check it and try once again.
var MSGID_1000042 = "1000042";      //The basic information (application No is \1) has not been completed.



var MSGID_2000002 = "2000002";      //This program choice is the same as the other, please check and try again.


function openModalDialogWindow(url,height,width)
{
    var feature = "dialogWidth:"+width+"px;dialogHeight:"+height+"px;scroll:yes;status:no;help:no;center:1";
    var returnTarget = window.showModalDialog(url, '', feature);

    if(returnTarget != null)
    {
        return returnTarget
    }
    else
    {
        return '';
    }
}

function openWindow(url,height,width)
{
    //$("btnClick").click();
    showWindow(url,400,400)

}

function showWindow(url,height,width)
{
        
    //var feature = "dialogWidth:"+width+"px;dialogHeight:"+height+"px;scroll:yes;status:no;help:no;center:1";
    var leftWidth=(document.body.clientWidth/2-250);
    var returnTarget = window.open(url, 'ShortlistedApplication', 'height=600px, width=500px, top=100px, left='+leftWidth+'px, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=no');

    if(returnTarget != null)
    {
        return returnTarget
    }
    else
    {
        return '';
    }


}

function openWindow1(url,height,width,scrollbars)
{
    //$("btnClick").click();
    showWindow1(url,400,400)

}

function showWindow1(url,height,width)
{
        
    //var feature = "dialogWidth:"+width+"px;dialogHeight:"+height+"px;scroll:yes;status:no;help:no;center:1";
    var leftWidth=(document.body.clientWidth/2-250);
    var returnTarget = window.open(url, 'ShortlistedApplication', 'height=670px, width=650px, top=100px, left='+leftWidth+'px, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=no');

    if(returnTarget != null)
    {
        return returnTarget
    }
    else
    {
        return '';
    }


}


//select all value when the textbox onfocus
function selectAll(txtName)
{
        txtName.select();
}

//select all value when the Item Eanble
function setFocus()
{

      for(i=0;i<document.forms[0].elements.length;i++){
          
          itemType = document.forms[0].elements[i].type;
          itemEnable = document.forms[0].elements[i].disabled;
          itemReadonly = document.forms[0].elements[i].readOnly;
      
          if (itemType == "text" && 
              itemEnable == false && 
              itemReadonly != true){
              setItemFocus(document.forms[0].elements[i], itemType)
              break;
       } else if(itemType == "checkbox" && 
                 itemEnable == false && 
                 itemReadonly != true){
               
              setItemFocus(document.forms[0].elements[i], itemType)
              break;
       } else if(itemType == "password" &&
                itemEnable == false && 
                itemReadonly != true){
           setItemFocus(document.forms[0].elements[i], itemType)  
                break;
       } else if(itemType == "button" && 
                itemEnable == false && 
                itemReadonly != true){
           setItemFocus(document.forms[0].elements[i], itemType)
              break;
       } else if (itemType == "select-one" &&
                  itemEnable == false && 
                  itemReadonly != true){
           
           setItemFocus(document.forms[0].elements[i], itemType)
              break;
       } else if (itemType == "radio" &&
                  itemEnable == false && 
                  itemReadonly != true){
           
           setItemFocus(document.forms[0].elements[i], itemType)
              break;
       }
    }
  }

//select all value when the Item onfocus
function setItemFocus(myItem, itemType)
{
      if (itemType == "text" || 
          itemType == "password"){ 
          document.forms[0].elements[i].select();

       } else if(itemType == "checkbox" || 
                itemType == "button" || 
                  itemType == "select-one" ||
                  itemType == "radio"){
          document.forms[0].elements[i].focus();
       } 
}

//menu control Item  set default value
    function setDefaultValue(typeName, searchValue, defalultValue)
    {
      for(i=0; i<document.forms[0].elements.length; i++)
      {
          itemType = document.forms[0].elements[i].type;
          itemName = document.forms[0].elements[i].name;
       if (itemType == typeName && itemName.indexOf(searchValue) != -1 )
       {
         document.forms[0].elements[i].value = defalultValue;
       }
      }
    }

//menu control button  submit form value
    function submitForm()
    {
        document.forms[0].submit();
    }

    function isnumber(sDouble)
    {
      var re = /^\d+(?=\.{0,1}\d+$|$)/
      return re.test(sDouble);
    }

    function isDigitChar(s)
    {
      //var re = /^[a-zA-Z0-9_-]+$/
      //return re.test(s); 
       
       if(navigator.userAgent.indexOf("MSIE")>0)
       {
            //return "MSIE";
		    s=s.replace(/\r\n/g,"r");
       }
       if(isFirefox=navigator.userAgent.indexOf("Firefox")>0)
       {
            //return "Firefox";
		    s=s.replace(/\n/g,"r");
       }
       if(isSafari=navigator.userAgent.indexOf("Safari")>0) 
       {
            //return "Safari";
		    s=s.replace(/\n/g,"r");
       }
       if(isCamino=navigator.userAgent.indexOf("Camino")>0)
       {
            //return "Camino";
            s=s.replace(/\n/g,"r");
       }
       if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0)
       {
            //return "Gecko";
            s=s.replace(/\n/g,"r");
       }
           
        var strMatch = "\\\"$@#!~`^&*()-=_+\/?.,;{}[]:%|<>' 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (iiii = 0; iiii < s.length; iiii++)
		{
			if (strMatch.indexOf(s.substr(iiii,1)) < 0)
			{
				return false;
			}
		}

		return true;
    }
    
    function isDigitStr(s)
    {
      var re = /^[\s’,.:;?!a-zA-Z0-9_-]+$/
      return re.test(s);
    }
    
    function isDigitSpace(s)
    {
      var re = /^[\s,.a-zA-Z0-9]+$/
      return re.test(s);
    }

//format Number (price. quantity..) fan 2008/10/24
    function formatNumber(src, pos)
    {
      var pointLength = getPointLength(src+"")
      var str1;

      if (Math.abs(src) - parseInt(Math.abs(src)) > 0 && pointLength > pos) 
      {
          switch (pos)
          {
              case 0:
                  str1 = ""+Math.abs(("" + src).replace(/^(.*\..{0}).*$/,"$1"))
                  return formatNumber(str1, pos)
              case 1:
                  str1 = ""+Math.abs(("" + src).replace(/^(.*\..{1}).*$/,"$1"))
                  return formatNumber(str1, pos)
              case 2:
                  str1 = ""+Math.abs(("" + src).replace(/^(.*\..{2}).*$/,"$1"))
                  return formatNumber(str1, pos)
              case 3:
                  str1 = ""+Math.abs(("" + src).replace(/^(.*\..{3}).*$/,"$1"))
                  return formatNumber(str1, pos)
          }
      }
        return eval(src).toFixed(pos);
    }
//get Number point part length (eg:5.666 length =3) fan 2008/10/25
        function getPointLength(src)
    {
        return ""+src.replace(/(\d*\.?)/,"").length;
    }


    
    //get Integer number format (eg:-3555.666 format =3555) fan 2008/10/29
    function formatInteger(src, pos)
    {        
          switch (pos)
          {
              case -1:
                  var str1 = ("" + src).replace(/(\.\d+)/, "");
                  return str1
          }
      }

    //get Quantity format (eg:-3555.666 format =3555) fan 2008/10/29
    function formatQty(object, pos, defaultValue)
    {
       if(object.value == "" || isNaN(object.value))
        {
            object.value = defaultValue;
          return;
        }
        else
        {
            var formatPrice = formatInteger(Math.abs(object.value), pos)
            object.value = formatPrice;
        }
    }
        
function UrlEncode(str){
    var i,c,ret="",strSpecial="!\"#$%&'()*+,/:;<=>?@[\]^`{|}~%";
    for(i=0;i<str.length;i++){
        if(str.charCodeAt(i)>=0x4e00){
            c=qswhU2GB[str.charCodeAt(i)-0x4e00];
            ret+="%"+c.slice(0,2)+"%"+c.slice(-2);
        }
        else{
            c=str.charAt(i);
            if(c==" ")
                ret+="+";
            else if(strSpecial.indexOf(c)!=-1)
                ret+="%"+str.charCodeAt(i).toString(16);
            else
                ret+=c;
        }
    }
    return ret;
}

function getSpell(str,sp){
    var i,c,t,ret="";
    if(sp==null)sp="";
    for(i=0;i<str.length;i++){
        if(str.charCodeAt(i)>=0x4e00){
            c=parseInt(qswhU2GB[str.charCodeAt(i)-0x4e00],16);
            if(c<55290){
                for(t=qswhSpell.length-1;t>0;t=t-2)if(qswhSpell[t]<=c)break;
                if(t>0)ret+=qswhSpell[t-1]+sp;
            }
        }
    }
    return ret.substr(0,ret.length-sp.length);
}
function UrlDecode(str){ 
   var ret=""; 
   for(var i=0;i<str.length;i++){ 
    var chr = str.charAt(i); 
     if(chr == "+"){ 
       ret+=" "; 
     }else if(chr=="%"){ 
      var asc = str.substring(i+1,i+3); 
      if(parseInt("0x"+asc)>0x7f){ 
       ret+=asc2str(parseInt("0x"+asc+str.substring(i+4,i+6))); 
       i+=5; 
      }else{ 
       ret+=asc2str(parseInt("0x"+asc)); 
       i+=2; 
      } 
     }else{ 
       ret+= chr; 
     } 
   } 
   return ret; 
} 
 
    
    function ckNum(text,type) 
    {
        if(event.keyCode==9 || event.keyCode==37 || event.keyCode==37)return
        s=text.value
        num=s.replace(/([^0-9.]+)/gi,"")
        var strtemp=num.replace(/\.{2}/gi,"")
        if(text.value!=strtemp)text.value=strtemp
        if(type=="")
        {
            if(text.value=="")text.value=0;
        }
        else
        {
            if(text.value=="")text.value="";
        }
    }

    var objActive;
    function GetActiveText(objHTML) {
	    objActive=objHTML;
	    if(document.selection){
		    var obj=document.getElementById(objHTML);
		    obj.currPos = document.selection.createRange().duplicate();
	    }
    }

    function InsertText(objHTML,strText,bolReplace) {
	    if(strText==""){return("")}
	    var obj=document.getElementById(objHTML);
	    if(document.selection){
		    if (obj.currPos){
			    if(bolReplace && (obj.value=="")){
				    obj.currPos.text=strText;
			    }
			    else{
				    obj.currPos.text+=strText;
			    }
		    }
		    else{
			    obj.value+=strText;
		    }
	    }
	    else{
		    if(bolReplace){
			    obj.value=obj.value.slice(0,obj.selectionStart) + strText + obj.value.slice(obj.selectionEnd,obj.value.length);
		    }
		    else{
			    obj.value=obj.value.slice(0,obj.selectionStart) + strText + obj.value.slice(obj.selectionStart,obj.value.length);
		    }
	    }
	    //obj.focus();
    }

    function ReplaceText(objHTML,strPrevious,strNext) {
	    var obj=document.getElementById(objHTML);
	    var strText;
	    if(document.selection && document.selection.type == "Text"){
		    if (obj.currPos){
			    var range = document.selection.createRange();
			    range.text = strPrevious + range.text + strNext;
			    return("");
		    }
		    else{
			    strText=strPrevious + strNext;
			    return(strText);
		    }
	    }
	    else{
		    if(obj.selectionStart || obj.selectionEnd){
			    strText=strPrevious + obj.value.slice(obj.selectionStart,obj.selectionEnd) + strNext;
			    return(strText);
		    }
		    else{
			    strText=strPrevious + strNext;
			    return(strText);
		    }
	    }
    }

function setMenuClass()
{
    //pageId
    
}

function closeWindow()
{
    window.opener=null;
    window.open(' ', '_self', ' ');
    window.close()
    
}

//20080211 by YG.Z
    function m_ClearInputs(p_node) {   
        var m_node;   
        if (p_node.nodeType) {   
            m_node = p_node;   
        }   
        else {   
            m_node = document.getElementById(p_node); // the id   
        }   
           
        var i, elm, elements;   
                   
        elements = m_node.getElementsByTagName('input');           
        for( i=0, elm; elm=elements.item(i++); )   
        {   
            if (elm.getAttribute('type') == "text")   
            {   
                elm.value = '';   
            }   
        }   
           
        elements = m_node.getElementsByTagName('select');   
        for( i=0, elm; elm=elements.item(i++); )   
        {   
            elm.options.selectedIndex=0;   
        }   
    } 
    
    function checkEmail(email)
    {
        //var CheckMail = /^([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-]+)@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        var CheckMail = /^[a-zA-Z0-9_]+([-+.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([-.][a-zA-Z0-9_]+)*\.[a-zA-Z0-9_]+([-.][a-zA-Z0-9]+)*$/ 

        if(CheckMail.test(email))
        {

          return true;
        }
        else
        {
            return false;
        }
    }
    
    // 20100304 add by Daniel
    // Used to verify the number of pure
    function checkNumber(strSrc)
	{
		var strRegular = /^\d+$/;

		if (true == (strRegular.test(strSrc)))
			return true
		else
			return false;
	}
    
    function getMsg(msgid,params1,params2,params3)
    {
        var msg=eval("json_msg.msg_" + msgid);
        msg=msg.replace("\\n","<br />");
        
        if(params1!="")
        {
            msg=msg.replace("\\1",params1);
        }
        
        if(params2!="")
        {
            msg=msg.replace("\\2",params2);
        }
        
        if(params3!="")
        {
            msg=msg.replace("\\3",params3);
        }
        
        return msg;
    }
    
    function getMsgBox(msgid,params1,params2,params3)
    {
        var msg=eval("json_msg.msg_" + msgid);
        msg=msg.replace("\\n","\n");
        if(params1!="")
        {
            msg=msg.replace("\\1",params1);
        }
        
        if(params2!="")
        {
            msg=msg.replace("\\2",params2);
        }
        
        if(params3!="")
        {
            msg=msg.replace("\\3",params3);
        }
        
        return msg;
    }
    
    function setScreen()
    {
        //document.getElementById("float_div").style.right=(screen.width-935)/2 + "px";
        //document.getElementById("mainbody").style.height=document.body.offsetHeight + "px";
    }
    
    function checkLen(obj,len)
    {
        if(obj.value.length>=len)
        {
            obj.value=obj.value.substr(0,len-1)
            return false;
        }
    }

    function getclientHeight(){if(window.innerHeight<document.body.clientHeight){return window.innerHeight}return document.body.clientHeight};
    function getscrollHeight(){if(document.body.scrollHeight>document.documentElement.clientHeight){return document.body.scrollHeight}else{return document.documentElement.clientHeight}};
    function initLoading()
    {
        
        $("UpdateProgress1").style.height=getscrollHeight()+"px";
	    $("UpdateProgress1").style.width=document.body.clientWidth+"px";
	    $("loading_div").style.left=(document.body.clientWidth/2-10)+"px";
	    $("loading_div").style.top="355px";
    }
    function initLoadingRef()
    {
        
        $("UpdateProgress1").style.height=getscrollHeight()+"px";
	    $("UpdateProgress1").style.width=document.body.clientWidth+"px";
	    $("loading_div").style.left=(document.body.clientWidth/2-60)+"px";
	    $("loading_div").style.top="97px";
    }
    function initLoadingRefSubmit()
    {
        
        $("UpdateProgress1").style.height=getscrollHeight()+"px";
	    $("UpdateProgress1").style.width=document.body.clientWidth+"px";
	    $("loading_div").style.left=(document.body.clientWidth/2-150)+"px";
	    $("loading_div").style.top="100px";
    }