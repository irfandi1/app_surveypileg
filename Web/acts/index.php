<?php
session_start();
require '../config/function.php';

if (!isset($_SESSION["login"]) || $_SESSION["login"] != true) {
    echo "<script> window.location.href='../index.php'; </script>";
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Survey Pileg</title>

    <!-- Fontfaces CSS-->
    <link href="../assets/css/font-face.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="../assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="../assets/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="../assets/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">


    <!-- Main CSS-->
    <link href="../assets/css/theme.css" rel="stylesheet" media="all">

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC1H72Fojan6yCxKf5DhNXD1Er4Y60ngWU"></script>

<script type="text/javascript">
var customIcons = {

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
downloadUrl("http://localhost/survey_pileg/config/getmarkers.php", function(data) {
    var xml = data.responseXML;
    var markers = xml.documentElement.getElementsByTagName("marker");
    for (var i = 0; i < markers.length; i++) {
        
        var id_responden = markers[i].getAttribute("id_responden");
        var nama_responden = markers[i].getAttribute("nama_responden");
        var alamat = markers[i].getAttribute("alamat");
        var lat = markers[i].getAttribute("lat");
        var lng = markers[i].getAttribute("lang");
        var pertanyaan_29 = markers[i].getAttribute("pertanyaan_29");
        var pertanyaan_39 = markers[i].getAttribute("pertanyaan_39");
        var waktu = markers[i].getAttribute("waktu");

        //#429ADB biru

        var point = new google.maps.LatLng(
            parseFloat(lat),
            parseFloat(lng)
        );
        var html = "<a target='blank' href='responden/"+ id_responden +"'><b>" +nama_responden+ " #" +pertanyaan_29+ "</b><br/><br/>" +pertanyaan_39+ "</b><br/><br/><b>" + alamat + "</b><br/><div align='left'>"+waktu+" </a></div>";
        var icon = customIcons;
        var icon = customIcons;
        var marker = new google.maps.Marker({
            map: map,
            position: point,
            icon: 'http://localhost/survey_pileg/images/markers/'+pertanyaan_29+'.png',
            shadow: customIcons.shadow
        });
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

</head>

<body onload="load()">
    <div class="page-wrapper">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop3 d-none d-lg-block">
            <div class="section__content section__content--p35">
                <div class="header3-wrap">
                    <div class="header__logo">
                        <a href="#">
                            <img src="../images/icon/logo-white.png" alt="CoolAdmin" />
                        </a>
                    </div>
                    <div class="header__navbar">
                        <ul class="list-unstyled">
                            <li >
                                <a href="index.php?acts=beranda">
                                    <i class="fas fa-home"></i>Beranda
                                    <span class="bot-line"></span>
                                </a>
                            </li>
                            <li class="has-sub">
                                <a href="#">
                                    <i class="fas fa-chart-bar"></i>
                                    <span class="bot-line"></span>Grafik Pileg</a>
                                <ul class="header3-sub-list list-unstyled">
                                    <li>
                                        <a href="index.php?acts=grafikkeseluruhan">Keseluruhan</a>
                                    </li>
                                    <li>
                                        <a href="index.php?acts=grafikkabkota">Kabkota</a>
                                    </li>
                                    <li>
                                        <a href="index.php?acts=grafikkecamatan">Kecamatan</a>
                                    </li>
                                    <li>
                                        <a href="index.php?acts=grafikkel_desa">Kel/Desa</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="has-sub">
                                <a href="#">
                                    <i class="fas fa-chart-bar"></i>
                                    <span class="bot-line"></span>Grafik Pilpres</a>
                                <ul class="header3-sub-list list-unstyled">
                                    <li>
                                        <a href="index.php?acts=grafikpilpreskeseluruhan">Keseluruhan</a>
                                    </li>
                                    <li>
                                        <a href="index.php?acts=grafikpilpreskabkota">Kabkota</a>
                                    </li>
                                    <li>
                                        <a href="index.php?acts=grafikpilpreskecamatan">Kecamatan</a>
                                    </li>
                                    <li>
                                        <a href="index.php?acts=grafikpilpreskel_desa">Kel/Desa</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="index.php?acts=surveyor">
                                    <i class="zmdi zmdi-account"></i>
                                    <span class="bot-line"></span>Surveyor
                                </a>
                            </li>
                            <li>
                                <a href="index.php?acts=responden">
                                    <i class="fas fa-fas fa-copy"></i>
                                    <span class="bot-line"></span>Responden</a>
                            </li>
                        </ul>
                    </div>
                    <div class="header__tool">
                        <div class="account-wrap">
                            <div class="account-item account-item--style2 clearfix js-item-menu">
                                <div class="image">
                                    <!-- <img src="../images/icon/avatar-01.jpg" alt="John Doe" /> -->
                                </div>
                                <div class="content">
                                    <a class="js-acc-btn" href="#"><?= $_SESSION["username"];?></a>
                                </div>
                                <div class="account-dropdown js-dropdown">
                                    <div class="account-dropdown__footer">
                                        <a href="beranda/logout.php">
                                            <i class="zmdi zmdi-power"></i>Logout</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER DESKTOP-->

        <!-- HEADER MOBILE-->
        <header class="header-mobile header-mobile-2 d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="../images/icon/logo-white.png" alt="CoolAdmin" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <a href="index.php?acts=beranda">
                                    <i class="fas fa-home"></i>Beranda
                                    <span class="bot-line"></span>
                                </a>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-chart-bar"></i>Grafik Pileg</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                <li>
                                    <a href="index.php?acts=grafikkeseluruhan">Keseluruhan</a>
                                </li>
                                <li>
                                    <a href="index.php?acts=grafikkabkota">Kabkota</a>
                                </li>
                                <li>
                                    <a href="index.php?acts=grafikkecamatan">Kecamatan</a>
                                </li>
                                <li>
                                    <a href="index.php?acts=grafikkel_desa">Kel/Desa</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="index.php?acts=surveyor">
                                <i class="zmdi zmdi-account"></i>
                                <span class="bot-line"></span>Surveyor
                            </a>
                        </li>
                        <li>
                            <a href="index.php?acts=responden">
                                <i class="fas fa-fas fa-copy"></i>
                                <span class="bot-line"></span>Responden</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="sub-header-mobile-2 d-block d-lg-none">
            <div class="header__tool">
                <div class="account-wrap">
                    <div class="account-item account-item--style2 clearfix js-item-menu">
                        <div class="content">
                            <a class="js-acc-btn" href="#"><?= $_SESSION["username"];?></a>
                        </div>
                        <div class="account-dropdown js-dropdown">
                            <div class="account-dropdown__footer">
                                <a href="beranda/logout.php">
                                    <i class="zmdi zmdi-power"></i>Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END HEADER MOBILE -->

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7">
            <!-- BREADCRUMB-->
            <section class="au-breadcrumb2">
                <div class="container">
                   
                </div>
            </section>
            <!-- END BREADCRUMB-->

            <!-- Konten -->

            <?php 
            $acts = @$_GET['acts'];
            switch ($acts) {

                case 'beranda':
                    include 'beranda/map.php';
                    break;
                
                case 'surveyor':
                    include 'surveyor/index.php';
                    break;

                case 'tambahsurveyor':
                    include 'surveyor/tambah.php';
                    break;

                case 'editsurveyor':
                    include 'surveyor/edit.php';
                    break;    
                
                case 'hapussurveyor':
                    include 'surveyor/hapus.php';
                    break;

                case 'responden':
                    include 'responden/index.php';
                    break;

                case 'tambahresponden':
                    include 'responden/tambah.php';
                    break;

                case 'editresponden':
                    include 'responden/edit.php';
                    break;    
                   
                case 'detailresponden':
                    include 'responden/detail.php';
                    break;    

                case 'hapusresponden':
                    include 'responden/hapus.php';
                    break;    

                case 'grafikkeseluruhan':
                    include 'responden/grafikkeseluruhan.php';
                    break;

                case 'grafikkabkota':
                    include 'responden/grafikkabkota.php';
                    break;   
                
                case 'grafikkabkota1':
                    include 'responden/grafikkabkota1.php';
                    break;  
                    
                case 'grafikkecamatan':
                    include 'responden/grafikkecamatan.php';
                    break; 
                 
                case 'grafikkecamatan1':
                    include 'responden/grafikkecamatan1.php';
                    break;
                
                case 'grafikkel_desa':
                    include 'responden/grafikkel_desa.php';
                    break; 
                 
                case 'grafikkel_desa1':
                    include 'responden/grafikkel_desa1.php';
                    break;  
                
                case 'grafikpilpreskeseluruhan':
                    include 'grafikpilpres/keseluruhan.php';
                    break;  
                
                case 'grafikpilpreskabkota':
                    include 'grafikpilpres/kabkota.php';
                    break; 
                    
                case 'grafikpilpreskabkota1':
                    include 'grafikpilpres/kabkota1.php';
                    break; 
                    
                case 'grafikpilpreskecamatan':
                    include 'grafikpilpres/kecamatan.php';
                    break; 
                    
                case 'grafikpilpreskecamatan1':
                    include 'grafikpilpres/kecamatan1.php';
                    break;   
                    
                case 'grafikpilpreskel_desa':
                    include 'grafikpilpres/kel_desa.php';
                    break; 
                    
                case 'grafikpilpreskel_desa1':
                    include 'grafikpilpres/kel_desa1.php';
                    break; 
                    

                default:
                    include 'beranda/map.php';
                    break;
            }
            ?>


            <!-- End Konten -->
            <!-- COPYRIGHT-->
            <section class="p-t-60 p-b-20">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="copyright">
                                <p>Copyright © 2019 Inkubator.</p>
                                <!-- <p>Copyright © 2019 Inkubator. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p> -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- END COPYRIGHT-->
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="../assets/vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="../assets/vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="../assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="../assets/vendor/slick/slick.min.js">
    </script>
    <script src="../assets/vendor/wow/wow.min.js"></script>
    <script src="../assets/vendor/animsition/animsition.min.js"></script>
    <script src="../assets/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>

    <script src="../assets/vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="../assets/vendor/circle-progress/circle-progress.min.js"></script>
    <script src="../assets/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="../assets/vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="../assets/vendor/select2/select2.min.js">
    </script>

    <script src="../assets/js/canvasjs.min.js"></script>

    <!-- Main JS-->
    <script src="../assets/js/main.js"></script>

</body>

</html>
<!-- end document-->