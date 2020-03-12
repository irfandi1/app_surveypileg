<?php
$id_responden = $_GET["id"];
$data = query ("SELECT * FROM responden WHERE id_responden=$id_responden")[0];

// var_dump($data);
// exit;

$nama_petugas = query("SELECT * FROM surveyor");


if ( isset($_POST["save"]) ) {

  if ( editresponden ($_POST) > 0 ) {
    echo "
    <script>
            alert('Data berhasil diubah!');
            document.location.href='index.php?acts=responden';
            </script>
            ";
  } else {
    echo "
    <script>
            alert('Data Gagal diubah!');
            document.location.href='index.php?acts=responden';
            </script>
            ";
          }
  }
?>

<div class="login-content">
    <div class="card">
        <div class="card-header">
            <strong>Edit Responden</strong>
        </div>
        <div class="card-body card-block">
            <form action="" method="post">
                <input type="hidden" value="<?= $data["id_responden"]; ?>" name="id" > 
                <div class="form-group">
                    <label for="id_surveyor" class=" form-control-label">nama_petugas</label>
                    <select name="id_surveyor"  id="">
                    <?php
                        foreach ($nama_petugas as $namapetugas):
                    ?>
                        <option value="<?= $namapetugas["id_surveyor"]; ?>"> <?= $namapetugas["nama_petugas"]; ?> </option>
                    <?php
                        endforeach
                    ?>
                    </select>
                </div>
                <div class="form-group">
                    <label for="nama_responden" class=" form-control-label">nama_responden</label>
                    <input type="text" id="nama_responden" name="nama_responden" value="<?= $data["nama_responden"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="row form-group">
                    <div class="col-8">
                        <div class="form-group">
                            <label for="alamat" class=" form-control-label">alamat</label>
                            <input type="text" id="alamat" name="alamat" value="<?= $data["alamat"]; ?>" placeholder="" class="form-control">
                        </div>
                    </div>
                    <div class="col-8">
                        <div class="form-group">
                            <label for="provinsi" class=" form-control-label">provinsi</label>
                            <input type="text" id="provinsi" name="provinsi" value="<?= $data["provinsi"]; ?>" placeholder="" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="kab_kota" class=" form-control-label">kab_kota</label>
                    <input type="text" id="kab_kota" name="kab_kota" value="<?= $data["kab_kota"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="kecamatan" class=" form-control-label">kecamatan</label>
                    <input type="text" id="kecamatan" name="kecamatan" value="<?= $data["kecamatan"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="kel_desa" class=" form-control-label">kel_desa</label>
                    <input type="text" id="kel_desa" name="kel_desa" value="<?= $data["kel_desa"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="rt" class=" form-control-label">rt</label>
                    <input type="text" id="rt" name="rt" value="<?= $data["rt"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="rw" class=" form-control-label">rw</label>
                    <input type="text" id="rw" name="rw" value="<?= $data["rw"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="no_hp" class=" form-control-label">no_hp</label>
                    <input type="text" id="no_hp" name="no_hp" value="<?= $data["no_hp"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_12" class=" form-control-label">Apakah Bpk/Ibu/Sdr sudah terdaftar di DPT untuk Pemilu bulan April 2019?</label>
                    <input type="text" id="pertanyaan_12" name="pertanyaan_12" value="<?= $data["pertanyaan_12"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_13" class=" form-control-label">Apakah Bpk/Ibu/Sdr akan gunakan hak pilih pada pemilu April 2019?</label>
                    <input type="text" id="pertanyaan_13" name="pertanyaan_13" value="<?= $data["pertanyaan_13"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_14" class=" form-control-label">Jenis kelamin :</label>
                    <input type="text" id="pertanyaan_14" name="pertanyaan_14" value="<?= $data["pertanyaan_14"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_15" class=" form-control-label">Usia :</label>
                    <input type="text" id="pertanyaan_15" name="pertanyaan_15" value="<?= $data["pertanyaan_15"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_16" class=" form-control-label">Agama:</label>
                    <input type="text" id="pertanyaan_16" name="pertanyaan_16" value="<?= $data["pertanyaan_16"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_17" class=" form-control-label">Bila Islam, apakah Bpk/Ibu/Sdr shalat 5 waktu ?</label>
                    <input type="text" id="pertanyaan_17" name="pertanyaan_17" value="<?= $data["pertanyaan_17"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_18" class=" form-control-label">Apakah Bpk/Ibu/Sdr suka mengikuti pengajian rutin ?</label>
                    <input type="text" id="pertanyaan_18" name="pertanyaan_18" value="<?= $data["pertanyaan_18"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_19" class=" form-control-label">Pendidikan :</label>
                    <input type="text" id="pertanyaan_19" name="pertanyaan_19" value="<?= $data["pertanyaan_19"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_20" class=" form-control-label">Suku :</label>
                    <input type="text" id="pertanyaan_20" name="pertanyaan_20" value="<?= $data["pertanyaan_20"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_21" class=" form-control-label">Pekerjaan utama :</label>
                    <input type="text" id="pertanyaan_21" name="pertanyaan_21" value="<?= $data["pertanyaan_21"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_22" class=" form-control-label">Ketokohan di masyarakat :</label>
                    <input type="text" id="pertanyaan_22" name="pertanyaan_22" value="<?= $data["pertanyaan_22"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_23" class=" form-control-label">Berapa Pendapatan Bpk/Ibu/Sdr sebulan ?</label>
                    <input type="text" id="pertanyaan_23" name="pertanyaan_23" value="<?= $data["pertanyaan_23"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_24" class=" form-control-label">Dari mana saja Bpk/Ibu/Sdr mendapatkan informasi politik dan seputar Pemilu ?</label>
                    <input type="text" id="pertanyaan_24" name="pertanyaan_24" value="<?= $data["pertanyaan_24"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_25" class=" form-control-label">Jumlah partai peserta pemilu 2019 ada 16 partai. Partai apa saja yang paling Bpk/Ibu/Sdr kenal?</label>
                    <input type="text" id="pertanyaan_25" name="pertanyaan_25" value="<?= $data["pertanyaan_25"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_26" class=" form-control-label">Apakah Bpk/Ibu/Sdr mengenal lambang partai ini ?</label>
                    <input type="text" id="pertanyaan_26" name="pertanyaan_26" value="<?= $data["pertanyaan_26"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_27" class=" form-control-label">Dari partai peserta pemilu yang Bpk/Ibu/Sdr ingat, sebutkan 3 partai yang di suka ?</label>
                    <input type="text" id="pertanyaan_27" name="pertanyaan_27" value="<?= $data["pertanyaan_27"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_28" class=" form-control-label">Partai apa yang pada Pemilu lalu Bpk/Ibu/Sdr pilih ?</label>
                    <input type="text" id="pertanyaan_28" name="pertanyaan_28" value="<?= $data["pertanyaan_28"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_29" class=" form-control-label">Partai apa pada pemilu yang akan datang dipertimbangkan untuk Bpk/Ibu/Sdr pilih ?</label>
                    <input type="text" id="pertanyaan_29" name="pertanyaan_29" value="<?= $data["pertanyaan_29"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_30" class=" form-control-label">Apa alasannya ?</label>
                    <input type="text" id="pertanyaan_30" name="pertanyaan_30" value="<?= $data["pertanyaan_30"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_31" class=" form-control-label">Apakah Bpk/Ibu/Sdr sudah tahu/kenal dengan orang-orang ini ?</label>
                    <input type="text" id="pertanyaan_31" name="pertanyaan_31" value="<?= $data["pertanyaan_31"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_32" class=" form-control-label">Melalui apa Bpk/Ibu/Sdr mengenalnya ?</label>
                    <input type="text" id="pertanyaan_32" name="pertanyaan_32" value="<?= $data["pertanyaan_32"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_33" class=" form-control-label">Bila diadakah pemilihan saat ini, Bpk/Ibu/Sdr akan memilih siapa ?</label>
                    <input type="text" id="pertanyaan_33" name="pertanyaan_33" value="<?= $data["pertanyaan_33"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_34" class=" form-control-label">Permasalahan apa yang paling menarik perhatian Bpk/Ibu/Sdr di tingkat provinsi & kabupaten/kota ?</label>
                    <input type="text" id="pertanyaan_34" name="pertanyaan_34" value="<?= $data["pertanyaan_34"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_35" class=" form-control-label">Permasalahan atau isu apa yang paling menarik perhatian Bpk/Ibu/Sdr di tingkat RT tempat Bpk/Ibu/Sdr tinggal ?</label>
                    <input type="text" id="pertanyaan_35" name="pertanyaan_35" value="<?= $data["pertanyaan_35"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_36" class=" form-control-label">Apa alasan Bpk/Ibu/Sdr memilih Figur Caleg yang disukai</label>
                    <input type="text" id="pertanyaan_36" name="pertanyaan_36" value="<?= $data["pertanyaan_36"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_37" class=" form-control-label">Bentuk pendekatan atau kampanye bagaimana yang Bpk/Ibu/Sdr sukai dari para Caleg ?</label>
                    <input type="text" id="pertanyaan_37" name="pertanyaan_37" value="<?= $data["pertanyaan_37"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_38" class=" form-control-label">Bagaimana penilaian Bpk/Ibu/Sdr terhadap kinerja Presiden Jokowi – JK hingga saat ini ?</label>
                    <input type="text" id="pertanyaan_38" name="pertanyaan_38" value="<?= $data["pertanyaan_38"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_39" class=" form-control-label">Siapa yang akan Bpk/Ibu/Sdr pilih dalam Pilpres yang akan datang ?</label>
                    <input type="text" id="pertanyaan_39" name="pertanyaan_39" value="<?= $data["pertanyaan_39"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pertanyaan_40" class=" form-control-label">Apa alasan Bpk/Ibu/Sdr dalam menentukan pilihan tersebut ?</label>
                    <input type="text" id="pertanyaan_40" name="pertanyaan_40" value="<?= $data["pertanyaan_40"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="lat" class=" form-control-label">lat</label>
                    <input type="text" id="lat" name="lat" value="<?= $data["lat"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="lang" class=" form-control-label">lang</label>
                    <input type="text" id="lang" name="lang" value="<?= $data["lang"]; ?>" placeholder="" class="form-control">
                </div>
                <div class="form-actions form-group">
                    <button type="submit" name="save" class="btn btn-success btn-sm">Submit</button>
                    <a href="index.php?acts=responden" class="btn btn-success btn-sm"><i class="material-icons">Batal</a>
                </div>
            </form>    
        </div>
    </div>
</div>