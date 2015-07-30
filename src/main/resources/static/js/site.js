$(document).ready(function() {
	initButtonEvents();
	initAlertEvents();
	
	// ======================================================
	// @TODO: 
	// 		initSameHeightColumns(); 
	// ======================================================
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
    
}(window.HRMS = window.skillet || {}, jQuery));