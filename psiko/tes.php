<?php

include("config.php");
$id_user      = $_POST['id_user'];
$pertanyaan_1 = $_POST['pertanyaan_1'];
$pertanyaan_2 = $_POST['pertanyaan_2'];
$pertanyaan_3 = $_POST['pertanyaan_3'];
$pertanyaan_4 = $_POST['pertanyaan_4'];
$pertanyaan_5 = $_POST['pertanyaan_5'];
$pertanyaan_6 = $_POST['pertanyaan_6'];
$pertanyaan_7 = $_POST['pertanyaan_7'];
$pertanyaan_8 = $_POST['pertanyaan_8'];
$pertanyaan_9 = $_POST['pertanyaan_9'];
$pertanyaan_10 = $_POST['pertanyaan_10'];
$pertanyaan_11 = $_POST['pertanyaan_11'];
$pertanyaan_12 = $_POST['pertanyaan_12'];
$pertanyaan_13 = $_POST['pertanyaan_13'];
$pertanyaan_14 = $_POST['pertanyaan_14'];
$pertanyaan_15 = $_POST['pertanyaan_15'];
$pertanyaan_16 = $_POST['pertanyaan_16'];
$pertanyaan_17 = $_POST['pertanyaan_17'];
$pertanyaan_18 = $_POST['pertanyaan_18'];


$sql = "INSERT INTO tes VALUES ( NULL,'$id_user','$pertanyaan_1' , '$pertanyaan_2', '$pertanyaan_3', '$pertanyaan_4', '$pertanyaan_5', '$pertanyaan_6', '$pertanyaan_7', '$pertanyaan_8', '$pertanyaan_9', '$pertanyaan_10', '$pertanyaan_11', '$pertanyaan_12', '$pertanyaan_13', '$pertanyaan_14', '$pertanyaan_15', '$pertanyaan_16', '$pertanyaan_17', '$pertanyaan_18')";
$query = mysqli_query($db , $sql);

// apakah query sudah berhasil ?
if ($query) {
  echo "MANTAP";
} else {
  // kalau gagal tampilkan pesan
  die("Gagal menyimpan perubahan");
}
