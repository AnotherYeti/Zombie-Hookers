<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    var myLatlng = new google.maps.LatLng(40.320726,-98.48877);
    var myOptions = {
      zoom: 5,
      center: myLatlng,
      mapTypeId: google.maps.MapTypeId.TERRAIN
    }
    map = new google.maps.Map(document.getElementById("map_canvas"), 
						myOptions);
    addMarker(new google.maps.LatLng(27.698,-98.48877),"mood_overlay.png");
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
  <c:forEach var="point" items="${input}">
  <script type="test/javascript">
	addMarker(new google.maps.LatLng(${input.lat},${input.lon},${input.image});
  </script>
  </c:forEach>
</body>
</html>
