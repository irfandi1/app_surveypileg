<?php
$id = $_GET["id"];

if (hapussurveyor($id) > 0) {
  echo "<script>
          alert('Data telah dihapus!');
          document.location.href='index.php?acts=surveyor';
          </script>";
} else {
  echo "<script>
          alert('Data telah dihapus!');
          document.location.href='index.php?acts=surveyor';
          </script>";
}

?>