<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\Responden */

$this->title = 'Update Responden: ' . $model->id_responden;
$this->params['breadcrumbs'][] = ['label' => 'Respondens', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->id_responden, 'url' => ['view', 'id' => $model->id_responden]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="responden-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
        'provinsi'=>$provinsi,
        'kabkota' => $kabkota,
        'kecamatan' => $kecamatan,
        'kelurahan' => $kelurahan
    ]) ?>

</div>
