<?php
    include('function.php');
    $sql = "SELECT * FROM tb_kabkota";
    $query = $conn->query($sql);
    $data = array();
    while($row = $query->fetch_array(MYSQLI_ASSOC)){
        $data[] = array("id_kabkota" => $row['id_kabkota'], "nama" => $row['nama']);
    }
    echo json_encode($data);
?>