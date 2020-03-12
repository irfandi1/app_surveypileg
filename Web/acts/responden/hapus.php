<?php
$id = $_GET["id"];

if (hapusresponden($id) > 0) {
  echo "<script>
          alert('Data telah dihapus!');
          document.location.href='index.php?acts=responden';
          </script>";
} else {
  echo "<script>
          alert('Data telah dihapus!');
          document.location.href='index.php?acts=responden';
          </script>";
}

?>