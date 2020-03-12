<?php

namespace app\controllers;

use Yii;
use app\models\Responden;
use app\models\RespondenSeacrh;
use yii\web\Controller;
use yii\web\NotFoundHttpException;
use yii\filters\VerbFilter;
use app\models\Provinsi;
use app\models\KabKota;
use app\models\Kecamatan;
use app\models\Kelurahan;
use yii\helpers\ArrayHelper;

/**
 * RespondenController implements the CRUD actions for Responden model.
 */
class RespondenController extends Controller
{
    
    public function behaviors()
    {
        return [
            'verbs' => [
                'class' => VerbFilter::className(),
                'actions' => [
                    'delete' => ['POST'],
                ],
            ],
        ];
    }

    
    public function actionGrafikprovinsi()
    {

         $data = Yii::$app->db->createCommand('select
            pertanyaan_38,
            sum(pertanyaan_38 = pertanyaan_38) as jumlah
            from responden group by pertanyaan_38')->queryAll();

        return $this->render('grafikprovinsi', 
            ['dgrafikprov' => $data] );
    }

    public function actionGrafikkabkota()
    {
        $kabkota = kabkota::find()->all();
        $kabkota =ArrayHelper::map($kabkota,'id_kabkota','nama');


        return $this->render('grafikkabkota', [
            'kabkota'=>$kabkota]);
    }

    public function actionGrafikkecamatan()
    {

        return $this->render('grafikkecamatan');
    }

    public function actionGrafikkeldesa()
    {

        return $this->render('grafikkeldesa');
    }

    /**
     * Lists all Responden models.
     * @return mixed
     */
    public function actionIndex()
    {
        $searchModel = new RespondenSeacrh();
        $dataProvider = $searchModel->search(Yii::$app->request->queryParams);

        return $this->render('index', [
            'searchModel' => $searchModel,
            'dataProvider' => $dataProvider,
        ]);
    }

    /**
     * Displays a single Responden model.
     * @param integer $id
     * @return mixed
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionView($id)
    {
        return $this->render('view', [
            'model' => $this->findModel($id),
        ]);
    }

    /**
     * Creates a new Responden model.
     * If creation is successful, the browser will be redirected to the 'view' page.
     * @return mixed
     */
    public function actionCreate()
    {
        $model = new Responden();
        $provinsi = Provinsi::find()->all();
        $provinsi =ArrayHelper::map($provinsi,'id_provinsi','nama');

        $kabkota = kabkota::find()->all();
        $kabkota =ArrayHelper::map($kabkota,'id_kabkota','nama');

        
        // $kecamatan = Kecamatan::find()->where(['id_kabkota'=>$id_kecamatan])->all();
        $kecamatan = Kecamatan::find()->all();
        $kecamatan = ArrayHelper::map($kecamatan,'id_kecamatan','nama');

        $kecamatan = Kecamatan::find()->all();
        $kecamatan = ArrayHelper::map($kecamatan,'id_kecamatan','nama');

        // $kelurahan = Kelurahan::find()->where(['id_kec'=>$id_kelurahan])->all();
        $kelurahan = Kelurahan::find()->all();
        $kelurahan = ArrayHelper::map($kelurahan,'id_kelurahan','nama');

        if ($model->load(Yii::$app->request->post()) && $model->save()) {
            return $this->redirect(['view', 'id' => $model->id_responden]);
        }



        return $this->render('create', [
            'model' => $model,
            'provinsi'=>$provinsi,
            'kabkota' => $kabkota,
            'kecamatan' => $kecamatan,
            'kelurahan' => $kelurahan
        ]);
    }

    /**
     * Updates an existing Responden model.
     * If update is successful, the browser will be redirected to the 'view' page.
     * @param integer $id
     * @return mixed
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionUpdate($id)
    {
        $model = $this->findModel($id);
         $provinsi = Provinsi::find()->all();
        $provinsi =ArrayHelper::map($provinsi,'id_provinsi','nama');

        $kabkota = kabkota::find()->all();
        $kabkota =ArrayHelper::map($kabkota,'id_kabkota','nama');

        // $kecamatan = Kecamatan::find()->where(['id_kabkota'=>$id_kecamatan])->all();
        // $kecamatan =ArrayHelper::map($kecamatan,'id_kecamatan','nama');


        if ($model->load(Yii::$app->request->post()) && $model->save()) {
            return $this->redirect(['view', 'id' => $model->id_responden]);
        }

        return $this->render('update', [
            'model' => $model,
            'provinsi' => $provinsi,
            'kabkota' => $kabkota,
            // 'kecamatan' => $kecamatan
        ]);
    }

    /**
     * Deletes an existing Responden model.
     * If deletion is successful, the browser will be redirected to the 'index' page.
     * @param integer $id
     * @return mixed
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionDelete($id)
    {
        $this->findModel($id)->delete();

        return $this->redirect(['index']);
    }

    /**
     * Finds the Responden model based on its primary key value.
     * If the model is not found, a 404 HTTP exception will be thrown.
     * @param integer $id
     * @return Responden the loaded model
     * @throws NotFoundHttpException if the model cannot be found
     */
    protected function findModel($id)
    {
        if (($model = Responden::findOne($id)) !== null) {
            return $model;
        }

        throw new NotFoundHttpException('The requested page does not exist.');
    }
}
