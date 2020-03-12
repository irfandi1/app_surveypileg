<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "tb_kabkota".
 *
 * @property int $id_kabkota
 * @property string $nama
 * @property int $id_provinsi
 * @property int $dapil
 *
 * @property TbProvinsi $provinsi
 * @property TbKecamatan[] $tbKecamatans
 */
class Kabkota extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'tb_kabkota';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['nama', 'id_provinsi', 'dapil'], 'required'],
            [['id_provinsi', 'dapil'], 'integer'],
            [['nama'], 'string', 'max' => 100],
            [['id_provinsi'], 'exist', 'skipOnError' => true, 'targetClass' => Provinsi::className(), 'targetAttribute' => ['id_provinsi' => 'id_provinsi']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_kabkota' => 'Id Kabkota',
            'nama' => 'Nama',
            'id_provinsi' => 'Id Provinsi',
            'dapil' => 'Dapil',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getProvinsi()
    {
        return $this->hasOne(Provinsi::className(), ['id_provinsi' => 'id_provinsi']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getTbKecamatans()
    {
        return $this->hasMany(Kecamatan::className(), ['id_kabkota' => 'id_kabkota']);
    }
}
