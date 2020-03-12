<?php


namespace app\api\modules\v1\controllers;

use Yii;
use app\models\Provinsi;
use app\models\KabKota;
use app\models\Kecamatan;
use app\models\Kelurahan;
use yii\rest\Controller;
use yii\web\Response;


class KabKotaController extends Controller{


	public function actionViewByIdKabkota($id_kabkota){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isGet){

			$kabkota = kabkota::find()->all();
			// var_dump($responden);
			// exit();
			$response ['master'] = $kabkota;
		}
		return $response;
	}

}