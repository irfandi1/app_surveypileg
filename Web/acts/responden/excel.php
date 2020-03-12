<?php
// Load file koneksi.php
    include "../../config/function.php";
    // Load plugin PHPExcel nya
    require_once '../../PHPExcel/PHPExcel.php';
    // Panggil class PHPExcel nya
    $excel = new PHPExcel();
    // Settingan awal file excel
    $excel->getProperties()->setCreator('My Notes Code')
                ->setLastModifiedBy('My Notes Code')
                ->setTitle("Data Survey")
                ->setSubject("Survey")
                ->setDescription("Laporan Semua Data Survey")
                ->setKeywords("Data Survey");
    // Buat sebuah variabel untuk menampung pengaturan style dari header tabel
    $style_col = array(
    'font' => array('bold' => true), // Set font nya jadi bold
    'alignment' => array(
        'horizontal' => PHPExcel_Style_Alignment::HORIZONTAL_CENTER, // Set text jadi ditengah secara horizontal (center)
        'vertical' => PHPExcel_Style_Alignment::VERTICAL_CENTER // Set text jadi di tengah secara vertical (middle)
    ),
    'borders' => array(
        'top' => array('style'  => PHPExcel_Style_Border::BORDER_THIN), // Set border top dengan garis tipis
        'right' => array('style'  => PHPExcel_Style_Border::BORDER_THIN),  // Set border right dengan garis tipis
        'bottom' => array('style'  => PHPExcel_Style_Border::BORDER_THIN), // Set border bottom dengan garis tipis
        'left' => array('style'  => PHPExcel_Style_Border::BORDER_THIN) // Set border left dengan garis tipis
    )
    );
    // Buat sebuah variabel untuk menampung pengaturan style dari isi tabel
    $style_row = array(
    'alignment' => array(
        'vertical' => PHPExcel_Style_Alignment::VERTICAL_CENTER // Set text jadi di tengah secara vertical (middle)
    ),
    'borders' => array(
        'top' => array('style'  => PHPExcel_Style_Border::BORDER_THIN), // Set border top dengan garis tipis
        'right' => array('style'  => PHPExcel_Style_Border::BORDER_THIN),  // Set border right dengan garis tipis
        'bottom' => array('style'  => PHPExcel_Style_Border::BORDER_THIN), // Set border bottom dengan garis tipis
        'left' => array('style'  => PHPExcel_Style_Border::BORDER_THIN) // Set border left dengan garis tipis
    )
    );
    $excel->setActiveSheetIndex(0)->setCellValue('A1', "DATA HASIL SURVEY POPULARITAS JELANG PILEG"); // Set kolom A1 dengan tulisan "DATA SISWA"
    $excel->getActiveSheet()->mergeCells('A1:F1'); // Set Merge Cell pada kolom A1 sampai F1
    $excel->getActiveSheet()->getStyle('A1')->getFont()->setBold(TRUE); // Set bold kolom A1
    $excel->getActiveSheet()->getStyle('A1')->getFont()->setSize(15); // Set font size 15 untuk kolom A1
    $excel->getActiveSheet()->getStyle('A1')->getAlignment()->setHorizontal(PHPExcel_Style_Alignment::HORIZONTAL_CENTER); // Set text center untuk kolom A1
    // Buat header tabel nya pada baris ke 3
    $excel->setActiveSheetIndex(0)->setCellValue('A3', "No"); // Set kolom A3 dengan tulisan "NO"
    $excel->setActiveSheetIndex(0)->setCellValue('B3', "Nama Petugas/Surveyor"); // Set kolom B3 dengan tulisan "NIS"
    $excel->setActiveSheetIndex(0)->setCellValue('C3', "No urut Responden"); // Set kolom C3 dengan tulisan "NAMA"
    $excel->setActiveSheetIndex(0)->setCellValue('D3', "Nama Responden"); // Set kolom D3 dengan tulisan "JENIS KELAMIN"
    $excel->setActiveSheetIndex(0)->setCellValue('E3', "Alamat"); // Set kolom E3 dengan tulisan "TELEPON"
    $excel->setActiveSheetIndex(0)->setCellValue('F3', "Provinsi"); // Set kolom F3 dengan tulisan "ALAMAT"
    $excel->setActiveSheetIndex(0)->setCellValue('G3', "Kabupaten/Kota");
    $excel->setActiveSheetIndex(0)->setCellValue('H3', "Kecamatan");
    $excel->setActiveSheetIndex(0)->setCellValue('I3', "Kelurahan/Desa");
    $excel->setActiveSheetIndex(0)->setCellValue('J3', "RT");
    $excel->setActiveSheetIndex(0)->setCellValue('K3', "RW");
    $excel->setActiveSheetIndex(0)->setCellValue('L3', "No Hp");
    $excel->setActiveSheetIndex(0)->setCellValue('M3', "12. Apakah Bpk/Ibu/Sdr sudah terdaftar di DPT untuk Pemilu bulan April 2019 ?");
    $excel->setActiveSheetIndex(0)->setCellValue('N3', "13. Apakah Bpk/Ibu/Sdr akan gunakan hak pilih pada pemilu April 2019?");
    $excel->setActiveSheetIndex(0)->setCellValue('O3', "14. Jenis Kelamin :");
    $excel->setActiveSheetIndex(0)->setCellValue('P3', "15. Usia :");
    $excel->setActiveSheetIndex(0)->setCellValue('Q3', "16. Agama :");
    $excel->setActiveSheetIndex(0)->setCellValue('R3', "17. Bila Islam, apakah Bpk/Ibu/Sdr shalat 5 waktu ?");
    $excel->setActiveSheetIndex(0)->setCellValue('S3', "18. Apakah Bpk/Ibu/Sdr suka mengikuti pengajian rutin ?");
    $excel->setActiveSheetIndex(0)->setCellValue('T3', "19.Pendidikan :");
    $excel->setActiveSheetIndex(0)->setCellValue('U3', "20. Suku :");
    $excel->setActiveSheetIndex(0)->setCellValue('V3', "21. Pekerjaan Utama :");
    $excel->setActiveSheetIndex(0)->setCellValue('W3', "22. Ketokohan di masyarakat :");
    $excel->setActiveSheetIndex(0)->setCellValue('X3', "23. Kelas pendapatan :");
    $excel->setActiveSheetIndex(0)->setCellValue('Y3', "24. Dari mana saja Bpk/Ibu/Sdr mendapatkan informasi politik dan seputar Pemilu ?");
    $excel->setActiveSheetIndex(0)->setCellValue('Z3', "25. jumlah partai peserta pemilu 2019 ada 16 partai Partai apa saja yang paling Bpk/Ibu/Sdr kenal?");
    $excel->setActiveSheetIndex(0)->setCellValue('AA3', "26. Apakah Bapak Ibu mengenal lambang partai ini?");
    $excel->setActiveSheetIndex(0)->setCellValue('AB3', "27. Dari partai peserta pemilu yang Bpk/Ibu/Sdr kenal ingat, sebutkan 3 partai yang di suka?");
    $excel->setActiveSheetIndex(0)->setCellValue('AC3', "28. Partai apa yang pada Pemilu lalu Bpk/Ibu/Sdr pilih?");
    $excel->setActiveSheetIndex(0)->setCellValue('AD3', "29. Partai apa yang pada pemilu datang dipertimbangkan untuk Bpk/Ibu/Sdr pilih ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AE3', "30. Apa alasannya ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AF3', "31. Apakah Bpk/Ibu/Sdr sudah tahu/kenal dengan orang-orang ini ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AG3', "32. Melalui apa Bpk/Ibu/Sdr mengenalnya?");
    $excel->setActiveSheetIndex(0)->setCellValue('AH3', "33. Bila diadakan pemilihan saat ini Bpk/Ibu/Sdr akan memilih siapa ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AI3', "34. Permasalahan atau isu apa yang paling menarik perhatian Bpk/Ibu/Sdr di tingkat provinsi dan kabupaten/kota ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AJ3', "35. Permasalahan atau isu apa yang paling menarik perhatian Bpk/Ibu/Sdr di tingkat RT tempat Bpk/Ibu/Sdr tinggal ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AK3', "36. Alasan Bpk/Ibu/Sdr memilih caleg ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AL3', "37. Bentuk pendekatan atau kampanye bagaimana yang Bpk/Ibu/Sdr sukai dari para Caleg?");
    $excel->setActiveSheetIndex(0)->setCellValue('AM3', "38. Bagaimana penilaian Bpk/Ibu/Sdr terhadap kinerja Presiden Jokowi - JK hingga saat ini ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AN3', "39. Siapa yang akan Bpk/Ibu/Sdr pilih dalam pilpres yang akan datang ?");
    $excel->setActiveSheetIndex(0)->setCellValue('AO3', "40. Apa alasan Bpk/Ibu/Sdr dalam menentukan pilihan tersebut?");
    // Apply style header yang telah kita buat tadi ke masing-masing kolom header
    $excel->getActiveSheet()->getStyle('A3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('B3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('C3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('D3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('E3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('F3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('G3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('H3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('I3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('J3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('K3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('L3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('M3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('N3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('O3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('P3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('Q3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('R3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('S3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('T3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('U3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('V3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('W3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('X3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('Y3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('Z3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AA3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AB3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AC3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AD3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AE3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AF3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AG3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AH3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AI3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AJ3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AK3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AL3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AM3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AN3')->applyFromArray($style_col);
    $excel->getActiveSheet()->getStyle('AO3')->applyFromArray($style_col);

    // Set height baris ke 1, 2 dan 3
    $excel->getActiveSheet()->getRowDimension('1')->setRowHeight(20);
    $excel->getActiveSheet()->getRowDimension('2')->setRowHeight(20);
    $excel->getActiveSheet()->getRowDimension('3')->setRowHeight(20);

    // Buat query untuk menampilkan semua data siswa
    $sql = mysqli_query($conn, "SELECT * FROM responden INNER JOIN surveyor ON surveyor.id_surveyor = responden.id_surveyor");
    // $sql->execute(); // Eksekusi querynya


    $no = 1; // Untuk penomoran tabel, di awal set dengan 1
    $numrow = 4; // Set baris pertama untuk isi tabel adalah baris ke 4

    while($data = mysqli_fetch_array($sql)){ 
    
    // while($data = $sql->fetch()){ // Ambil semua data dari hasil eksekusi $sql
    $excel->setActiveSheetIndex(0)->setCellValue('A'.$numrow, $no);
    $excel->setActiveSheetIndex(0)->setCellValue('B'.$numrow, $data['nama_petugas']);
    $excel->setActiveSheetIndex(0)->setCellValue('C'.$numrow, $data['id_responden']);
    $excel->setActiveSheetIndex(0)->setCellValue('D'.$numrow, $data['nama_responden']);
    // Khusus untuk no telepon. kita set type kolom nya jadi STRING
    $excel->setActiveSheetIndex(0)->setCellValueExplicit('E'.$numrow, $data['alamat'], PHPExcel_Cell_DataType::TYPE_STRING);
    $excel->setActiveSheetIndex(0)->setCellValue('F'.$numrow, $data['provinsi']);
    $excel->setActiveSheetIndex(0)->setCellValue('G'.$numrow, $data['kab_kota']);
    $excel->setActiveSheetIndex(0)->setCellValue('H'.$numrow, $data['kecamatan']);
    $excel->setActiveSheetIndex(0)->setCellValue('I'.$numrow, $data['kel_desa']);
    $excel->setActiveSheetIndex(0)->setCellValue('J'.$numrow, $data['rt']);
    $excel->setActiveSheetIndex(0)->setCellValue('K'.$numrow, $data['rw']);
    $excel->setActiveSheetIndex(0)->setCellValue('L'.$numrow, $data['no_hp']);
    $excel->setActiveSheetIndex(0)->setCellValue('M'.$numrow, $data['pertanyaan_12']);
    $excel->setActiveSheetIndex(0)->setCellValue('N'.$numrow, $data['pertanyaan_13']);
    $excel->setActiveSheetIndex(0)->setCellValue('O'.$numrow, $data['pertanyaan_14']);
    $excel->setActiveSheetIndex(0)->setCellValue('P'.$numrow, $data['pertanyaan_15']);
    $excel->setActiveSheetIndex(0)->setCellValue('Q'.$numrow, $data['pertanyaan_16']);
    $excel->setActiveSheetIndex(0)->setCellValue('R'.$numrow, $data['pertanyaan_17']);
    $excel->setActiveSheetIndex(0)->setCellValue('S'.$numrow, $data['pertanyaan_18']);
    $excel->setActiveSheetIndex(0)->setCellValue('T'.$numrow, $data['pertanyaan_19']);
    $excel->setActiveSheetIndex(0)->setCellValue('U'.$numrow, $data['pertanyaan_20']);
    $excel->setActiveSheetIndex(0)->setCellValue('V'.$numrow, $data['pertanyaan_21']);
    $excel->setActiveSheetIndex(0)->setCellValue('W'.$numrow, $data['pertanyaan_22']);
    $excel->setActiveSheetIndex(0)->setCellValue('X'.$numrow, $data['pertanyaan_23']);
    $excel->setActiveSheetIndex(0)->setCellValue('Y'.$numrow, $data['pertanyaan_24']);
    $excel->setActiveSheetIndex(0)->setCellValue('Z'.$numrow, $data['pertanyaan_25']);
    $excel->setActiveSheetIndex(0)->setCellValue('AA'.$numrow, $data['pertanyaan_26']);
    $excel->setActiveSheetIndex(0)->setCellValue('AB'.$numrow, $data['pertanyaan_27']);
    $excel->setActiveSheetIndex(0)->setCellValue('AC'.$numrow, $data['pertanyaan_28']);
    $excel->setActiveSheetIndex(0)->setCellValue('AD'.$numrow, $data['pertanyaan_29']);
    $excel->setActiveSheetIndex(0)->setCellValue('AE'.$numrow, $data['pertanyaan_30']);
    $excel->setActiveSheetIndex(0)->setCellValue('AF'.$numrow, $data['pertanyaan_31']);
    $excel->setActiveSheetIndex(0)->setCellValue('AG'.$numrow, $data['pertanyaan_32']);
    $excel->setActiveSheetIndex(0)->setCellValue('AH'.$numrow, $data['pertanyaan_33']);
    $excel->setActiveSheetIndex(0)->setCellValue('AI'.$numrow, $data['pertanyaan_34']);
    $excel->setActiveSheetIndex(0)->setCellValue('AJ'.$numrow, $data['pertanyaan_35']);
    $excel->setActiveSheetIndex(0)->setCellValue('AK'.$numrow, $data['pertanyaan_36']);
    $excel->setActiveSheetIndex(0)->setCellValue('AL'.$numrow, $data['pertanyaan_37']);
    $excel->setActiveSheetIndex(0)->setCellValue('AM'.$numrow, $data['pertanyaan_38']);
    $excel->setActiveSheetIndex(0)->setCellValue('AN'.$numrow, $data['pertanyaan_39']);
    $excel->setActiveSheetIndex(0)->setCellValue('AO'.$numrow, $data['pertanyaan_40']);


    // Apply style row yang telah kita buat tadi ke masing-masing baris (isi tabel)
    $excel->getActiveSheet()->getStyle('A'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('B'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('C'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('D'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('E'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('F'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('G'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('H'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('I'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('J'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('K'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('L'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('M'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('N'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('O'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('P'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('Q'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('R'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('S'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('T'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('U'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('V'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('W'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('X'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('Y'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('Z'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AA'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AB'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AC'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AD'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AE'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AF'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AG'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AH'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AI'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AJ'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AK'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AL'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AM'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AN'.$numrow)->applyFromArray($style_row);
    $excel->getActiveSheet()->getStyle('AO'.$numrow)->applyFromArray($style_row);
    
    $excel->getActiveSheet()->getRowDimension($numrow)->setRowHeight(20);
    
    $no++; // Tambah 1 setiap kali looping
    $numrow++; // Tambah 1 setiap kali looping
    }
    // Set width kolom
    $excel->getActiveSheet()->getColumnDimension('A')->setWidth(5); // Set width kolom A
    $excel->getActiveSheet()->getColumnDimension('B')->setWidth(25); // Set width kolom B
    $excel->getActiveSheet()->getColumnDimension('C')->setWidth(30); // Set width kolom C
    $excel->getActiveSheet()->getColumnDimension('D')->setWidth(25); // Set width kolom D
    $excel->getActiveSheet()->getColumnDimension('E')->setWidth(20); // Set width kolom E
    $excel->getActiveSheet()->getColumnDimension('F')->setWidth(15); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('G')->setWidth(30); // Set width kolom A
    $excel->getActiveSheet()->getColumnDimension('H')->setWidth(25); // Set width kolom B
    $excel->getActiveSheet()->getColumnDimension('I')->setWidth(30); // Set width kolom C
    $excel->getActiveSheet()->getColumnDimension('J')->setWidth(10); // Set width kolom D
    $excel->getActiveSheet()->getColumnDimension('K')->setWidth(10); // Set width kolom E
    $excel->getActiveSheet()->getColumnDimension('L')->setWidth(35); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('M')->setWidth(75); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('N')->setWidth(70); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('O')->setWidth(20); // Set width kolom B
    $excel->getActiveSheet()->getColumnDimension('P')->setWidth(20); // Set width kolom C
    $excel->getActiveSheet()->getColumnDimension('Q')->setWidth(20); // Set width kolom D
    $excel->getActiveSheet()->getColumnDimension('R')->setWidth(50); // Set width kolom E
    $excel->getActiveSheet()->getColumnDimension('S')->setWidth(55); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('T')->setWidth(40); // Set width kolom A
    $excel->getActiveSheet()->getColumnDimension('U')->setWidth(25); // Set width kolom B
    $excel->getActiveSheet()->getColumnDimension('V')->setWidth(50); // Set width kolom C
    $excel->getActiveSheet()->getColumnDimension('W')->setWidth(45); // Set width kolom D
    $excel->getActiveSheet()->getColumnDimension('X')->setWidth(20); // Set width kolom E
    $excel->getActiveSheet()->getColumnDimension('Y')->setWidth(75); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('Z')->setWidth(70); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('AA')->setWidth(50); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('AB')->setWidth(90); // Set width kolom B
    $excel->getActiveSheet()->getColumnDimension('AC')->setWidth(55); // Set width kolom C
    $excel->getActiveSheet()->getColumnDimension('AD')->setWidth(80); // Set width kolom D
    $excel->getActiveSheet()->getColumnDimension('AE')->setWidth(65); // Set width kolom E
    $excel->getActiveSheet()->getColumnDimension('AF')->setWidth(70); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('AG')->setWidth(45); // Set width kolom A
    $excel->getActiveSheet()->getColumnDimension('AH')->setWidth(65); // Set width kolom B
    $excel->getActiveSheet()->getColumnDimension('AI')->setWidth(80); // Set width kolom C
    $excel->getActiveSheet()->getColumnDimension('AJ')->setWidth(95); // Set width kolom D
    $excel->getActiveSheet()->getColumnDimension('AK')->setWidth(55); // Set width kolom E
    $excel->getActiveSheet()->getColumnDimension('AL')->setWidth(95); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('AM')->setWidth(90); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('AN')->setWidth(80); // Set width kolom F
    $excel->getActiveSheet()->getColumnDimension('AO')->setWidth(150); // Set width kolom F
    
    // Set orientasi kertas jadi LANDSCAPE
    $excel->getActiveSheet()->getPageSetup()->setOrientation(PHPExcel_Worksheet_PageSetup::ORIENTATION_LANDSCAPE);
    // Set judul file excel nya
    
    $excel->getActiveSheet(0)->setTitle("Laporan Data Transaksi");
    $excel->setActiveSheetIndex(0);
    PHPExcel_Shared_Font::setAutoSizeMethod(PHPExcel_Shared_Font::AUTOSIZE_METHOD_EXACT);
    // Proses file excel
    header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
    header('Content-Disposition: attachment; filename="Data Survey.xlsx"'); // Set nama file excel nya
    header('Cache-Control: max-age=0');
    $write = PHPExcel_IOFactory::createWriter($excel, 'Excel2007');
    $write->save('php://output');
?>