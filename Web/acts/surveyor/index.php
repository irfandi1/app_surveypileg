<?php
    $surveyor = query ("select * from surveyor");
?>

<section class="p-t-20">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3 class="title-5 m-b-35">data table Surveyor</h3>
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
                    <div class="table-data__tool-right">
                        <a href="index.php?acts=tambahsurveyor" class="au-btn au-btn-icon au-btn--green au-btn--small">
                            <i class="zmdi zmdi-plus"></i>add item  
                        </a>
                    </div>
                </div>
                <div class="table-responsive table-responsive-data2">
                    <table class="table table-data2">
                        <thead>
                            <tr>
                                <th>Nama Petugas</th>
                                <th>Username</th>
                                <th>Jenis Kelamin</th>
                                <th>No. HP</th>
                                <th>Alamat</th>
                                <th>Status</th>
                                <th>Tgl Masuk</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <?php
                            foreach ($surveyor as $view) :

                         ?>
                            <tr class="tr-shadow">
                                
                                <td><?= $view["nama_petugas"]; ?></td>
                                <td>
                                    <span class="block-email"><?= $view["username"]; ?></span>
                                </td>
                                <td class="desc"><?= $view["jenis_kelamin"]; ?></td>
                                <td>
                                    <span class="status--process"><?= $view["no_hp"]; ?></span>
                                </td>
                                <td>
                                    <span class="status--process"><?= $view["alamat"]; ?></span>
                                </td>
                                <td>
                                    <span class="status--process"><?= $view["status"]; ?></span>
                                </td>
                                <td><?= $view["created_at"]; ?></td>
                                <td>
                                    <div class="table-data-feature">
                                        <button>
                                            <a href="index.php?acts=editsurveyor&id=<?= $view["id_surveyor"]; ?>" class="item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="zmdi zmdi-edit"></i></a>
                                        </button>
                                        </button>
                                            <a href="index.php?acts=hapussurveyor&id=<?= $view["id_surveyor"]; ?>" onclick="return confirm('Anda Yakin?');" class="item" data-toggle="tooltip" data-placement="top" title="Delete"><i class="zmdi zmdi-delete"></i></a>
                                        </button>
                                    </div>
                                </td>  
                            </tr>
                            <?php
                                endforeach;
                                ?>
                            <tr class="spacer"></tr>
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>