<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "tb_kelurahan".
 *
 * @property int $id_kelurahan
 * @property string $nama
 * @property int $id_kec
 *
 * @property TbKecamatan $kec
 */
class Kelurahan extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'tb_kelurahan';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['nama', 'id_kec'], 'required'],
            [['id_kec'], 'integer'],
            [['nama'], 'string', 'max' => 100],
            [['id_kec'], 'exist', 'skipOnError' => true, 'targetClass' => Kecamatan::className(), 'targetAttribute' => ['id_kec' => 'id_kecamatan']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_kelurahan' => 'Id Kelurahan',
            'nama' => 'Nama',
            'id_kec' => 'Id Kec',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKec()
    {
        return $this->hasOne(Kecamatan::className(), ['id_kecamatan' => 'id_kec']);
    }
}
