<?php

namespace app\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use app\models\Surveyor;

/**
 * SurveyorSeacrh represents the model behind the search form of `app\models\Surveyor`.
 */
class SurveyorSeacrh extends Surveyor
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['id_surveyor'], 'integer'],
            [['nama_petugas', 'username', 'password', 'jenis_kelamin', 'no_hp', 'alamat', 'created_at', 'created_update'], 'safe'],
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
        $query = Surveyor::find();

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
            'id_surveyor' => $this->id_surveyor,
            'created_at' => $this->created_at,
            'created_update' => $this->created_update,
        ]);

        $query->andFilterWhere(['like', 'nama_petugas', $this->nama_petugas])
            ->andFilterWhere(['like', 'username', $this->username])
            ->andFilterWhere(['like', 'password', $this->password])
            ->andFilterWhere(['like', 'jenis_kelamin', $this->jenis_kelamin])
            ->andFilterWhere(['like', 'no_hp', $this->no_hp])
            ->andFilterWhere(['like', 'alamat', $this->alamat]);

        return $dataProvider;
    }
}
