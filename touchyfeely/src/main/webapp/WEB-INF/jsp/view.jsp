<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<!<meta http-equiv="refresh" content="15"/>
<style type="text/css">
  html { height: 100% }
  body { height: 100%; margin: 0px; padding: 0px }
  #map_canvas { height: 100% }
</style>
<title>Weather to Happiness Model</title>
<script type="text/javascript" 
src="http://maps.google.com/maps/api/js?sensor=false"></script>

 <script type="text/javascript">
var map;
var markersArray = [];
 function initialize() {
    var myLatlng = new google.maps.LatLng(40.015,-105.2);
    var myOptions = {
      zoom: 5,
      center: myLatlng,
      mapTypeId: google.maps.MapTypeId.TERRAIN
    }
    map = new google.maps.Map(document.getElementById("map_canvas"), 
						myOptions);
}
function addMarker(where,image) {
	marker = new google.maps.Marker({
		position: where,
		map: map,
		icon: image
	});
	markersArray.push(marker);
  }
</script>
</head>
<body onload="initialize()">
  <div id="map_canvas"></div>
</body>
</html>
