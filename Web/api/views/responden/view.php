<?php

use yii\helpers\Html;
use yii\widgets\DetailView;

/* @var $this yii\web\View */
/* @var $model app\models\Responden */

$this->title = $model->id_responden;
$this->params['breadcrumbs'][] = ['label' => 'Respondens', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
\yii\web\YiiAsset::register($this);
?>
<div class="responden-view">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a('Update', ['update', 'id' => $model->id_responden], ['class' => 'btn btn-primary']) ?>
        <?= Html::a('Delete', ['delete', 'id' => $model->id_responden], [
            'class' => 'btn btn-danger',
            'data' => [
                'confirm' => 'Are you sure you want to delete this item?',
                'method' => 'post',
            ],
        ]) ?>
    </p>

    <?= DetailView::widget([
        'model' => $model,
        'attributes' => [
            'id_responden',
            'id_surveyor',
            'nama_responden',
            'alamat',
            'provinsi',
            'kab_kota',
            'kecamatan',
            'kel_desa',
            'rt',
            'rw',
            'no_hp',
            'nama_kk',
            'no_urut_responden',
            'pertanyaan_12',
            'pertanyaan_13',
            'pertanyaan_14',
            'pertanyaan_15',
            'pertanyaan_16',
            'pertanyaan_17',
            'pertanyaan_18',
            'pertanyaan_19',
            'pertanyaan_20',
            'pertanyaan_21',
            'pertanyaan_22',
            'pertanyaan_23',
            'pertanyaan_24',
            'pertanyaan_25',
            'pertanyaan_26',
            'pertanyaan_27',
            'pertanyaan_28',
            'pertanyaan_29',
            'pertanyaan_30',
            'pertanyaan_31',
            'pertanyaan_32',
            'pertanyaan_33',
            'pertanyaan_34',
            'pertanyaan_35',
            'pertanyaan_36',
            'pertanyaan_37',
            'pertanyaan_38',
            'pertanyaan_39',
            'pertanyaan_40',
            'pertanyaan_41',
            'pertanyaan_42',
            'pertanyaan_43',
            'pertanyaan_44',
            'pertanyaan_45',
            'pertanyaan_46',
            'pertanyaan_47',
            'pertanyaan_48',
            'pertanyaan_49',
            'pertanyaan_50',
            'pertanyaan_51',
            'pertanyaan_52',
            'pertanyaan_53',
            'pertanyaan_54',
            'pertanyaan_55',
            'lat',
            'lang',
            'create_at',
        ],
    ]) ?>

</div>
