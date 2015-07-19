$(document).ready(function() {
	initButtonEvents();
});

function initButtonEvents() {
	// submit logout form
	$("#logoutBtn").click(function() {
		$("#logoutForm").submit();
	});
	
	// custom animation on alert close
	$(".alert .close").click(function() {
		$(this).closest(".alert").slideUp(150, function() {
			$(this).remove();
		});
	});
}