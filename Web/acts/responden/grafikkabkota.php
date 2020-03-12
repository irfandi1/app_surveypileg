<?php 

$id_kabkota = query("SELECT * FROM tb_kabkota");

if ( isset($_POST["save"]) ) {
    $kab = $_POST['id_kabkota'];
   
    echo "
    <script>
            document.location.href='index.php?acts=grafikkabkota1&nama=$kab';
            </script>
            ";
            
    }

?>
 <form action="" method="post">
<div class="login-content">
<div class="form-group">
    <label for="id_kabkota" class=" form-control-label">Kabkota</label>
    
    <select name="id_kabkota" class="form-control" id="kabkota">
    <?php
        foreach ($id_kabkota as $nama):
    ?>
        <option value="<?= $nama["nama"]; ?>"> <?= $nama["nama"]; ?> </option>
    <?php
        endforeach
    ?>
    </select>
</div>


<div class="table-data-feature">
    <button type="submit"  name="save"class="au-btn au-btn-icon au-btn--green au-btn--small" data-toggle="tooltip" data-placement="top">
       </i> Submit
    </button>
</div>
<br><br>

</form>
</div>


