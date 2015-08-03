var YES = "1";
var NO = "0";

$(document).ready(function() {
	initDatePickers();
	initDerivedValuesEvents();
	initSubHivRiskEvents();	
	initResultsEvents();
});

function initDatePickers() {
	$(".date_input").datepicker({
		autoclose: true,
		todayHighlight: true,
		format: "yyyy/mm/dd"
	}).on("changeDate", function(e) {
		computeAndSetAge();
    });
}

function initDerivedValuesEvents() {
	// compute age on page show
	computeAndSetAge();
	
	// add event
	// compute Age based on Birthdate
	$("#birthdate").on("keyup blur", function() {	
		computeAndSetAge();
	});
}

function computeAndSetAge() {
	var age = "";
	var $age = $("#age");
	var birthdate = $("#birthdate").val();
	
	if(birthdate) {
		var result = moment().diff(birthdate, "year");
		
		if(result) {
			age = result;
			$age.addClass("dirty"); // theme-specific class
		} else {
			$age.removeClass("dirty"); // theme-specific class
		}
	}
	
	$age.val(age);
}

function initSubHivRiskEvents() {
	$("input.parentHivRisk").click(function() {
		var $this = $(this);
		if($this.is(":checked")) {
			// show sub HIV risks
			$this.closest("div.col").siblings("div.subHivRisk").slideDown(HRMS.DEFAULT_EASE_TIME);
		} else {
			$this.closest("div.col").siblings("div.subHivRisk").slideUp(HRMS.DEFAULT_EASE_TIME);
		}
	});
	
	$("input[name=hivRisks]:checked").closest("label").addClass("active");
}

function initResultsEvents() {
	$("input[type=radio][name=testedForHiv]").change(function() {
		var $this = $(this);
		if($this.val() === HRMS.YES_VAL) {
			$this.closest("div.row").siblings("div.positiveForHivRow").slideDown(HRMS.DEFAULT_EASE_TIME);
			$this.closest("div.row").siblings("div.reasonForNotTestingRow").slideUp(HRMS.DEFAULT_EASE_TIME);
		} else {
			$this.closest("div.row").siblings("div.positiveForHivRow").slideUp(HRMS.DEFAULT_EASE_TIME);
			$this.closest("div.row").siblings("div.reasonForNotTestingRow").slideDown(HRMS.DEFAULT_EASE_TIME);
		}
	});
}