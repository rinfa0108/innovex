var geocoder;
var map;

function initializeMap() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(14, 121.644);
  var mapOptions = {
    zoom: 6,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  }
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  geocoder.geocode( { 'address': 'Philippines'}, function(results, status) {
	map.setCenter(results[0].geometry.location);
  });
  
  plotRegion();
  
}

function plotRegion() {
	var url = "/SigawBayan/opendata/getFewProjectsPerRegion";

	var uniqueRegions = {};
	var param = "region";
	var location;
	var infoWindow = new google.maps.InfoWindow({
			maxWidth:250
		});
	
	$.getJSON(url, function (data) {

		$.each(data, function (index, value) {
			
			
			//location = "Region " + value.region + ", Philippines";
/*			
				geocoder.geocode( { 'address': location}, function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							var lat = results[0].geometry.location.ob + (Math.random() * 0.2);
							var lng = results[0].geometry.location.pb + (Math.random() * 0.1);
							var latLng = new google.maps.LatLng(lat,lng);
							var marker = new google.maps.Marker({
								map: map,
								position: latLng,
								title: value.decription
							});
							console.log("Res: " + value.region + " lat:" + lat + " long" + lng);
							bindDataInfo(marker, infoWindow, value);
						} else {
							//alert('Geocode was not successful for the following reason: ' + status);
							console.log('Geocode was not successful for the following reason: ' + status);
						}
				});*/
			
			if (!uniqueRegions[this[param]]) {
				uniqueRegions[this[param]] = [];	
				uniqueRegions[this[param]].push(this);
				console.log(this[param]);
				location = "Region " + this[param] + ", Philippines";
				geocoder.geocode( { 'address': location}, function(results, status) {
					if (status == google.maps.GeocoderStatus.OK) {
						var marker = new google.maps.Marker({
							map: map,
							position: results[0].geometry.location
						});
						console.log(results[0].geometry.location);
						bindDataInfo(marker, infoWindow, value);
					} else {
						console.log('Geocode was not successful for the following reason: ' + status);
					}
				});
			}
		});
	});

}

function bindDataInfo(marker, infoWindow, data){

	var dataInfo = $('#data-info-container');

	google.maps.event.addListener(marker, 'click', function() {
		dataInfo.find('#regionNo').text(data.region);
        infoWindow.setContent(dataInfo.html());
        infoWindow.open(map, marker);
    });

}

$(function(){

	initializeMap();

});