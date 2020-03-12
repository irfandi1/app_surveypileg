<?php
if ( isset($_POST["submit"]) ) {

    if ( tambahsurveyor ($_POST) > 0 ) {
        echo "<script> alert('Data berhasil ditambah!');
        document.location.href= 'index.php?acts=surveyor';
        </script>";
    } else {
        echo "<script> alert('Data Gagal ditambah!');
        document.location.href='index.php?acts=surveyor';
        </script>";
    }
}
?>


<div class="login-content">
        <div class="card">
            <div class="card-header">Tambah Surveyor</div>
            <div class="card-body card-block">
                <form action="" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="nama_petugas" name="nama_petugas" placeholder="Nama Petugas" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="username" name="username" placeholder="username" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-asterisk"></i>
                            </div>
                            <input type="password" id="password" name="password" placeholder="Password" class="form-control">
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
                            <input type="text" id="no_hp" name="no_hp" placeholder="Nomor HP" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="alamat" name="alamat" placeholder="Alamat" class="form-control">
                        </div>
                    </div>
                    <div class="form-actions form-group">
                        <button type="submit" name="submit" class="btn btn-success btn-sm">Submit</button>
                        <a href="index.php?acts=surveyor" class="btn btn-success btn-sm"><i class="material-icons">Batal</a>
                    </div>
                </form>
            </div>
        </div>
    </div>