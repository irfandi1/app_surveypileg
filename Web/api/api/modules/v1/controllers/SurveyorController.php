<?php


namespace app\api\modules\v1\controllers;

use Yii;
use app\models\Surveyor;
use yii\rest\Controller;
use yii\web\Response;

class SurveyorController extends Controller{
	public function actionIndex(){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isGet){

			$responden = Surveyor::find()->all();
			// var_dump($responden);
			// exit();
			$response ['master'] = $responden;
		}
		return $response;
	}
	public function actionAdd(){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isPost) {
			# code...
			$data = Yii::$app->request->post();

			$username = $data['username'];
			$password = $data['password'];
			$nama_petugas = $data['nama_petugas'];
			$jenis_kelamin = $data['jenis_kelamin'];
			$no_hp = $data['no_hp'];
			$alamat = $data['alamat'];
			$status = $data['status'];

			$surveyor = new Surveyor();
			$surveyor->username=$username;
			$surveyor->password=$password;
			$surveyor->nama_petugas=$nama_petugas;
			$surveyor->jenis_kelamin=$jenis_kelamin;
			$surveyor->no_hp=$no_hp;
			$surveyor->alamat=$alamat;
			$surveyor->status=$status;

			// var_dump($surveyor);
			// exit();
			if ($surveyor->save()) {
				# code...
				$response['code'] = 200;
				$response['message'] = "Registrasi berhasil";
				$response['data'] = $surveyor;
			}
			else{
				$response['code'] = 500;
				$response['message'] = "Registrasi Gagal";
				$response['data'] = null;
			}
			
		}
		return $response;
	}



	public function actionUpdate(){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isPost) {
			# code...
			$data = Yii::$app->request->post();
			
			$id_surveyor = $data['id_surveyor'];
			$username = $data['username'];
			$password = $data['password'];
			$nama_petugas = $data['nama_petugas'];
			$jenis_kelamin = $data['jenis_kelamin'];
			$no_hp = $data['no_hp'];
			$alamat = $data['alamat'];
			$status = $data['status'];

			$surveyor = Surveyor::find()->where(['id_surveyor'=>$id_surveyor])->one();
			$surveyor->username=$username;
			$surveyor->password=$password;
			$surveyor->nama_petugas=$nama_petugas;
			$surveyor->jenis_kelamin=$jenis_kelamin;
			$surveyor->no_hp=$no_hp;
			$surveyor->alamat=$alamat;
			$surveyor->status=$status;

			// var_dump($surveyor);
			// exit();
			if ($surveyor->save()) {
				# code...
				$response['code'] = 200;
				$response['message'] = "Update berhasil";
				$response['data'] = $surveyor;
			}
			else{
				$response['code'] = 500;
				$response['message'] = "Update Gagal";
				$response['data'] = null;
			}
			
		}
		return $response;
	}

	
	public function actionLogin(){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isPost){

			$data = Yii::$app->request->post();
			
			$username = $data['username'];
			$password = $data['password'];
			$status = $data['status'];

			$surveyor = Surveyor::find()
			->where(['username'=>$username])->andWhere(['status'=>$status])
			->andWhere(['password'=>$password])->one();

			if(isset($surveyor)){
                $response['code'] = 200;
                $response['message'] = 'Selamat datang '.$surveyor->username;
                $response['data'] = $surveyor;
            }
            else{
                $response['code'] = 500;
                $response['message'] = 'Login gagal! Username atau Password salah';
            }

			// var_dump($surveyor);
			// exit();
		}
		return $response;
	}
}
