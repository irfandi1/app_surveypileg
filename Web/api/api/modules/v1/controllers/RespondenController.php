<?php

namespace app\api\modules\v1\controllers;

use Yii;
use app\models\Responden;
use app\models\Surveyor;
use yii\rest\Controller;
use yii\web\Response;

class RespondenController extends Controller{

	 public function actionGetAllMarkers(){
        Yii::$app->response->format = Response::FORMAT_XML;

        $response = null;

        if (Yii::$app->request->isGet){
            $sql = "SELECT responden.id_responden, surveyor.id_surveyor as id_surveyor, responden.nama_responden, 
            responden.alamat, responden.provinsi, responden.kab_kota, responden.kecamatan,
            responden.kel_desa, responden.rt, responden.rw, responden.no_hp, responden.pertanyaan_12, 
			responden.pertanyaan_13, responden.pertanyaan_14, responden.pertanyaan_15, responden.pertanyaan_16, 
            responden.pertanyaan_17, responden.pertanyaan_18, responden.pertanyaan_19, 
            responden.pertanyaan_20, responden.pertanyaan_21, responden.pertanyaan_22,
            responden.pertanyaan_23, responden.pertanyaan_24, responden.pertanyaan_25,
            responden.pertanyaan_26, responden.pertanyaan_27, responden.pertanyaan_28,
            responden.pertanyaan_29, responden.pertanyaan_30, responden.pertanyaan_31,
            responden.pertanyaan_32, responden.pertanyaan_33, responden.pertanyaan_34,
            responden.pertanyaan_35, responden.pertanyaan_36, responden.pertanyaan_37,
            responden.pertanyaan_38, responden.pertanyaan_39, responden.pertanyaan_40,
            responden.lat, responden.lang, responden.create_at

            FROM responden INNER JOIN surveyor ON responden.nama_responden = surveyor.id_surveyor ORDER BY id_responden DESC" ;
            $response = Yii::$app->db->createCommand($sql)->queryAll();

            //$this->layout='mainxml';
			 // Parsing Karakter-Karakter Khusus
			 function parseToXML($htmlStr)
			 {
				  $xmlStr=str_replace('<','<',$htmlStr);
				  $xmlStr=str_replace('>','>',$xmlStr);
				  $xmlStr=str_replace('"','"',$xmlStr);
				  $xmlStr=str_replace("'","'",$xmlStr);
				  $xmlStr=str_replace("&",'&',$xmlStr);
				  return $xmlStr;
			 }
		 
			
		 
			 // Header File XML
			 header("Content-type: text/xml");
		 
			 // Parent node XML
			 echo '<markers>';
		 
			 // Iterasi baris, masing-masing menghasilkan node-node XML
			foreach($response as $db)
			{
				  // Menambahkan ke node dokumen XML
				   echo '<marker ';
				  echo 'id_responden="' . parseToXML($db['id_responden']) . '" ';
				 

				  echo 'nama_responden="' . parseToXML($db['nama_responden']) . '" ';
                  echo 'alamat="' . parseToXML($db['alamat']) . '" ';
                  echo 'provinsi="' . parseToXML($db['provinsi']) . '" ';
                  echo 'kab_kota="' . parseToXML($db['kab_kota']) . '" ';
                  echo 'kecamatan="' . parseToXML($db['kecamatan']) . '" ';
                  echo 'kel_desa="' . parseToXML($db['kel_desa']) . '" ';
                  // echo 'rt="' . parseToXML($db['rt']) . '" ';
                  // echo 'rw="' . parseToXML($db['rw']) . '" ';
                  // echo 'no_hp="' . parseToXML($db['no_hp']) . '" ';
                  // echo 'nama_kk="' . parseToXML($db['nama_kk']) . '" ';
                  // // echo 'no_urut_responden="' . parseToXML($db['no_urut_responden']) . '" ';
                  // echo 'pertanyaan_12="' . parseToXML($db['pertanyaan_12']) . '" ';
                  // echo 'pertanyaan_13="' . parseToXML($db['pertanyaan_13']) . '" ';
                  // echo 'pertanyaan_14="' . parseToXML($db['pertanyaan_14']) . '" ';
                  // echo 'pertanyaan_15="' . parseToXML($db['pertanyaan_15']) . '" ';
                  // echo 'pertanyaan_16="' . parseToXML($db['pertanyaan_16']) . '" ';
                  // echo 'pertanyaan_17="' . parseToXML($db['pertanyaan_17']) . '" ';
                  // echo 'pertanyaan_18="' . parseToXML($db['pertanyaan_18']) . '" ';
                  // echo 'pertanyaan_19="' . parseToXML($db['pertanyaan_19']) . '" ';
                  // echo 'pertanyaan_20="' . parseToXML($db['pertanyaan_20']) . '" ';
                  // echo 'pertanyaan_21="' . parseToXML($db['pertanyaan_21']) . '" ';
                  // echo 'pertanyaan_22="' . parseToXML($db['pertanyaan_22']) . '" ';
                  // echo 'pertanyaan_23="' . parseToXML($db['pertanyaan_23']) . '" ';
                  // echo 'pertanyaan_24="' . parseToXML($db['pertanyaan_24']) . '" ';
                  // echo 'pertanyaan_25="' . parseToXML($db['pertanyaan_25']) . '" ';
                  // echo 'pertanyaan_26="' . parseToXML($db['pertanyaan_26']) . '" ';
                  // echo 'pertanyaan_27="' . parseToXML($db['pertanyaan_27']) . '" ';
                  // echo 'pertanyaan_28="' . parseToXML($db['pertanyaan_28']) . '" ';
                  echo 'pertanyaan_29="' . parseToXML($db['pertanyaan_29']) . '" ';
                  // echo 'pertanyaan_30="' . parseToXML($db['pertanyaan_30']) . '" ';
                  // echo 'pertanyaan_31="' . parseToXML($db['pertanyaan_31']) . '" ';
                  // echo 'pertanyaan_32="' . parseToXML($db['pertanyaan_32']) . '" ';
                  // echo 'pertanyaan_33="' . parseToXML($db['pertanyaan_33']) . '" ';
                  // echo 'pertanyaan_34="' . parseToXML($db['pertanyaan_34']) . '" ';
                  // echo 'pertanyaan_35="' . parseToXML($db['pertanyaan_35']) . '" ';
                  // echo 'pertanyaan_36="' . parseToXML($db['pertanyaan_36']) . '" ';
                  // echo 'pertanyaan_37="' . parseToXML($db['pertanyaan_37']) . '" ';
                  // echo 'pertanyaan_38="' . parseToXML($db['pertanyaan_38']) . '" ';
                  // echo 'pertanyaan_39="' . parseToXML($db['pertanyaan_39']) . '" ';
                  // echo 'pertanyaan_40="' . parseToXML($db['pertanyaan_40']) . '" ';
                  echo 'lat="' . parseToXML($db['lat']) . '" ';
                  echo 'lang="' . parseToXML($db['lang']) . '" ';
				  $date = date_create($db['create_at']); 
				  echo 'waktu="' . date_format($date, 'j F Y, \p\u\k\u\l G:i') . '" ';
				 
				  echo '/>';
			 }
		 
			 // Akhir File XML (tag penutup node)
			 echo '</markers>';
        }

       
	}


	

	public function actionIndex(){
		Yii::$app->response->format=Response::FORMAT_JSON;
		$response = null;

		if (Yii::$app->request->isGet){

			$responden = Responden::find()->all();
			// $surveyor = Responden::find()->all();
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
			$data = Yii::$app->request->post();

			$responden = new Responden();
			
			$responden->id_surveyor = $data['id_surveyor'];
			$responden->nama_responden = $data['nama_responden'];
			$responden->alamat = $data['alamat'];
			$responden->provinsi = $data['provinsi'];
			$responden->kab_kota = $data['kab_kota'];
			$responden->kecamatan = $data['kecamatan'];
			$responden->kel_desa = $data['kel_desa'];
			$responden->rt = $data['rt'];
			$responden->rw = $data['rw'];
			$responden->no_hp = $data['no_hp'];
			$responden->pertanyaan_12 = $data['pertanyaan_12'];
			$responden->pertanyaan_13 = $data['pertanyaan_13'];
			$responden->pertanyaan_14 = $data['pertanyaan_14'];
			$responden->pertanyaan_15 = $data['pertanyaan_15'];
			$responden->pertanyaan_16 = $data['pertanyaan_16'];
			$responden->pertanyaan_17 = $data['pertanyaan_17'];
			$responden->pertanyaan_18 = $data['pertanyaan_18'];
			$responden->pertanyaan_19 = $data['pertanyaan_19'];
			$responden->pertanyaan_20 = $data['pertanyaan_20'];
			$responden->pertanyaan_21 = $data['pertanyaan_21'];
			$responden->pertanyaan_22 = $data['pertanyaan_22'];
			$responden->pertanyaan_23 = $data['pertanyaan_23'];
			$responden->pertanyaan_24 = $data['pertanyaan_24'];
			$responden->pertanyaan_25 = $data['pertanyaan_25'];
			$responden->pertanyaan_26 = $data['pertanyaan_26'];
			$responden->pertanyaan_27 = $data['pertanyaan_27'];
			$responden->pertanyaan_28 = $data['pertanyaan_28'];
			$responden->pertanyaan_29 = $data['pertanyaan_29'];
			$responden->pertanyaan_30 = $data['pertanyaan_30'];
			$responden->pertanyaan_31 = $data['pertanyaan_31'];
			$responden->pertanyaan_32 = $data['pertanyaan_32'];
			$responden->pertanyaan_33 = $data['pertanyaan_33'];
			$responden->pertanyaan_34 = $data['pertanyaan_34'];
			$responden->pertanyaan_35 = $data['pertanyaan_35'];
			$responden->pertanyaan_36 = $data['pertanyaan_36'];
			$responden->pertanyaan_37 = $data['pertanyaan_37'];
			$responden->pertanyaan_38 = $data['pertanyaan_38'];
			$responden->pertanyaan_39 = $data['pertanyaan_39'];
			$responden->pertanyaan_40 = $data['pertanyaan_40'];
			$responden->lat = $data['lat'];
			$responden->lang = $data['lang'];

			// var_dump($responden);
			// exit();
			if ($responden->save()) {
				# code...
				$response['code'] = 200;
				$response['message'] = "Responden berhasil";
				$response['data'] = $responden;
			}
			else{
				$response['code'] = 500;
				$response['message'] = "Responden Gagal";
				$response['data'] = null;
			}
		}
		return $response;
	}
}