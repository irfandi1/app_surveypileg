<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "tb_provinsi".
 *
 * @property int $id_provinsi
 * @property string $nama
 * @property double $lat
 * @property double $lng
 *
 * @property TbKabkota[] $tbKabkotas
 */
class Provinsi extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'tb_provinsi';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['id_provinsi', 'nama', 'lat', 'lng'], 'required'],
            [['id_provinsi'], 'integer'],
            [['nama'], 'string'],
            [['lat', 'lng'], 'number'],
            [['id_provinsi'], 'unique'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_provinsi' => 'Id Provinsi',
            'nama' => 'Nama',
            'lat' => 'Lat',
            'lng' => 'Lng',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getTbKabkotas()
    {
        return $this->hasMany(Kabkota::className(), ['id_provinsi' => 'id_provinsi']);
    }
}
