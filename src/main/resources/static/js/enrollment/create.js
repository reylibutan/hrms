$(document).ready(function() {
	initSelect2();
	initDatePickers();
	
	$("#addOtherBtn").click(function() {
		var $othersRowClone = $("#baseOthersRow").clone();
		$othersRowClone.removeAttr("id");
		
		$("#othersContainer").append($othersRowClone);
		
		initDatePickers();		
		HRMS.initInputMask();		
		scrollToBottom();
	});
	
	$("#othersContainer").on("click", "button.othersClose", function() {
		var $othersRow = $(this).closest("div.othersRow");
		if(!$othersRow.attr("id")) {
			$othersRow.slideUp(HRMS.DEFAULT_EASE_TIME, function() {
				$othersRow.remove();
			});
		}
	});
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

function scrollToBottom() {
	window.scrollTo(0, document.body.scrollHeight);
}