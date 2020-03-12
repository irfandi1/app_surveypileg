<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "tb_kecamatan".
 *
 * @property int $id_kecamatan
 * @property string $nama
 * @property int $id_kabkota
 * @property int $dapil
 *
 * @property TbKabkota $kabkota
 * @property TbKelurahan[] $tbKelurahans
 */
class Kecamatan extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'tb_kecamatan';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['nama', 'id_kabkota'], 'required'],
            [['id_kabkota', 'dapil'], 'integer'],
            [['nama'], 'string', 'max' => 100],
            [['id_kabkota'], 'exist', 'skipOnError' => true, 'targetClass' => Kabkota::className(), 'targetAttribute' => ['id_kabkota' => 'id_kabkota']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_kecamatan' => 'Id Kecamatan',
            'nama' => 'Nama',
            'id_kabkota' => 'Id Kabkota',
            'dapil' => 'Dapil',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getKabkota()
    {
        return $this->hasOne(Kabkota::className(), ['id_kabkota' => 'id_kabkota']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getTbKelurahans()
    {
        return $this->hasMany(Kelurahan::className(), ['id_kec' => 'id_kecamatan']);
    }
}
