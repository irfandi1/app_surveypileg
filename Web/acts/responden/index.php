<?php
    $responden = query ("
    SELECT 
        responden.id_responden, 
        responden.nama_responden,  
        surveyor.nama_petugas,
        responden.alamat, responden.provinsi, responden.kab_kota, responden.kecamatan,
            responden.kel_desa, responden.rt, responden.rw, responden.no_hp,responden.pertanyaan_12,
            responden.pertanyaan_13, 
            responden.pertanyaan_14, responden.pertanyaan_15, responden.pertanyaan_16, 
            responden.pertanyaan_17, responden.pertanyaan_18, responden.pertanyaan_19, 
            responden.pertanyaan_20, responden.pertanyaan_21, responden.pertanyaan_22,
            responden.pertanyaan_23, responden.pertanyaan_24, responden.pertanyaan_25,
            responden.pertanyaan_26, responden.pertanyaan_27, responden.pertanyaan_28,
            responden.pertanyaan_29, responden.pertanyaan_30, responden.pertanyaan_31,
            responden.pertanyaan_32, responden.pertanyaan_33, responden.pertanyaan_34,
            responden.pertanyaan_35, responden.pertanyaan_36, responden.pertanyaan_37,
            responden.pertanyaan_38, responden.pertanyaan_39, responden.pertanyaan_40,
            responden.lat, responden.lang, responden.create_at
    FROM responden JOIN surveyor ON responden.id_surveyor = surveyor.id_surveyor");
?>

<section class="p-t-20">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3 class="title-5 m-b-35">data table responden</h3>
               
                <div class="table-data__tool">
                    <div class="table-data__tool-left">
                        <!-- <div class="rs-select2--light rs-select2--md">
                            <select class="js-select2" name="property">
                                <option selected="selected">All Properties</option>
                                <option value="">Option 1</option>
                                <option value="">Option 2</option>
                            </select>
                            <div class="dropDownSelect2"></div>
                        </div> -->
                        <!-- <div class="rs-select2--light rs-select2--sm">
                            <select class="js-select2" name="time">
                                <option selected="selected">Today</option>
                                <option value="">3 Days</option>
                                <option value="">1 Week</option>
                            </select>
                            <div class="dropDownSelect2"></div>
                        </div> -->
                        <!-- <button class="au-btn-filter">
                            <i class="zmdi zmdi-filter-list"></i>filters</button> -->
                    </div>
                    <!-- <div class="table-data__tool-right">
                        <a href="index.php?acts=tambahresponden" class="au-btn au-btn-icon au-btn--green au-btn--small">
                            <i class="zmdi zmdi-plus"></i>add item  
                        </a>
                    </div> -->
                    <div class="table-data__tool-right">
                        <a href="responden/excel.php" class="au-btn au-btn-icon au-btn--green au-btn--small">
                            <i class="zmdi zmdi-plus"></i>Export to Excel
                        </a>
                    </div>
                    
                </div>
                <div class="table-responsive table-responsive-data2">
                    <table class="table table-data2">
                        <thead>
                            <tr>
                                <th>Nama Petugas</th>
                                <th>Nama Responden</th>
                                <th>Alamat</th>
                                <th>Partai apa pada pemilu yang akan datang dipertimbangkan untuk Bpk/Ibu/Sdr pilih? </th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <?php
                            foreach ($responden as $view) :

                         ?>
                            <tr class="tr-shadow">
                                <td><?= $view["nama_petugas"]; ?></td>
                                <td>
                                    <span class="block-email"><?= $view["nama_responden"]; ?></span>
                                </td>
                                <td class="desc"><?= $view["alamat"]; ?></td>
                                <td><?= $view["pertanyaan_29"]; ?></td>
                                <td>
                                    <div class="table-data-feature">
                                        <button>
                                            <a href="index.php?acts=editresponden&id=<?= $view["id_responden"]; ?>" class="item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="zmdi zmdi-edit"></i></a>
                                        </button>
                                        </button>
                                            <a href="index.php?acts=hapusresponden&id=<?= $view["id_responden"]; ?>" onclick="return confirm('Anda Yakin?');" class="item" data-toggle="tooltip" data-placement="top" title="Delete"><i class="zmdi zmdi-delete"></i></a>
                                        </button>
                                        <button>
                                            <a href="index.php?acts=detailresponden&id=<?= $view["id_responden"]; ?>" class="item" data-toggle="tooltip" data-placement="top" title="Detail"><i class="zmdi zmdi-more"></i></a>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr class="spacer"></tr>
                            <?php
                                endforeach;
                            ?>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>