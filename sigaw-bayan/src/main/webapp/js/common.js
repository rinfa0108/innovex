function loadBudgetChart() {
	
	var url = "/SigawBayan/opendata/total%3Fapp_id=527a5d935e13db265fc2598d&year=";
	var ytdArray = [2011,2012,2013];
	
	$.each( ytdArray, function( index, value ){	
		$.getJSON(url + value, function (d) {
			$("#"+value+"budget").html(d.data[0].gaa_total);
			$("#"+value+"budget").attr('data-amount',parseInt(d.data[0].gaa_total));
			if(value == "2013") {
				$("#newapprototal").html(d.data[0].new_appro_total);
				$("#newapprototal").attr('data-amount',parseInt(d.data[0].new_appro_total));
			}
		});
	});
}


function loadSAROTotalAmountPerRegion(region) {
	var totalbudget = 2005900000;
	var url = "/SigawBayan/opendata/saro%3Fapp_id=527a5d935e13db265fc2598d&year=2013&limit=2000&region=";
	var total_amount = 0;
	$.getJSON(url + region, function (d) {
		$.each(d.data,function(index, value){
			//console.log(value.amount);	
			total_amount = total_amount + parseInt(value.amount);
			//console.log(region+ " : " + total_amount +" = "+ total_amount + " + " + value.amount);
		});
		
		var percent = parseInt((total_amount / totalbudget)) * 100;
		$("#region"+region+ " .value").html(percent+"%");
		$("#region"+region+" .value").css("height",percent+"%");
	});
	
}


$(function(){
	
	
	$('#login-with-fb').click(function(){
		window.location.href = "/SigawBayan/connect/facebook";
	})
	
	
	

	$('#submit-comment').click(function(event){
		event.preventDefault();
		var url = $('#submit-comment').attr('href') + $('#comments').val();
		window.location.href = url;
		
	});
	
	
});