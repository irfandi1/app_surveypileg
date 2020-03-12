<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\Responden */

$this->title = 'Create Responden';
$this->params['breadcrumbs'][] = ['label' => 'Respondens', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="responden-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
        'provinsi'=>$provinsi,
        'kabkota' => $kabkota,
        'kecamatan' => $kecamatan,
        'kelurahan' => $kelurahan
    ]) ?>

</div>
