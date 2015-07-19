$(document).ready(function() {
	initButtonEvents();
});

function initButtonEvents() {
	$("#logoutBtn").click(function() {
		$("#logoutForm").submit();
	});
}