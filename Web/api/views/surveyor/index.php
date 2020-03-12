<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel app\models\SurveyorSeacrh */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Surveyors';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="surveyor-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Surveyor', ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'id_surveyor',
            'nama_petugas',
            'username',
            'password',
            'jenis_kelamin',
            //'no_hp',
            //'alamat',
            //'created_at',
            //'created_update',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
