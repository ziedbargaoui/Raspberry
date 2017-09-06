$(document).ready(function() {
	$('#getTemperature').click(function() {
		$.ajax({
			url : 'Heat',
			success : function(responseText) {
				$('#ajaxHeatResponse').text(responseText);
			}
		});
	});
});