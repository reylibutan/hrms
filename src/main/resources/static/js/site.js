$(document).ready(function() {
	initButtonEvents();
	initAlertEvents();
});

function initButtonEvents() {
	// submit logout form
	$("#logoutBtn").click(function() {
		$("#logoutForm").submit();
	});
}

function initAlertEvents() {
	// custom animation on alert page show
	var $alertDiv = $("div.alert");
	if($alertDiv.length) {
		$alertDiv.slideDown(HRMS.DEFAULT_EASE_TIME);
	}
	
	// custom animation on alert close
	$(".alert .close").click(function() {
		$(this).closest(".alert").slideUp(HRMS.DEFAULT_EASE_TIME, function() {
			$(this).remove();
		});
	});
}

(function(HRMS, $, undefined ) {
	// http://stackoverflow.com/questions/881515/how-do-i-declare-a-namespace-in-javascript#answer-5947280
	
    HRMS.YES_VAL = "1";
    HRMS.NO_VAL = "0";
    HRMS.DEFAULT_EASE_TIME = 150;
    HRMS.ENTER_KEY = 13;
    
    //Public Method
    HRMS.initViewAction = function() {
    	var ACTION_VIEW = "view";
    	var ACTION_UPDATE = "update";
    	var action = $("#view_action").val();
    	
    	if(action === ACTION_VIEW) {
    		$("form textarea").prop("readonly", "readonly");
    		$("form input[type=text]").prop("readonly", "readonly");
    		$("form input[type=radio], form input[type=checkbox]").prop("disabled", "disabled");
    		
    		$(".customBtnGroup label.btn").click(function(e) {
    			return false;
    		});
    	}
    };
    
    HRMS.toTitleCase = function (str) {
        return str.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
    }
    
}(window.HRMS = window.skillet || {}, jQuery));