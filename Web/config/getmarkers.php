<?php
require("function.php");
$database="survey_pileg";

function parseToXML($htmlStr)
{
$xmlStr=str_replace('<','&lt;',$htmlStr);
$xmlStr=str_replace('>','&gt;',$xmlStr);
$xmlStr=str_replace('"','&quot;',$xmlStr);
$xmlStr=str_replace("'",'&#39;',$xmlStr);
$xmlStr=str_replace("&",'&amp;',$xmlStr);
return $xmlStr;
}

// Opens a connection to a MySQL server
// $connection=mysqli_connect ('localhost', $username, $password);
if (!$conn) {
  die('Not connected : ' . mysqli_connect_error());
}

// Set the active MySQL database
$db_selected = mysqli_select_db($conn, $database);
if (!$db_selected) {
  die ('Can\'t use db : ' . mysqli_connect_error());
}

// Select all the rows in the markers table
$query = "SELECT * FROM responden";
$result = mysqli_query($conn, $query);
if (!$result) {
  die('Invalid query: ' . mysqli_connect_error());
}

header("Content-type: text/xml");

// Start XML file, echo parent node
echo "<?xml version='1.0' ?>";
echo '<markers>';
$ind=0;
// Iterate through the rows, printing XML nodes for each
while ($row = @mysqli_fetch_assoc($result)){
  // Add to XML document node
  echo '<marker ';
  echo 'id_responden="' . $row['id_responden'] . '" ';
  echo 'nama_responden="' . parseToXML($row['nama_responden']) . '" ';
  echo 'alamat="' . parseToXML($row['alamat']) . '" ';
  echo 'pertanyaan_29="' . parseToXML($row['pertanyaan_29']) . '" ';
  echo 'pertanyaan_39="' . parseToXML($row['pertanyaan_39']) . '" ';
  echo 'lat="' . $row['lat'] . '" ';
  echo 'lang="' . $row['lang'] . '" ';
  $date = date_create($row['create_at']); 
  echo 'waktu="' . date_format($date, 'j F Y, \p\u\k\u\l G:i') . '" ';
  echo '/>';
  $ind = $ind + 1;
}

// End XML file
echo '</markers>';

?>