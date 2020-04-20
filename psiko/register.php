<?php

include("config.php");

$nama = $_POST['nama'];
$gmail = $_POST['gmail'];
$password = $_POST['password'];


$sql = "INSERT INTO user VALUES ( NULL,'$nama' , '$gmail', '$password' )";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
  echo "MANTAP";
} else {
  // kalau gagal tampilkan pesan
  die("Gagal menyimpan perubahan");
}
