<?php


namespace app\api\modules\v1\controllers;

use Yii;
use app\models\Provinsi;
use app\models\KabKota;
use app\models\Kecamatan;
use app\models\Kelurahan;
use yii\rest\Controller;
use yii\web\Response;

class ProvinsiController extends Controller{

	public function actionIndex(){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isGet){

			$provinsi = Provinsi::find()->all();
			// var_dump($responden);
			// exit();
			$response ['master'] = $provinsi;
		}
		return $response;
	}
	
}
