<?php

include("config.php");

$id_tes = $_POST['id_tes'];
$skor_tes = $_POST['skor_tes'];
$penanganan = $_POST['penanganan'];


$sql = "INSERT INTO hasil_tes VALUES ( NULL,'$id_tes' , '$skor_tes', '$penanganan' )";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
  echo "MANTAP";
} else {
  // kalau gagal tampilkan pesan
  die("Gagal menyimpan perubahan");
}
