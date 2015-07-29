$(document).ready(function() {
	initDerivedValuesEvents();
});

function initDerivedValuesEvents() {
	// compute Age based on Birthdate
	$("#birthdate").on("keyup blur", function() {
		var age = '';
		var $age = $("#age");
		var birthdate = $(this).val();
		
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
	});
}