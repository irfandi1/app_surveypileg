<?php
include('function.php');
    $id_kabkota = $_GET['id_kabkota'];
    $sql = "SELECT * FROM tb_kecamatan WHERE `id_kabkota` = '$id_kabkota'";
    $query = $conn->query($sql);
    $data = array();
    while($row = $query->fetch_array(MYSQLI_ASSOC)){
    $data[] = array("id_kecamatan" => $row['id_kecamatan'], "nama" => $row['nama']);
    }
    echo json_encode($data);
?>