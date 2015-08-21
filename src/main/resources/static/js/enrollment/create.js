$(document).ready(function() {
	initSelect2();
	initDatePickers();
});

function initSelect2() {
	$(".select2-list").select2();
}

function initDatePickers() {
	$(".date_input:not([readonly])").datepicker({
		autoclose: true,
		todayHighlight: true,
		format: "yyyy/mm/dd"
	}).on("changeDate", function(e) {
		computeAndSetAge();
    });
}