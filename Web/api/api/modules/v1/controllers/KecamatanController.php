<?php


namespace app\api\modules\v1\controllers;

use Yii;
use app\models\Provinsi;
use app\models\KabKota;
use app\models\Kecamatan;
use app\models\Kelurahan;
use yii\rest\Controller;
use yii\web\Response;


class KecamatanController extends Controller{


	public function actionViewByIdKabkota($id_kecamatan){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isGet){

			$kecamatan = Kecamatan::find()->where(['id_kabkota'=>$id_kecamatan])->all();
			// var_dump($responden);
			// exit();
			$response ['master'] = $kecamatan;
		}
		return $response;
	}

}