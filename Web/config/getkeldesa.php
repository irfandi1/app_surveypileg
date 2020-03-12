<?php
include('function.php');
    $id_kecamatan = $_GET['id_kecamatan'];
    $sql = "SELECT * FROM tb_kelurahan WHERE `id_kec` = '$id_kecamatan'";
    $query = $conn->query($sql);
   
    $data = array();
    while($row = $query->fetch_array(MYSQLI_ASSOC)){

    $data[] = array("id_kelurahan" => $row['id_kelurahan'], "nama" => $row['nama']);
    }
    echo json_encode($data);
?>