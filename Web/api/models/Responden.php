<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "responden".
 *
 * @property int $id_responden
 * @property int $id_surveyor
 * @property string $nama_responden
 * @property string $alamat
 * @property string $provinsi
 * @property string $kab_kota
 * @property string $kecamatan
 * @property string $kel_desa
 * @property string $rt
 * @property string $rw
 * @property string $no_hp
 * @property string $pertanyaan_12
 * @property string $pertanyaan_13
 * @property string $pertanyaan_14
 * @property string $pertanyaan_15
 * @property string $pertanyaan_16
 * @property string $pertanyaan_17
 * @property string $pertanyaan_18
 * @property string $pertanyaan_19
 * @property string $pertanyaan_20
 * @property string $pertanyaan_21
 * @property string $pertanyaan_22
 * @property string $pertanyaan_23
 * @property string $pertanyaan_24
 * @property string $pertanyaan_25
 * @property string $pertanyaan_26
 * @property string $pertanyaan_27
 * @property string $pertanyaan_28
 * @property string $pertanyaan_29
 * @property string $pertanyaan_30
 * @property string $pertanyaan_31
 * @property string $pertanyaan_32
 * @property string $pertanyaan_33
 * @property string $pertanyaan_34
 * @property string $pertanyaan_35
 * @property string $pertanyaan_36
 * @property string $pertanyaan_37
 * @property string $pertanyaan_38
 * @property string $pertanyaan_39
 * @property string $pertanyaan_40
 * @property double $lat
 * @property double $lang
 * @property string $create_at
 *
 * @property Surveyor $surveyor
 */
class Responden extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'responden';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['id_surveyor', 'nama_responden', 'alamat', 'provinsi', 'kab_kota', 'kecamatan', 'kel_desa', 'rt', 'rw', 'no_hp', 'pertanyaan_12', 'pertanyaan_13', 'pertanyaan_14', 'pertanyaan_15', 'pertanyaan_16', 'pertanyaan_17', 'pertanyaan_18', 'pertanyaan_19', 'pertanyaan_20', 'pertanyaan_21', 'pertanyaan_22', 'pertanyaan_23', 'pertanyaan_24', 'pertanyaan_25', 'pertanyaan_26', 'pertanyaan_27', 'pertanyaan_28', 'pertanyaan_29', 'pertanyaan_30', 'pertanyaan_31', 'pertanyaan_32', 'pertanyaan_33', 'pertanyaan_34', 'pertanyaan_35', 'pertanyaan_36', 'pertanyaan_37', 'pertanyaan_38', 'pertanyaan_39', 'pertanyaan_40', 'lat', 'lang'], 'required'],
            [['id_surveyor'], 'integer'],
            [['lat', 'lang'], 'number'],
            [['create_at'], 'safe'],
            [['nama_responden', 'alamat', 'provinsi', 'kab_kota', 'kecamatan', 'kel_desa', 'rt', 'rw', 'no_hp', 'pertanyaan_12', 'pertanyaan_13', 'pertanyaan_14', 'pertanyaan_15', 'pertanyaan_16', 'pertanyaan_17', 'pertanyaan_18', 'pertanyaan_19', 'pertanyaan_20', 'pertanyaan_21', 'pertanyaan_22', 'pertanyaan_23', 'pertanyaan_24', 'pertanyaan_25', 'pertanyaan_26', 'pertanyaan_27', 'pertanyaan_28', 'pertanyaan_29', 'pertanyaan_30', 'pertanyaan_31', 'pertanyaan_32', 'pertanyaan_33', 'pertanyaan_34', 'pertanyaan_35', 'pertanyaan_36', 'pertanyaan_37', 'pertanyaan_38', 'pertanyaan_39', 'pertanyaan_40'], 'string', 'max' => 900],
            [['id_surveyor'], 'exist', 'skipOnError' => true, 'targetClass' => Surveyor::className(), 'targetAttribute' => ['id_surveyor' => 'id_surveyor']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id_responden' => 'Id Responden',
            'id_surveyor' => 'Id Surveyor',
            'nama_responden' => 'Nama Responden',
            'alamat' => 'Alamat',
            'provinsi' => 'Provinsi',
            'kab_kota' => 'Kab Kota',
            'kecamatan' => 'Kecamatan',
            'kel_desa' => 'Kel Desa',
            'rt' => 'Rt',
            'rw' => 'Rw',
            'no_hp' => 'No Hp',
            // 'nama_kk' => 'Nama Kk',
            // 'no_urut_responden' => 'No Urut Responden',
            'pertanyaan_12' => 'Apakah Bpk/Ibu/Sdr sudah terdaftar di DPT untuk Pemilu bulan April 2019 ?',
            'pertanyaan_13' => 'Apakah Bpk/Ibu/Sdr menjadi PEMILIH pada Pemilu tahun 2014 ?',
            'pertanyaan_14' => 'Kenapa Bpk/Ibu/Sdr tidak menggunakan hak pilih pada Pemilu 2014 ?',
            'pertanyaan_15' => 'Apakah Bpk/Ibu/Sdr akan gunakan hak pilih Bpk/Ibu/Sdr pada pemilu April 2019 ?',
            'pertanyaan_16' => 'Jenis kelamin',
            'pertanyaan_17' => 'Usia :',
            'pertanyaan_18' => 'Agama :',
            'pertanyaan_19' => 'Bila Islam, apakah Bpk/Ibu/Sdr shalat 5 waktu ?',
            'pertanyaan_20' => 'Apakah Bpk/Ibu/Sdr suka mengikuti pengajian rutin ?',
            'pertanyaan_21' => 'Tanggapan Bpk/Ibu/Sdr terhadap gerakan 212 ?',
            'pertanyaan_22' => 'Pendidikan :',
            'pertanyaan_23' => 'Suku :',
            'pertanyaan_24' => 'Pekerjaan utama :',
            'pertanyaan_25' => 'Keanggotaan dalam organisasi utama :',
            'pertanyaan_26' => 'Status sosial yang utama di masyarakat :',
            'pertanyaan_27' => 'Kelas pendapatan :',
            'pertanyaan_28' => 'Dari mana saja Bpk/Ibu/Sdr mendapatkan informasi politik dan seputar Pemilu ?',
            'pertanyaan_29' => 'Apakah Bpk/Ibu/Sdr tahu akan diadakan Pemilu pada bulan April 2019 ?',
            'pertanyaan_30' => 'Apakah Bpk/Ibu/Sdr tahu jumlah partai peserta pada Pemilu bulan 2019 ?',
            'pertanyaan_32' => 'Partai apa saja yang paling Bpk/Ibu/Sdr kenal ?',
            'pertanyaan_32' => 'Partai apa saja yang kurang Bpk/Ibu/Sdr kenal ?',
            'pertanyaan_33' => 'Partai apa saja yang belum Bpk/Ibu/Sdr kenal ?',
            'pertanyaan_34' => 'Dari 16 partai peserta pemilu, sebutkan 5 partai yang Bpk/Ibu/Sdr suka ?',
            'pertanyaan_35' => 'Dari 16 partai peserta pemilu, sebutkan 5 partai yang tidak Bpk/Ibu/Sdr sukai ?',
            'pertanyaan_36' => 'Partai apa yang pada Pemilu lalu Bpk/Ibu/Sdr pilih ?',
            'pertanyaan_37' => 'Bagaimana pendirian Bpk/Ibu/Sdr untuk memilih dalam Pemilu yang akan datang ?',
            'pertanyaan_38' => 'Partai apa pada pemilu yang akan datang dipertimbangkan untuk Bpk/Ibu/Sdr pilih ?',
            'pertanyaan_39' => 'Apa alasannya ?',
            'pertanyaan_40' => 'Apakah Bpk/Ibu/Sdr sudah tahu nama-nama calon anggota legislatif dari DAPIL Bpk/Ibu/Sdr ?',
            // 'pertanyaan_41' => 'Apakah Bpk/Ibu/Sdr sudah tahu dengan orang-orang ini ?',
            // 'pertanyaan_42' => 'Apakah Bpk/Ibu/Sdr sudah kenal dengan nama-nama orang ini ?',
            // 'pertanyaan_43' => 'Bila sudah kenal, sejak kapan ?',
            // 'pertanyaan_44' => 'Melalui apa Bpk/Ibu/Sdr mengenalnya ?',
            // 'pertanyaan_45' => 'Bila diadakah pemilihan saat ini, Bpk/Ibu/Sdr akan memilih siapa ?',
            // 'pertanyaan_46' => 'Permasalahan atau isu apa yang paling menarik perhatian Bpk/Ibu/Sdr di tingkat nasional? Pilih 5 buah ?',
            // 'pertanyaan_47' => 'Permasalahan atau isu apa yang paling menarik perhatian Bpk/Ibu/Sdr di tingkat provinsi & kabupaten/kota? Pilih 5 buah',
            // 'pertanyaan_48' => 'Permasalahan atau isu apa yang paling menarik perhatian Bpk/Ibu/Sdr di tingkat RT tempat Bpk/Ibu/Sdr tinggal? Pilih 3-5 buah.',
            // 'pertanyaan_49' => 'Bagaimana bentuk solusi yang Bpk/Ibu/Sdr harapkan untuk mengatasi masalah di tingkat nasional ?',
            // 'pertanyaan_50' => 'Bagaimana bentuk solusi yang Bpk/Ibu/Sdr harapkan untuk mengatasi masalah di tingkat provinsi & Kabupaten dan Kota ?',
            // 'pertanyaan_51' => 'Bagaimana bentuk solusi yang Bpk/Ibu/Sdr harapkan untuk mengatasi masalah di tingkat RT ?',
            // 'pertanyaan_52' => 'Figur Caleg yang Bpk/Ibu/Sdr sukai',
            // 'pertanyaan_53' => 'Bentuk pendekatan atau kampanye bagaimana yang Bpk/Ibu/Sdr sukai dari para Caleg?',
            // 'pertanyaan_54' => 'Bagaimana penilaian Bpk/Ibu/Sdr terhadap kinerja Presiden Jokowi – JK hingga saat ini ?',
            // 'pertanyaan_55' => 'Siapa yang akan Bpk/Ibu/Sdr pilih dalam Pilpres yang akan datang ?',
            // 'pertanyaan_56' => 'Apa alasan Bpk/Ibu/Sdr dalam menentukan pilihan tersebut ?',
            'lat' => 'Lat',
            'lang' => 'Lang',
            'create_at' => 'Create At',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getSurveyor()
    {
        return $this->hasOne(Surveyor::className(), ['id_surveyor' => 'id_surveyor']);
    }
   
}
