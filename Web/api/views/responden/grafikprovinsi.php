<?php
 
   use dosamigos\highcharts\HighCharts;

   //use miloschuman\highcharts\Highcharts;
   /* @var $this yii\web\View */



   $this->title = 'Data Survey';

   foreach($dgrafikprov as $values){
      $a[0]= ($values['pertanyaan_38']);
      $c[]= ($values['pertanyaan_38']);
      $b[]= array('type'=> 'column', 'name' =>$values['pertanyaan_38'], 'data' => array((int)$values['jumlah']));
   }
   echo
   Highcharts::widget([
      'clientOptions' => [
         'chart'=>[
            'type'=>'bar'
         ],
         'title' => ['text' => 'Data Survey'],
         'xAxis' => [
            'categories' => ['Jumlah']
         ],
         'yAxis' => [
            'title' => ['text' => 'Jumlah Survey']
         ],
         'series' => $b
      ]
   ]);
?>


