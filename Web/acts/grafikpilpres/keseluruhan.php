<?php 
$result = mysqli_query($conn, "SELECT * FROM Responden WHERE pertanyaan_39 = pertanyaan_39");

foreach ($result as $view) :
    
    $data []= $view ["pertanyaan_39"];

    // $jumlah = count(pertanyaan_38($view));

    // echo "$view</b> adalah $jumlah";

endforeach;
?>

<div class="login-content">
<?php
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
     


?>
    <script>

        window.onload = function() {

            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2", // "light1", "light2", "dark1", "dark2"
                exportEnabled: true,
                animationEnabled: true,
                title: {
                    text: "Grafik Pileg Keseluruhan"
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
    <div id="chartContainer" style="height: 370px; max-width: 920px; margin: 0px auto;"></div>
</div>