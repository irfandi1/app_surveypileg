<?php


namespace app\api\modules\v1\controllers;

use Yii;
use app\models\Provinsi;
use app\models\KabKota;
use app\models\Kecamatan;
use app\models\Kelurahan;
use yii\rest\Controller;
use yii\web\Response;


class KelurahanController extends Controller{

	public function actionViewByIdKecamatan($id_kelurahan){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isGet){

			$kelurahan = Kelurahan::find()->where(['id_kec'=>$id_kelurahan])->all();
			// var_dump($responden);
			// exit();
			$response ['master'] = $kelurahan;
		}
		return $response;
	}

}