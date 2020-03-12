<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\KabKota */

$this->title = 'Update Kab Kota: ' . $model->id_kabkota;
$this->params['breadcrumbs'][] = ['label' => 'Kab Kotas', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->id_kabkota, 'url' => ['view', 'id' => $model->id_kabkota]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="kab-kota-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
