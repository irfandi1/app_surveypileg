<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "surveyor".
 *
 * @property int $id_surveyor
 * @property string $nama_petugas
 * @property string $username
 * @property string $password
 * @property string $jenis_kelamin
 * @property string $no_hp
 * @property string $alamat
 * @property string $status
 * @property string $created_at
 * @property string $created_update
 *
 * @property Responden[] $respondens
 */
class Surveyor extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'surveyor';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['nama_petugas', 'username', 'password', 'jenis_kelamin', 'no_hp', 'alamat', 'status'], 'required'],
            [['jenis_kelamin', 'status'], 'string'],
            [['created_at', 'created_update'], 'safe'],
            [['nama_petugas', 'username', 'password', 'alamat'], 'string', 'max' => 150],
            [['no_hp'], 'string', 'max' => 13],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_surveyor' => 'Id Surveyor',
            'nama_petugas' => 'Nama Petugas',
            'username' => 'Username',
            'password' => 'Password',
            'jenis_kelamin' => 'Jenis Kelamin',
            'no_hp' => 'No Hp',
            'alamat' => 'Alamat',
            'status' => 'Status',
            'created_at' => 'Created At',
            'created_update' => 'Created Update',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getRespondens()
    {
        return $this->hasMany(Responden::className(), ['id_surveyor' => 'id_surveyor']);
    }
}
