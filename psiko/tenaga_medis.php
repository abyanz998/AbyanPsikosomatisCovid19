<?php

include("config.php");

$id_hasil_tes = $_POST['id_hasil_tes'];
$nama_psikolog = $_POST['nama_psikolog'];
$alamat_psikolog = $_POST['alamat_psikolog'];
$nomor_psikolog = $_POST['nomor_telepon'];


$sql = "INSERT INTO tenaga_medis VALUES ( NULL,'$id_hasil_tes' , '$nama_psikolog', '$alamat_psikolog', '$nomor_telepon' )";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
  echo "MANTAP";
} else {
  // kalau gagal tampilkan pesan
  die("Gagal menyimpan perubahan");
}
