<?php
$id_surveyor = $_GET["id"];
$data = query ("SELECT * FROM surveyor WHERE id_surveyor=$id_surveyor")[0];

if ( isset($_POST["save"]) ) {

  if ( editsurveyor ($_POST) > 0 ) {
    echo "
    <script>
            alert('Data berhasil diubah!');
            document.location.href='index.php?acts=surveyor';
            </script>
            ";
  } else {
    echo "
    <script>
            alert('Data Gagal diubah!');
            document.location.href='index.php?acts=surveyor';
            </script>
            ";
          }
  }
?>

<div class="login-content">
        <div class="card">
            <div class="card-header">Edit Surveyor</div>
            <div class="card-body card-block">
                <form action="" method="post">
                <input type="hidden" value="<?= $data["id_surveyor"]; ?>" name="id" > 
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="nama_petugas" name="nama_petugas" value="<?= $data["nama_petugas"]; ?>" placeholder="Nama Petugas" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="username" name="username" value="<?= $data["username"]; ?>" placeholder="username" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <select name="jenis_kelamin" id="">
                                <option value="laki-laki">Laki-laki</option>
                                <option value="perempuan">Perempuan</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="no_hp" name="no_hp"  value="<?= $data["no_hp"]; ?>" placeholder="Nomor HP" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="alamat" name="alamat"  value="<?= $data["alamat"]; ?>" placeholder="Alamat" class="form-control">
                        </div>
                    </div>
                    <div class="form-actions form-group">
                        <button type="submit" name="save" class="btn btn-success btn-sm">Simpan</button>
                        <a href="index.php?acts=surveyor" class="btn btn-success btn-sm"><i class="material-icons">Batal</a>
                    </div>
                </form>
            </div>
        </div>
    </div>