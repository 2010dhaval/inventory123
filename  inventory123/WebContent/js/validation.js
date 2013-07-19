/**
 * Document   : validation.js
 * Created on : 9-sep-2011
 * Created By : Rupangi Dave
 * Purpose	  : This file comtains common JavaScript Validation functions 
 */

// To check if Empty
  // private static String VALID_TELEPHONENO_PATTERN = "^[0-9]{8,13}?$";//^[0-9]{8,13}$	
/*private static String VALID_PT_NUMBER = "^([0-9]){11}([a-zA-Z]){1}?$";
private static String VALID_BRANCH_PF_CODE = "^[a-zA-Z0-9\\/]{2,30}+$";
*/
function isEmpty_3(val, displayMessage, txtBoxName)

{
	//alert("fdsfdsdf");
	val = jQuery.trim(val);
	jQuery(txtBoxName).val(val);
	//alert(val);
	if (val == null || val == "") {
		
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).focus();
		//alert(txtBoxName);
		return false;
	}
	else {
		return true;
	}
}
function isValidCustomName(val, displayMessage, txtBoxName)
{ 
	val = jQuery.trim(val);
    jQuery(txtBoxName).val(val);
   
 if(val == null || val == "") //{                       //(!(val instanceof String))
 {
	 jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage});
	return false;
 }
if (!(val.match(/^[a-zA-Z0-9& .'()-]+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}
function isEmpty(val, displayMessage, txtBoxName, errorMsgId)
{
	
	if(errorMsgId)
	{
		val = jQuery.trim(val);
		jQuery(txtBoxName).val(val);
		if (val == null || val == "") {
			jQuery(errorMsgId).nifsysDisplayErrMsg({
				msg: displayMessage
			});
			$(txtBoxName).focus();
			//alert(txtBoxName);
			return false;
		}
		else {
			return true;
		}
	}else
	{
		return isEmpty_3(val, displayMessage, txtBoxName);
	}
	
}

function isFileEmpty(val, displayMessage, txtBoxName)
{
	if (val == null || val == "") {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		//$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}

function isValidFile(val, displayMessage, txtBoxName)
{
	if (!(val.match(/jpg|png|gif|bmp|txt|jpeg|pdf|doc|docx|ppt|pptx|xls|xlsx|odt|ods|odp$/i)))
	{
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		return false;
	}
	else
	{
		return true;
	}
	
}

// To check if proper Name with characters, dot, apostrophe and space
function isValidName_3(val, displayMessage, txtBoxName)
{
	val = jQuery.trim(val);
	jQuery(txtBoxName).val(val);
	if (!(val.match(/^[a-zA-Z .']+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}
//for error msg id != errMsg
function isValidName(val, displayMessage, txtBoxName, errorMsgId)
{
	if(errorMsgId)
	{

		val = jQuery.trim(val);
		jQuery(txtBoxName).val(val);
		if (!(val.match(/^[a-zA-Z .']+$/))) {
			jQuery(errorMsgId).nifsysDisplayErrMsg({
				msg: displayMessage
			});
			$(txtBoxName).val("");
			$(txtBoxName).focus();
			return false;
		}
		else {
			return true;
		}
	}
	else
	{
		return isValidName_3(val, displayMessage, txtBoxName);
	}
}

//To check if valid Email Address
function isValidEmail(val, displayMessage, txtBoxName)
{
	val = jQuery.trim(val);
	jQuery(txtBoxName).val(val);
	if (!(val.match(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}

//To check if valid Address
function isValidAddress(val, displayMessage, txtBoxName)
{
	if (!(val.match(/^[0-9\sa-zA-Z\s(!,@,#,$,%,&,*)]+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}

//To check if Numeric
function isNumeric(val, displayMessage, txtBoxName)
{
	if (!(val.match(/^[0-9]+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}

function isValidLength_3(val, displayMessage, txtBoxName, min, max)
{
	

	if (val.length < min || val.length > max) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		//$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}

function isValidLength(val, displayMessage, txtBoxName, min, max, errorMsgId)
{
	if(errorMsgId)
	{
		if (val.length < min || val.length > max) {
			jQuery(errorMsgId).nifsysDisplayErrMsg({
				msg: displayMessage
			});
			//$(txtBoxName).val("");
			$(txtBoxName).focus();
			return false;
		}
		else {
			return true;
		}
	}else
	{
		return isValidLength_3(val, displayMessage, txtBoxName);
	}
	
}


/*function isValidPFCode(val, displayMessage, txtBoxName)
{
	if (!(val.match(/^[a-zA-Z0-9\/]+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
		else {
		return true;
	}
}
*/



function  validateTime(field)
{
	var errorMsg = "";

    // regular expression to match required time format//05:00
     re = /^(\d{1,2}):(\d{2})(:00)?([ap]m)?$/;
    
    if(field != '') {
      if(regs = field.match(re)) {
        if(regs[4]) {
          // 12-hour time format with am/pm
          if(regs[1] < 1 || regs[1] > 12) {
            errorMsg = "Invalid value for hours: " + regs[1];
          }
        } else {
          // 24-hour time format
          if(regs[1] > 23) {
            errorMsg = "Invalid value for hours: " + regs[1];
          }
        }
        if(!errorMsg && regs[2] > 59) {
          errorMsg = "Invalid value for minutes: " + regs[2];
        }
      } else {
        errorMsg = "Enter time like: 10:10 ";
      }
    }
    if(errorMsg != "") {
      alert(errorMsg);
      return false;
    }
    else
        { 
        return true;
        }   
}


function isValidPointNumeric(val, displayMessage, txtBoxName)
{
	if (!(val.match(/^[0-9]{1,2}[.0-9]{2}]+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
		else {
		return true;
	}
}
//private static String VALID_BRANCH_PF_CODE = "^[a-zA-Z0-9//\\]+$";





//To check if Pin is valid or not (it must be 5 digit or 6 digit
function isValidPin(val, displayMessage, txtBoxName)
{
	var len = val.length;
	
	if ( len < 5 || len > 6) {
		
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}
//To check if PAN is valid or not (it must be 10 digit 
function isValidPAN(val, displayMessage, txtBoxName)
{
	var len = val.length;
	
	if ( len != 10) {
		
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}


function isValidFirstCycleDate(val, displayMessage, txtBoxName)
    {
	
	if(val < 0 || val > 27 || val < 16)
	{
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
    }

function isValidDate(dateval, tdateval, displayMessage, txtBoxName)
{
	
if(dateval <= tdateval)
{
	jQuery('#errMsg').nifsysDisplayErrMsg({
		msg: displayMessage
	});
	$(txtBoxName).val("");
	$(txtBoxName).focus();
	return false;
}
else {
	return true;
}
}
	
function isRadioSelected(rad, displayMessage)
{
if(rad!=1  && rad!=2  && rad!=3  && rad!=4  && rad!=5)
{
	jQuery('#errMsg').nifsysDisplayErrMsg({
		msg: displayMessage
	});
	
	return false;
}
else {
	return true;
}
}
	

function isValidSecondCycleDate(val, displayMessage, txtBoxName)
{
//alert(val);
if(val < 0 || val > 27  )
{
	jQuery('#errMsg').nifsysDisplayErrMsg({
		msg: displayMessage
	});
	$(txtBoxName).val("");
	$(txtBoxName).focus();
	return false;
}
else {
	return true;
}
}



function isValidTelephoneNo(val, displayMessage, txtBoxName )
{
	//val = jQuery.trim(val);
	jQuery(txtBoxName).val(val);
	if (!(val.match(/^[0-9]{8,13}?$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}

/*function isValidPFCode(val, displayMessage, txtBoxName )
{
	//val = jQuery.trim(val);
	jQuery(txtBoxName).val(val);
	if (!(val.match(/^[a-zA-Z0-9\/]{2,30}+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}
*/

function isValidPTNo(val, displayMessage, txtBoxName )
{
	//val = jQuery.trim(val);
	jQuery(txtBoxName).val(val);
	if (!(val.match(/^([0-9]){11}([a-zA-Z]){1}?$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}

function isValidIFSCCode(val, displayMessage, txtBoxName )
{
	//val = jQuery.trim(val);
	jQuery(txtBoxName).val(val);
	if (!(val.match(/^[a-zA-Z]{4}[0-9]{7}$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}
//^-{0,9}\d*\.{0,9}\d+$

function isValidNumber(val, displayMessage, txtBoxName)
{
	if (!(val.match(/^-{0,9}\d*\.{0,9}\d+$/))) {
		jQuery('#errMsg').nifsysDisplayErrMsg({
			msg: displayMessage
		});
		$(txtBoxName).val("");
		$(txtBoxName).focus();
		return false;
	}
	else {
		return true;
	}
}
//private static String VALID_BRANCH_IFSC_CODE = "^[a-zA-Z]{4}[0-9]{7}$";//^[a-zA-Z]{4}[0-9]{10}

