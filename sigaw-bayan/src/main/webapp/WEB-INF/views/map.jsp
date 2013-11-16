<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map-canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCLfYBcvYL3bBIvHqFJIVp22IZsXRcbUQ&sensor=false">
    </script>
    <script type="text/javascript">
      function initialize() {
		var myLatlng = new google.maps.LatLng(14.599512, 120.98422);
		var myLatlng2 = new google.maps.LatLng(14.59950, 120.9840);
		var mapOptions = {
          center: myLatlng,
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
			
		// To add the marker to the map, use the 'map' property
		var marker = new google.maps.Marker({
			position: myLatlng,
			map: map,
			title:"Hello World!"
		});	
		
		var marker2 = new google.maps.Marker({
			position: myLatlng2,
			map: map,
			title:"Hello World2!"
		});	
      }
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
  </head>
  <body>
    <div id="map-canvas"/>
	14.599512,120.98422
  </body>
  
</html>