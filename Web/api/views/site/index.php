<?php

/* @var $this yii\web\View */

$this->title = 'My Yii Application';
?>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC1H72Fojan6yCxKf5DhNXD1Er4Y60ngWU"></script>
 
 <style>
 h1 {text-align:center;}
           html, body {
                }
           #map {
                width: 100%;
                height: 540px;
                border: 0px solid black;
           }
 </style>
 <script type="text/javascript">
 
 var customIcons = {
 
   // icon di sini di non aktifkan karna, icon di definisikan di method load() agar mengikuti kategori
   // icon: '<?php echo Yii::$app->request->baseUrl;?>/files/markers/'+id_+'.png',
   shadow: 'http://labs.google.com/ridefinder/images/mm_20_shadow.png'
 };
 
 function load() {
 var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat : 0.498498, lng : 101.403993},
          zoom: 14,
          styles: [
            {elementType: 'geometry', stylers: [{color: '#242f3e'}]},
            {elementType: 'labels.text.stroke', stylers: [{color: '#242f3e'}]},
            {elementType: 'labels.text.fill', stylers: [{color: '#746855'}]},
            {
              featureType: 'administrative.locality',
              elementType: 'labels.text.fill',
              stylers: [{color: '#d59563'}]
            },
            {
              featureType: 'poi',
              elementType: 'labels.text.fill',
              stylers: [{color: '#d59563'}]
            },
            {
              featureType: 'poi.park',
              elementType: 'geometry',
              stylers: [{color: '#263c3f'}]
            },
            {
              featureType: 'poi.park',
              elementType: 'labels.text.fill',
              stylers: [{color: '#6b9a76'}]
            },
            {
              featureType: 'road',
              elementType: 'geometry',
              stylers: [{color: '#38414e'}]
            },
            {
              featureType: 'road',
              elementType: 'geometry.stroke',
              stylers: [{color: '#212a37'}]
            },
            {
              featureType: 'road',
              elementType: 'labels.text.fill',
              stylers: [{color: '#9ca5b3'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'geometry',
              stylers: [{color: '#746855'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'geometry.stroke',
              stylers: [{color: '#1f2835'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'labels.text.fill',
              stylers: [{color: '#f3d19c'}]
            },
            {
              featureType: 'transit',
              elementType: 'geometry',
              stylers: [{color: '#2f3948'}]
            },
            {
              featureType: 'transit.station',
              elementType: 'labels.text.fill',
              stylers: [{color: '#d59563'}]
            },
            {
              featureType: 'water',
              elementType: 'geometry',
              stylers: [{color: '#17263c'}]
            },
            {
              featureType: 'water',
              elementType: 'labels.text.fill',
              stylers: [{color: '#515c6d'}]
            },
            {
              featureType: 'water',
              elementType: 'labels.text.stroke',
              stylers: [{color: '#17263c'}]
            }
          ]
        });
 var infoWindow = new google.maps.InfoWindow;
 
 // Bagian ini digunakan untuk mendapatkan data format XML yang dibentuk dalam actionDataLokasi
 downloadUrl("<?php echo Yii::$app->request->baseUrl;?>/../api/v1/responden/get-all-markers", function(data) {
   var xml = data.responseXML;
   var markers = xml.documentElement.getElementsByTagName("marker");
   for (var i = 0; i < markers.length; i++) {

 
   var id_responden = markers[i].getAttribute("id_responden");
   var nama_responden = markers[i].getAttribute("nama_responden");
   var alamat = markers[i].getAttribute("alamat");
   var provinsi = markers[i].getAttribute("provinsi");
   var kab_kota = markers[i].getAttribute("kab_kota");
   var kecamatan = markers[i].getAttribute("kecamatan");
   var kel_desa = markers[i].getAttribute("kel_desa");
   var lat = markers[i].getAttribute("lat");
   var lng = markers[i].getAttribute("lang");
   var ket = markers[i].getAttribute("ket");
   var pertanyaan_38 = markers[i].getAttribute("pertanyaan_38");
   var waktu = markers[i].getAttribute("waktu");
   
       //#429ADB biru
 
     var point = new google.maps.LatLng(
         parseFloat(lat),
         parseFloat(lng)
         );

         
     var html = "<a target='blank' href='responden/"+ id_responden +"'><b>" +nama_responden+" #" +pertanyaan_38+ "</b><br/><br/><b>" + alamat + "</b><br/><div align='left'>"+waktu+" </a></div>";
     var icon = customIcons;
     var marker = new google.maps.Marker({
       map: map,
       position: point,
       icon: '<?php echo Yii::$app->request->baseUrl;?>/files/markers/'+pertanyaan_38+'.png',
       shadow: customIcons.shadow
     });
     console.log("menampilkan "+lat+", "+lng+"; icon : "+icon);
     bindInfoWindow(marker, map, infoWindow, html);
   }
 });
 }
 
 function bindInfoWindow(marker, map, infoWindow, html) {
 google.maps.event.addListener(marker, 'click', function() {
   infoWindow.setContent(html);
   infoWindow.open(map, marker);
 });
 }
 
 function downloadUrl(url, callback) {
 var request = window.ActiveXObject ?
     new ActiveXObject('Microsoft.XMLHTTP') :
     new XMLHttpRequest;
 
 request.onreadystatechange = function() {
   if (request.readyState == 4) {
     request.onreadystatechange = doNothing;
     callback(request, request.status);
   }
 };
 
 request.open('GET', url, true);
 request.send(null);
 }
 
 function doNothing() {}
 
 </script>


<div class="site-index">

    <div class="body-content">

        <div class="row">
            <div class="col-md-12">
                <h2>Peta Laporan</h2>

<body onload="load()">
<div id="map"></div>
</body>
                <p><a class="btn btn-default" href="http://www.yiiframework.com/doc/">Yii Documentation &raquo;</a></p>
            </div>

        </div>

    </div>
</div>
