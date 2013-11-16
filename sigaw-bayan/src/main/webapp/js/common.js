function loadBudgetChart() {
	
	var url = "/SigawBayan/opendata/total%3Fapp_id=527a5d935e13db265fc2598d&year=";
	var ytdArray = [2011,2012,2013];
	
	$.each( ytdArray, function( index, value ){	
		$.getJSON(url + value, function (d) {
			$("#"+value+"budget").html(d.data[0].gaa_total);
			if(value == "2013") {
				$("#newapprototal").html(d.data[0].new_appro_total);
			}
		});
	});
}


function loadSAROTotalAmountPerRegion(region) {
	
	var url = "/SigawBayan/opendata/saro%3Fapp_id=527a5d935e13db265fc2598d&year=2013&region=";
	var total_amount = 0;
	$.getJSON(url + region, function (d) {
		$.each(d.data,function(index, value){
			console.log(value.amount);
			
			//total_amount = total_amount + parseInt(value.data.amount);
			//console.log(index+ " : " + total_amount +" = "+ total_amount + " + " + value.data.amount);
		});
		
		
		$("#region"+region+ " .value").html(total_amount);
		
	});
	
}


$(function(){
	
	$('#login-with-fb').click(function(){
		window.location.href = "/SigawBayan/connect/facebook";
	})
	
	
	loadBudgetChart();
	
	loadSAROTotalAmountPerRegion("1");
});