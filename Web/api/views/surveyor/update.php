<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\Surveyor */

$this->title = 'Update Surveyor: ' . $model->id_surveyor;
$this->params['breadcrumbs'][] = ['label' => 'Surveyors', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->id_surveyor, 'url' => ['view', 'id' => $model->id_surveyor]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="surveyor-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
