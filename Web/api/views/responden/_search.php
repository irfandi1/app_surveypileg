<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model app\models\RespondenSeacrh */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="responden-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'id_responden') ?>

    <?= $form->field($model, 'id_surveyor') ?>

    <?= $form->field($model, 'nama_responden') ?>

    <?= $form->field($model, 'alamat') ?>

    <?= $form->field($model, 'provinsi') ?>

    <?php // echo $form->field($model, 'kab_kota') ?>

    <?php // echo $form->field($model, 'kecamatan') ?>

    <?php // echo $form->field($model, 'kel_desa') ?>

    <?php // echo $form->field($model, 'rt') ?>

    <?php // echo $form->field($model, 'rw') ?>

    <?php // echo $form->field($model, 'no_hp') ?>

    <?php // echo $form->field($model, 'nama_kk') ?>

    <?php // echo $form->field($model, 'no_urut_responden') ?>

    <?php // echo $form->field($model, 'pertanyaan_12') ?>

    <?php // echo $form->field($model, 'pertanyaan_13') ?>

    <?php // echo $form->field($model, 'pertanyaan_14') ?>

    <?php // echo $form->field($model, 'pertanyaan_15') ?>

    <?php // echo $form->field($model, 'pertanyaan_16') ?>

    <?php // echo $form->field($model, 'pertanyaan_17') ?>

    <?php // echo $form->field($model, 'pertanyaan_18') ?>

    <?php // echo $form->field($model, 'pertanyaan_19') ?>

    <?php // echo $form->field($model, 'pertanyaan_20') ?>

    <?php // echo $form->field($model, 'pertanyaan_21') ?>

    <?php // echo $form->field($model, 'pertanyaan_22') ?>

    <?php // echo $form->field($model, 'pertanyaan_23') ?>

    <?php // echo $form->field($model, 'pertanyaan_24') ?>

    <?php // echo $form->field($model, 'pertanyaan_25') ?>

    <?php // echo $form->field($model, 'pertanyaan_26') ?>

    <?php // echo $form->field($model, 'pertanyaan_27') ?>

    <?php // echo $form->field($model, 'pertanyaan_28') ?>

    <?php // echo $form->field($model, 'pertanyaan_29') ?>

    <?php // echo $form->field($model, 'pertanyaan_30') ?>

    <?php // echo $form->field($model, 'pertanyaan_31') ?>

    <?php // echo $form->field($model, 'pertanyaan_32') ?>

    <?php // echo $form->field($model, 'pertanyaan_33') ?>

    <?php // echo $form->field($model, 'pertanyaan_34') ?>

    <?php // echo $form->field($model, 'pertanyaan_35') ?>

    <?php // echo $form->field($model, 'pertanyaan_36') ?>

    <?php // echo $form->field($model, 'pertanyaan_37') ?>

    <?php // echo $form->field($model, 'pertanyaan_38') ?>

    <?php // echo $form->field($model, 'pertanyaan_39') ?>

    <?php // echo $form->field($model, 'pertanyaan_40') ?>

    <?php // echo $form->field($model, 'pertanyaan_41') ?>

    <?php // echo $form->field($model, 'pertanyaan_42') ?>

    <?php // echo $form->field($model, 'pertanyaan_43') ?>

    <?php // echo $form->field($model, 'pertanyaan_44') ?>

    <?php // echo $form->field($model, 'pertanyaan_45') ?>

    <?php // echo $form->field($model, 'pertanyaan_46') ?>

    <?php // echo $form->field($model, 'pertanyaan_47') ?>

    <?php // echo $form->field($model, 'pertanyaan_48') ?>

    <?php // echo $form->field($model, 'pertanyaan_49') ?>

    <?php // echo $form->field($model, 'pertanyaan_50') ?>

    <?php // echo $form->field($model, 'pertanyaan_51') ?>

    <?php // echo $form->field($model, 'pertanyaan_52') ?>

    <?php // echo $form->field($model, 'pertanyaan_53') ?>

    <?php // echo $form->field($model, 'pertanyaan_54') ?>

    <?php // echo $form->field($model, 'pertanyaan_55') ?>

    <?php // echo $form->field($model, 'lat') ?>

    <?php // echo $form->field($model, 'lang') ?>

    <?php // echo $form->field($model, 'create_at') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
