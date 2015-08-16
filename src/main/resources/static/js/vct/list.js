var oVctDataTable = null;

$(document).ready(function() {
	initDatatable();
	initSearchForm();
});

function initSearchForm() {
	$("#vctName, #uniqueIdCode").keyup(function(e) {
		if(e.which == HRMS.ENTER_KEY) {
			$("#searchBtn").trigger("click");
	    }
	});
	
	$("#searchBtn").click(function() {
		oVctDataTable.fnDraw();
	});
	
	$("#clearBtn").click(function() {
		$("#vctName, #uniqueIdCode").val("");
		$("#searchBtn").trigger("click");
	});
}

function initDatatable() {
	oVctDataTable = $("#vctDataTable").dataTable({
		"searching": false,
		"processing": false,
		"serverSide": true,
		"ajax": {
            "url": "search",
            "data": function (d) {
                d.vctName = $("#vctName").val().trim();
                d.uniqueIdCode = $("#uniqueIdCode").val().trim();
            }
        },
        "aoColumns": [
          	{"mData": "fullName"},
          	{"mData": "patient.uniqueIdCode"},
			{"mData": "patient.birthdate"},
			{"mData": "patient.sex"},
			{"mData": null},
        ],
		"columnDefs" : [
            {"targets": 0, "render": function(data, type, row) {
            	var contextPath = $("#contextPath").val();
            	var fullName = row.patient.firstName + " " + row.patient.lastName;
            	var markup = "<a href='" + contextPath + "vct/" + row.id + "'>" + fullName + "</a>";
            	
            	return markup;
            }},
            {"targets": 2, "render": function(data, type, row) {
            	return moment.unix(row.patient.birthdate / 1000).format("MMM DD, YYYY");
            }},
            {"targets": 3, "render": function(data, type, row) {
            	return HRMS.toTitleCase(row.patient.sex);
            }},
            {"targets": 4, "sortable": false, "render": function(data, type, row) {
            	var contextPath = $("#contextPath").val();
            	var url = contextPath + "vct/" + row.id + "?mode=edit";
            	
            	return '<td class="text-right">' +
            				'<a href="' + url + '" type="button" class="updateVctBtn btn btn-icon-toggle style-default"><i class="fa fa-pencil"></i></a>' + 
        			   '</td>';
            }}
    	],
        "order": [],
		"language": {
			"lengthMenu": "_MENU_ records per page",
			"search": '<i class="fa fa-search"></i>',
			"paginate": {
				"previous": '<i class="fa fa-angle-left"></i>',
				"next": '<i class="fa fa-angle-right"></i>'
			}
		},
		// ====================================================================
		// ====================================================================
		// @TODO: make a decent spinner
		// ====================================================================
		// ====================================================================
		"fnPreDrawCallback": function() { 
            $(".btn-loading-state").button("loading").prop("disabled", true);
            return true;
        },
        "fnDrawCallback": function() {
        	$(".btn-loading-state").button("reset").prop("disabled", false);
        }
	});
}