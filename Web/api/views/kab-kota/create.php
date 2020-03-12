<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\KabKota */

$this->title = 'Create Kab Kota';
$this->params['breadcrumbs'][] = ['label' => 'Kab Kotas', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="kab-kota-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
