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
		$alertDiv.slideDown(150);
	}
	
	// custom animation on alert close
	$(".alert .close").click(function() {
		$(this).closest(".alert").slideUp(150, function() {
			$(this).remove();
		});
	});
}