<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model app\models\KecamatanSeacrh */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="kecamatan-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'id_kecamatan') ?>

    <?= $form->field($model, 'nama') ?>

    <?= $form->field($model, 'id_kabkota') ?>

    <?= $form->field($model, 'dapil') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
