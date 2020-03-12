<?php 

$id_kecamatan = query("SELECT * FROM tb_kecamatan");

if ( isset($_POST["save"]) ) {
    $kec = $_POST['id_kecamatan'];
   
    echo "
    <script>
            document.location.href='index.php?acts=grafikkecamatan1&nama=$kec';
            </script>
            ";
            
    }

?>
<form action="" method="post">
    <div class="login-content">
        <div class="form-group">
        <!-- =========================== Dropdown depedent ========================================== -->
            <div class="form-group" style="position: static;"> 
                <label for="kabkota">Kabupaten</label> 
                <select class="form-control" id="kabkota"></select> 
            </div> 
            <div class="form-group" style="position: static;"> 
                <label for="Kecamatan">Kecamatan</label> 
                <select class="form-control" name="id_kecamatan" id="kecamatan"></select> 
            </div> 
            <!-- =========================== End Dropdown depedent ========================================== -->
            <!-- =========================== Dropdown Kecamatan ========================================== -->
            
            <!-- =========================== End Dropdown Kecamatan ========================================== -->
        </div>


        <div class="table-data-feature">
        <button type="submit"  name="save"class="au-btn au-btn-icon au-btn--green au-btn--small" data-toggle="tooltip" data-placement="top">
            </i> Submit
        </button>
        </div>
        <br><br>
    </div>
</form>


<script type="text/javascript"> 
    $(document).ready(function() { 
        $("#kabkota").append('<option value="">Pilih</option>'); 
        $("#kecamatan").html(''); 
        $("#kecamatan").append('<option value="">Pilih</option>'); 
        url = '../config/getkabkota.php'; 
        console.log(url);
        $.ajax({ url: url, 
            type: 'GET', 
            dataType: 'json', 
            success: function(result) { 
            for (var i = 0; i < result.length; i++) 
                $("#kabkota").append('<option value="' + result[i].id_kabkota + '">' + result[i].nama + '</option>'); 
            } 
        }); 
    });

    $("#kabkota").change(function(){ 
        var id_kabkota = $("#kabkota").val(); 
        var url = '../config/getkecamatan.php?id_kabkota=' + id_kabkota; 
        console.log(url);
        $("#kecamatan").html(''); 
        $("#kecamatan").append('<option value="">Pilih</option>'); 
        $.ajax({ url : url, 
            type: 'GET', 
            dataType : 'json', 
            success : function(result){ 
                for(var i = 0; i < result.length; i++) 
                $("#kecamatan").append('<option value="'+ result[i].nama +'">' + result[i].nama + '</option>'); 
            } 
        });  
    });  
</script>