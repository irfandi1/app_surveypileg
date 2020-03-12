<?php

namespace app\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use app\models\Responden;

/**
 * RespondenSeacrh represents the model behind the search form of `app\models\Responden`.
 */
class RespondenSeacrh extends Responden
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['id_responden', 'id_surveyor'], 'integer'],
            [['nama_responden', 'alamat', 'provinsi', 'kab_kota', 'kecamatan', 'kel_desa', 'rt', 'rw', 'no_hp', 'pertanyaan_12', 'pertanyaan_13', 'pertanyaan_14', 'pertanyaan_15', 'pertanyaan_16', 'pertanyaan_17', 'pertanyaan_18', 'pertanyaan_19', 'pertanyaan_20', 'pertanyaan_21', 'pertanyaan_22', 'pertanyaan_23', 'pertanyaan_24', 'pertanyaan_25', 'pertanyaan_26', 'pertanyaan_27', 'pertanyaan_28', 'pertanyaan_29', 'pertanyaan_30', 'pertanyaan_31', 'pertanyaan_32', 'pertanyaan_33', 'pertanyaan_34', 'pertanyaan_35', 'pertanyaan_36', 'pertanyaan_37', 'pertanyaan_38', 'pertanyaan_39', 'pertanyaan_40', 'create_at'], 'safe'],
            [['lat', 'lang'], 'number'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function scenarios()
    {
        // bypass scenarios() implementation in the parent class
        return Model::scenarios();
    }

    /**
     * Creates data provider instance with search query applied
     *
     * @param array $params
     *
     * @return ActiveDataProvider
     */
    public function search($params)
    {
        $query = Responden::find();

        // add conditions that should always apply here

        $dataProvider = new ActiveDataProvider([
            'query' => $query,
        ]);

        $this->load($params);

        if (!$this->validate()) {
            // uncomment the following line if you do not want to return any records when validation fails
            // $query->where('0=1');
            return $dataProvider;
        }

        // grid filtering conditions
        $query->andFilterWhere([
            'id_responden' => $this->id_responden,
            'id_surveyor' => $this->id_surveyor,
            'lat' => $this->lat,
            'lang' => $this->lang,
            'create_at' => $this->create_at,
        ]);

        $query->andFilterWhere(['like', 'nama_responden', $this->nama_responden])
            ->andFilterWhere(['like', 'alamat', $this->alamat])
            ->andFilterWhere(['like', 'provinsi', $this->provinsi])
            ->andFilterWhere(['like', 'kab_kota', $this->kab_kota])
            ->andFilterWhere(['like', 'kecamatan', $this->kecamatan])
            ->andFilterWhere(['like', 'kel_desa', $this->kel_desa])
            ->andFilterWhere(['like', 'rt', $this->rt])
            ->andFilterWhere(['like', 'rw', $this->rw])
            ->andFilterWhere(['like', 'no_hp', $this->no_hp])
            ->andFilterWhere(['like', 'pertanyaan_12', $this->pertanyaan_12])
            ->andFilterWhere(['like', 'pertanyaan_13', $this->pertanyaan_13])
            ->andFilterWhere(['like', 'pertanyaan_14', $this->pertanyaan_14])
            ->andFilterWhere(['like', 'pertanyaan_15', $this->pertanyaan_15])
            ->andFilterWhere(['like', 'pertanyaan_16', $this->pertanyaan_16])
            ->andFilterWhere(['like', 'pertanyaan_17', $this->pertanyaan_17])
            ->andFilterWhere(['like', 'pertanyaan_18', $this->pertanyaan_18])
            ->andFilterWhere(['like', 'pertanyaan_19', $this->pertanyaan_19])
            ->andFilterWhere(['like', 'pertanyaan_20', $this->pertanyaan_20])
            ->andFilterWhere(['like', 'pertanyaan_21', $this->pertanyaan_21])
            ->andFilterWhere(['like', 'pertanyaan_22', $this->pertanyaan_22])
            ->andFilterWhere(['like', 'pertanyaan_23', $this->pertanyaan_23])
            ->andFilterWhere(['like', 'pertanyaan_24', $this->pertanyaan_24])
            ->andFilterWhere(['like', 'pertanyaan_25', $this->pertanyaan_25])
            ->andFilterWhere(['like', 'pertanyaan_26', $this->pertanyaan_26])
            ->andFilterWhere(['like', 'pertanyaan_27', $this->pertanyaan_27])
            ->andFilterWhere(['like', 'pertanyaan_28', $this->pertanyaan_28])
            ->andFilterWhere(['like', 'pertanyaan_29', $this->pertanyaan_29])
            ->andFilterWhere(['like', 'pertanyaan_30', $this->pertanyaan_30])
            ->andFilterWhere(['like', 'pertanyaan_31', $this->pertanyaan_31])
            ->andFilterWhere(['like', 'pertanyaan_32', $this->pertanyaan_32])
            ->andFilterWhere(['like', 'pertanyaan_33', $this->pertanyaan_33])
            ->andFilterWhere(['like', 'pertanyaan_34', $this->pertanyaan_34])
            ->andFilterWhere(['like', 'pertanyaan_35', $this->pertanyaan_35])
            ->andFilterWhere(['like', 'pertanyaan_36', $this->pertanyaan_36])
            ->andFilterWhere(['like', 'pertanyaan_37', $this->pertanyaan_37])
            ->andFilterWhere(['like', 'pertanyaan_38', $this->pertanyaan_38])
            ->andFilterWhere(['like', 'pertanyaan_39', $this->pertanyaan_39])
            ->andFilterWhere(['like', 'pertanyaan_40', $this->pertanyaan_40]);

        return $dataProvider;
    }
}
