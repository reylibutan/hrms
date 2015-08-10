$(document).ready(function() {
	$('#vctDataTable').DataTable({
		searching: false,
		"order": [],
		"aoColumnDefs": [{
            'bSortable': false,
            'aTargets': [5]
        }],
		"language": {
			"lengthMenu": '_MENU_ records per page',
			"search": '<i class="fa fa-search"></i>',
			"paginate": {
				"previous": '<i class="fa fa-angle-left"></i>',
				"next": '<i class="fa fa-angle-right"></i>'
			}
		}
	});
});