function clearNoNum(obj) {
	var str = obj.val();
	// 先把非数字的都替换掉，除了数字和.
	str = str.replace(/[^\d.]/g, "");
	// 必须保证第一个为数字而不是.
	str = str.replace(/^\./g, "");
	// 保证只有出现一个.而没有多个.
	str = str.replace(/\.{2,}/g, ".");
	// 保证.只出现一次，而不能出现两次以上
	str = str.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
	obj.val(str);
}
/**
 * 判断s是否为空
 * 
 * @param {Object}
 *            s
 */
function JudgeNull(s) {
	if (s === undefined || s === null || s === "") {
		return true;
	} else {
		return false;
	}
}
function timeToString(time) {
	var year = time.getFullYear();
	var month = time.getMonth() + 1;
	var day = time.getDate();
	month = month < 10 ? "0" + month : month;
	return year + "" + month;
}
function iFrameHeight(iframeId) {

	var ifm = document.getElementById(iframeId);
	var subWeb = document.frames ? document.frames[iframeId].document
			: ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
	}

}

$(document).ready(function() {
	var numItems = $("[dataType='num']");
	$.each(numItems, function(i, numItem) {
		$(numItem).bind('afterpaste keyup blur', function() {
			$(this).val($(this).val().replace(/\D/g, ''));
		});
	});
	var decimalItems = $("[dataType='dec']");
	$.each(decimalItems, function(i, decItem) {
		$(decItem).bind('afterpaste keyup blur', function() {
			clearNoNum($(this));
		});
	});
})
var commonFun = {

	validForm : function(formObj) {
		var objList = $('[need]', formObj);
		if (!objList || !objList.length) {
			return true;
		}
		for (var i = 0; i < objList.length; i++) {
			var obj = $(objList[i]);
			var validTip = obj.attr('validTip');
			if (obj.val() == "") {
				this.showTip(obj, validTip);
				return false;
			}
		}
		return true;
	},
	showTip : function(obj, tip, bTrim) {
		obj.tips({
			side : 3,
			msg : tip ? tip : '必填',
			bg : '#AE81FF',
			time : 2
		});
		obj.focus();
		obj.css("background-color", "white");
	}
}

function toDecimal2(x) {
	var f = parseFloat(x);
	if (isNaN(f)) {
		return false;
	}
	var f = Math.round(x * 100) / 100;
	var s = f.toString();
	var rs = s.indexOf('.');
	if (rs < 0) {
		rs = s.length;
		s += '.';
	}
	while (s.length <= rs + 2) {
		s += '0';
	}
	return s;
}