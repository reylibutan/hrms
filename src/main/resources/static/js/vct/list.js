var oVctDataTable = null;

$(document).ready(function() {
	oVctDataTable = $("#vctDataTable").dataTable({
		"searching": false,
		"processing": false,
		"serverSide": true,
		"ajax": {
            "url": "search",
            "data": function (d) {
                d.codeName = $("#codeName").val();
                d.sacclCode = $("#sacclCode").val();
                d.firstName = $("#firstName").val();
                d.lastName = $("#lastName").val();
            }
        },
        "aoColumns": [
          	{"mData": "fullName"},
          	{"mData": "patientDTO.uniqueIdCode"},
			{"mData": "patientDTO.birthdate"},
			{"mData": "patientDTO.sex"},
			{"mData": null},
        ],
		"columnDefs" : [
            {"targets": 0, "render": function(data, type, row) {
            	var contextPath = $("#contextPath").val();
            	var fullName = row.patientDTO.firstName + " " + row.patientDTO.lastName;
            	var markup = "<a href='" + contextPath + "vct/" + row.id + "'>" + fullName + "</a>";
            	
            	return markup;
            }},
            {"targets": 2, "render": function(data, type, row) {
            	return moment.unix(row.patientDTO.birthdate / 1000).format("MMM DD, YYYY");
            }},
            {"targets": 3, "render": function(data, type, row) {
            	return HRMS.toTitleCase(row.patientDTO.sex);
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
            $("#searchBtn").button("loading").prop("disabled", true);
            $("#addVctBtn").button("loading").prop("disabled", true);
            return true;
        },
        "fnDrawCallback": function() {
        	$("#searchBtn").button("reset").prop("disabled", false);
        	$("#addVctBtn").button("reset").prop("disabled", false);
        }
	})
	
	$("#searchBtn").click(function() {
		oVctDataTable.fnDraw();
	});
});