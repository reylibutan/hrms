var YES = "1";
var NO = "0";

$(document).ready(function() {
	HRMS.initViewAction();
	
	initDatePickers();
	initDerivedValuesEvents();
	initSubHivRiskEvents();
	initResultsEvents();
	initSameHeightColumns();
});

function initDatePickers() {
	$(".date_input:not([readonly])").datepicker({
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
	
	$("input[name='patientDTO.hivRisks']:checked").closest("label").addClass("active");
}

function initResultsEvents() {
	$("input[type=radio][name=isHivTested]").change(function() {
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

function initSameHeightColumns() {
	var $row = $("div.sameHeightColsRow");
	var highest = 0;
	
	// find highest
	$row.find("> div[class^=col-]").each(function() {
		var $this = $(this);
		var bodyHeight = $this.find("div.card-body").innerHeight();
		
		var actionBarHeight = 0;
		var $actionBar = $(this).find("div.card-actionbar");
		if($actionBar.length) {
			actionBarHeight = $actionBar.outerHeight(true);
		}

		if(highest < bodyHeight + actionBarHeight) {
			highest = bodyHeight + actionBarHeight;
		}
	});
	
	// apply highest (apply but consider actionBar)
	$row.find("> div[class^=col-]").each(function() {
		var $actionBar = $(this).find("div.card-actionbar");
		if($actionBar.length) {
			$(this).find("div.card-body").innerHeight(highest - $actionBar.outerHeight(true));
		} else {
			$(this).find("div.card-body").innerHeight(highest);
		}
	});
}