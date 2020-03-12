<?php
$conn = mysqli_connect("localhost","root", "", "survey_pileg");

function query ($query){
    global $conn;
    $result = mysqli_query($conn, $query);
    $rows = [];
    while($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    }
    return $rows;
}

// *********************** Function Surveyor **********************************
// 1. Tambah
function tambahsurveyor ($data) {
    global $conn;
    
    $id_surveyor = $data["id_surveyor"];
    $nama_petugas = $data["nama_petugas"];
    $username = htmlspecialchars(strtolower(stripslashes($data["username"])));
    $password = mysqli_real_escape_string($conn, $data["password"]);
    $jenis_kelamin =  $data["jenis_kelamin"];
    $no_hp =  $data["no_hp"];
    $alamat =  $data["alamat"];
    $created_at = $data["created_at"];
    $created_update = $data["created_update"];

	mysqli_query($conn, "INSERT INTO surveyor VALUES(
        '',
        '$nama_petugas',
        'username',
        '$password',
        '$jenis_kelamin',
        '$no_hp',
        '$alamat',
        CURRENT_TIMESTAMP,
        '')");

	return mysqli_affected_rows($conn);
}


// 2. Edit
function editsurveyor ($data) {

	global $conn;

	$id_surveyor = $data["id"];
    $nama_petugas = $data["nama_petugas"];
    $username = htmlspecialchars(strtolower(stripslashes($data["username"])));
    $jenis_kelamin =  $data["jenis_kelamin"];
    $no_hp =  $data["no_hp"];
    $alamat =  $data["alamat"];

	$query = "UPDATE surveyor SET

		nama_petugas = '$nama_petugas',
		username = '$username', 
		jenis_kelamin = '$jenis_kelamin',
		no_hp = '$no_hp',
        alamat =  '$alamat',
        created_update = CURRENT_TIMESTAMP

		WHERE id_surveyor = $id_surveyor ";

		mysqli_query($conn, $query);
		return mysqli_affected_rows($conn);
}

// 3. hapus
function hapussurveyor ($id) {
	global $conn;

	mysqli_query($conn, "DELETE FROM surveyor WHERE id_surveyor = $id");

	return mysqli_affected_rows($conn);
}
// ************************End Function Surveyor*********************************


// *********************** Function responden **********************************
// 1. Tambah
function tambahresponden ($data) {
    global $conn;
    
    $id_surveyor = $data["id_surveyor"];
    $nama_responden = $data["nama_responden"];
    $alamat = $data["alamat"];
    $provinsi = $data["provinsi"];
    $kab_kota = $data["kab_kota"];
    $kecamatan = $data["kecamatan"];
    $kel_desa = $data["kel_desa"];
    $rt = $data["rt"];
    $rw = $data["rw"];
    $no_hp = $data["no_hp"];
    // $nama_kk = $data["nama_kk"];
    // $no_urut_responden = $data["no_urut_responden"];
    $pertanyaan_12 = $data["pertanyaan_12"];
    $pertanyaan_13 = $data["pertanyaan_13"];
    $pertanyaan_14 = $data["pertanyaan_14"];
    $pertanyaan_15 = $data["pertanyaan_15"];
    $pertanyaan_16 = $data["pertanyaan_16"];
    $pertanyaan_17 = $data["pertanyaan_17"];
    $pertanyaan_18 = $data["pertanyaan_18"];
    $pertanyaan_19 = $data["pertanyaan_19"];
    $pertanyaan_20 = $data["pertanyaan_20"];
    $pertanyaan_21 = $data["pertanyaan_21"];
    $pertanyaan_22 = $data["pertanyaan_22"];
    $pertanyaan_23 = $data["pertanyaan_23"];
    $pertanyaan_24 = $data["pertanyaan_24"];
    $pertanyaan_25 = $data["pertanyaan_25"];
    $pertanyaan_26 = $data["pertanyaan_26"];
    $pertanyaan_27 = $data["pertanyaan_27"];
    $pertanyaan_28 = $data["pertanyaan_28"];
    $pertanyaan_29 = $data["pertanyaan_29"];
    $pertanyaan_30 = $data["pertanyaan_30"];
    $pertanyaan_31 = $data["pertanyaan_31"];
    $pertanyaan_32 = $data["pertanyaan_32"];
    $pertanyaan_33 = $data["pertanyaan_33"];
    $pertanyaan_34 = $data["pertanyaan_34"];
    $pertanyaan_35 = $data["pertanyaan_35"];
    $pertanyaan_36 = $data["pertanyaan_36"];
    $pertanyaan_37 = $data["pertanyaan_37"];
    $pertanyaan_38 = $data["pertanyaan_38"];
    $pertanyaan_39 = $data["pertanyaan_39"];
    $pertanyaan_40 = $data["pertanyaan_40"];
    // $pertanyaan_41 = $data["pertanyaan_41"];
    // $pertanyaan_42 = $data["pertanyaan_42"];
    // $pertanyaan_43 = $data["pertanyaan_43"];
    // $pertanyaan_44 = $data["pertanyaan_44"];
    // $pertanyaan_45 = $data["pertanyaan_45"];
    // $pertanyaan_46 = $data["pertanyaan_46"];
    // $pertanyaan_47 = $data["pertanyaan_47"];
    // $pertanyaan_48 = $data["pertanyaan_48"];
    // $pertanyaan_49 = $data["pertanyaan_49"];
    // $pertanyaan_50 = $data["pertanyaan_50"];
    // $pertanyaan_51 = $data["pertanyaan_51"];
    // $pertanyaan_52 = $data["pertanyaan_52"];
    // $pertanyaan_53 = $data["pertanyaan_53"];
    // $pertanyaan_54 = $data["pertanyaan_54"];
    // $pertanyaan_55 = $data["pertanyaan_55"];
    $lat = $data["lat"];
    $lang = $data["lang"];
    $create_at = $data["create_at"];

	mysqli_query($conn, "INSERT INTO responden VALUES('','$id_surveyor', '$nama_responden', '$alamat', '$provinsi', '$kab_kota', '$kecamatan', '$kel_desa', '$rt', '$rw', '$no_hp', '$pertanyaan_12', '$pertanyaan_13', '$pertanyaan_14', '$pertanyaan_15', '$pertanyaan_16', '$pertanyaan_17', '$pertanyaan_18', '$pertanyaan_19', '$pertanyaan_20', '$pertanyaan_21', '$pertanyaan_22', '$pertanyaan_23', '$pertanyaan_24', '$pertanyaan_25', '$pertanyaan_26', '$pertanyaan_27', '$pertanyaan_28', '$pertanyaan_29', '$pertanyaan_30', '$pertanyaan_31', '$pertanyaan_32', '$pertanyaan_33', '$pertanyaan_34', '$pertanyaan_35', '$pertanyaan_36', '$pertanyaan_37', '$pertanyaan_38', '$pertanyaan_39', '$pertanyaan_40', '$lat', '$lang', CURRENT_TIMESTAMP)");

    
	return mysqli_affected_rows($conn);
}
// 2. Edit
function editresponden ($data) {
    global $conn;
    
    $id_responden = $data["id"];
    $id_surveyor = $data["id_surveyor"];
    $nama_responden = $data["nama_responden"];
    $alamat = $data["alamat"];
    $provinsi = $data["provinsi"];
    $kab_kota = $data["kab_kota"];
    $kecamatan = $data["kecamatan"];
    $kel_desa = $data["kel_desa"];
    $rt = $data["rt"];
    $rw = $data["rw"];
    $no_hp = $data["no_hp"];
    // $nama_kk = $data["nama_kk"];
    // $no_urut_responden = $data["no_urut_responden"];
    $pertanyaan_12 = $data["pertanyaan_12"];
    $pertanyaan_13 = $data["pertanyaan_13"];
    $pertanyaan_14 = $data["pertanyaan_14"];
    $pertanyaan_15 = $data["pertanyaan_15"];
    $pertanyaan_16 = $data["pertanyaan_16"];
    $pertanyaan_17 = $data["pertanyaan_17"];
    $pertanyaan_18 = $data["pertanyaan_18"];
    $pertanyaan_19 = $data["pertanyaan_19"];
    $pertanyaan_20 = $data["pertanyaan_20"];
    $pertanyaan_21 = $data["pertanyaan_21"];
    $pertanyaan_22 = $data["pertanyaan_22"];
    $pertanyaan_23 = $data["pertanyaan_23"];
    $pertanyaan_24 = $data["pertanyaan_24"];
    $pertanyaan_25 = $data["pertanyaan_25"];
    $pertanyaan_26 = $data["pertanyaan_26"];
    $pertanyaan_27 = $data["pertanyaan_27"];
    $pertanyaan_28 = $data["pertanyaan_28"];
    $pertanyaan_29 = $data["pertanyaan_29"];
    $pertanyaan_30 = $data["pertanyaan_30"];
    $pertanyaan_31 = $data["pertanyaan_31"];
    $pertanyaan_32 = $data["pertanyaan_32"];
    $pertanyaan_33 = $data["pertanyaan_33"];
    $pertanyaan_34 = $data["pertanyaan_34"];
    $pertanyaan_35 = $data["pertanyaan_35"];
    $pertanyaan_36 = $data["pertanyaan_36"];
    $pertanyaan_37 = $data["pertanyaan_37"];
    $pertanyaan_38 = $data["pertanyaan_38"];
    $pertanyaan_39 = $data["pertanyaan_39"];
    $pertanyaan_40 = $data["pertanyaan_40"];
    // $pertanyaan_41 = $data["pertanyaan_41"];
    // $pertanyaan_42 = $data["pertanyaan_42"];
    // $pertanyaan_43 = $data["pertanyaan_43"];
    // $pertanyaan_44 = $data["pertanyaan_44"];
    // $pertanyaan_45 = $data["pertanyaan_45"];
    // $pertanyaan_46 = $data["pertanyaan_46"];
    // $pertanyaan_47 = $data["pertanyaan_47"];
    // $pertanyaan_48 = $data["pertanyaan_48"];
    // $pertanyaan_49 = $data["pertanyaan_49"];
    // $pertanyaan_50 = $data["pertanyaan_50"];
    // $pertanyaan_51 = $data["pertanyaan_51"];
    // $pertanyaan_52 = $data["pertanyaan_52"];
    // $pertanyaan_53 = $data["pertanyaan_53"];
    // $pertanyaan_54 = $data["pertanyaan_54"];
    // $pertanyaan_55 = $data["pertanyaan_55"];
    $lat = $data["lat"];
    $lang = $data["lang"];

    $query = "UPDATE responden SET

    id_surveyor = '$id_surveyor',
    nama_responden = '$nama_responden',
    alamat ='$alamat',
    provinsi = '$provinsi',
    kab_kota = '$kab_kota',
    kecamatan = '$kecamatan',
    kel_desa = '$kel_desa',
    rt = '$rt',
    rw = '$rw',
    no_hp = '$no_hp',
    -- nama_kk = '$nama_kk',
    -- no_urut_responden = '$no_urut_responden',
    pertanyaan_12 = '$pertanyaan_12',
    pertanyaan_13 = '$pertanyaan_13',
    pertanyaan_14 = '$pertanyaan_14',
    pertanyaan_15 = '$pertanyaan_15',
    pertanyaan_16 = '$pertanyaan_16',
    pertanyaan_17 = '$pertanyaan_17',
    pertanyaan_18 = '$pertanyaan_18',
    pertanyaan_19 = '$pertanyaan_19',
    pertanyaan_20 = '$pertanyaan_20',
    pertanyaan_21 = '$pertanyaan_21',
    pertanyaan_22 = '$pertanyaan_22',
    pertanyaan_23 = '$pertanyaan_23',
    pertanyaan_24 = '$pertanyaan_24',
    pertanyaan_25 = '$pertanyaan_25',
    pertanyaan_26 = '$pertanyaan_26',
    pertanyaan_27 = '$pertanyaan_27',
    pertanyaan_28 = '$pertanyaan_28',
    pertanyaan_29 = '$pertanyaan_29',
    pertanyaan_30 = '$pertanyaan_30',
    pertanyaan_31 = '$pertanyaan_31',
    pertanyaan_32 = '$pertanyaan_32',
    pertanyaan_33 = '$pertanyaan_33',
    pertanyaan_34 = '$pertanyaan_34',
    pertanyaan_35 = '$pertanyaan_35',
    pertanyaan_36 = '$pertanyaan_36',
    pertanyaan_37 = '$pertanyaan_37',
    pertanyaan_38 = '$pertanyaan_38',
    pertanyaan_39 = '$pertanyaan_39',
    pertanyaan_40 = '$pertanyaan_40',
    -- pertanyaan_41 = '$pertanyaan_41',
    -- pertanyaan_42 = '$pertanyaan_42',
    -- pertanyaan_43 = '$pertanyaan_43',
    -- pertanyaan_44 = '$pertanyaan_44',
    -- pertanyaan_45 = '$pertanyaan_45',
    -- pertanyaan_46 = '$pertanyaan_46',
    -- pertanyaan_47 = '$pertanyaan_47',
    -- pertanyaan_48 = '$pertanyaan_48',
    -- pertanyaan_49 = '$pertanyaan_49',
    -- pertanyaan_50 = '$pertanyaan_50',
    -- pertanyaan_51 = '$pertanyaan_51',
    -- pertanyaan_52 = '$pertanyaan_52',
    -- pertanyaan_53 = '$pertanyaan_53',
    -- pertanyaan_54 = '$pertanyaan_54',
    -- pertanyaan_55 = '$pertanyaan_55',
    lat = '$lat',
    lang = '$lang'

		WHERE id_responden = $id_responden ";

		mysqli_query($conn, $query);
		return mysqli_affected_rows($conn);
}


// 3. hapus
function hapusresponden ($id) {
	global $conn;

	mysqli_query($conn, "DELETE FROM responden WHERE id_responden = $id");

	return mysqli_affected_rows($conn);
}

// ************************End Function responden*********************************


// ************************ Function grafik kabkota*********************************
function grafikkabkota ($data) {
    
}

// ************************ Function grafik kabkota*********************************



?>