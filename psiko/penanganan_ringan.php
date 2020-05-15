<?php

include("config.php");

$id_hasil_tes = $_POST['id_hasil_tes'];
$saran_pencegahan = $_POST['saran_pencegahan'];


$sql = "INSERT INTO penanganan_ringan VALUES ( NULL,'$id_hasil_tes' , '$saran_pencegahan')";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
echo "MANTAP";
} else {
// kalau gagal tampilkan pesan
die("Gagal menyimpan perubahan");
}
