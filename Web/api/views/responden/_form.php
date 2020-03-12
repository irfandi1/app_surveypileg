<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model app\models\Responden */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="responden-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'id_surveyor')->textInput() ?>

    <?= $form->field($model, 'nama_responden')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'alamat')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'provinsi')->dropDownList($provinsi)?>

    <?= $form->field($model, 'kab_kota')->dropDownList($kabkota) ?>

    <?= $form->field($model, 'kecamatan')->dropDownList($kecamatan) ?>

    <?= $form->field($model, 'kel_desa')->dropDownList($kelurahan) ?>

    <?= $form->field($model, 'rt')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'rw')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'no_hp')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'nama_kk')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'no_urut_responden')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_12')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_13')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_14')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_15')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_16')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_17')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_18')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_19')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_20')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_21')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_22')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_23')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_24')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_25')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_26')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_27')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_28')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_29')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_30')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_31')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_32')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_33')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_34')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_35')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_36')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_37')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_38')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_39')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_40')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_41')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_42')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_43')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_44')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_45')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_46')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_47')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_48')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_49')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_50')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_51')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_52')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_53')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_54')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'pertanyaan_55')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'lat')->textInput() ?>

    <?= $form->field($model, 'lang')->textInput() ?>

    <?= $form->field($model, 'create_at')->textInput() ?>

    <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
