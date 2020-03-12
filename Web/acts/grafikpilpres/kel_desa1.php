<?php 
$kel = $_GET["nama"];
$query= "SELECT * FROM Responden WHERE pertanyaan_39 = pertanyaan_39 and kel_desa='$kel'";


$result = mysqli_query($conn, $query );


$data =null;
foreach ($result as $view) :
    $data []= $view ["pertanyaan_39"];
    // $jumlah = count(pertanyaan_39($view));

    // echo "$view</b> adalah $jumlah";
endforeach;

if($data!=null){
    foreach(array_count_values($data) as $k => $v){
            $partai[]=$k;
            $jumlah []= $v;

        //   echo "partai <b>".$k."</b> ada sebanyak ".$v."<br />";

      }
      $semua=0;
     foreach($jumlah as $a ){
         $semua+=$a;
    
     }
     foreach($jumlah as $a ){
        $persen[]= ($a/$semua)*100;
   
    }
     

}
?>

<?php if($data!=null){ ?>
<script>

window.onload = function() {

    var chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2", // "light1", "light2", "dark1", "dark2"
        exportEnabled: true,
        animationEnabled: true,
        title: {
            text: "Grafik Pilpres Kecamatan <?php echo $kel ?>"
        },
        data: [{
            type: "pie",
            startAngle: 25,
            toolTipContent: "<b>{label}</b>: {y}%",
            showInLegend: "true",
            legendText: "{label}",
            indexLabelFontSize: 16,
            indexLabel: "{label} - {y}%",
            dataPoints: [
                <?php foreach ($partai as $key => $a) :?>
                { y: <?= $persen[$key];?>, label: "<?= $a; ?>" },

                <?php endforeach ?>
                
            ]
        }]
    });
    chart.render();
}
</script>
<?php } 
else{
    ?>
    <script>

window.onload = function() {

    var chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2", // "light1", "light2", "dark1", "dark2"
        exportEnabled: true,
        animationEnabled: true,
        title: {
            text: "Data tidak ditemukan <?php echo $kel ?>"
        },
        data: [{
            type: "pie",
            startAngle: 25,
            toolTipContent: "<b>{label}</b>: {y}%",
            showInLegend: "true",
            legendText: "{label}",
            indexLabelFontSize: 16,
            indexLabel: "{label} - {y}%",
            dataPoints: [
                
                
            ]
        }]
    });
    chart.render();
}
</script>
    <?php }?>
<div id="chartContainer" style="height: 370px; max-width: 920px; margin: 0px auto;"></div>