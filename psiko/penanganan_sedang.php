<?php

include("config.php");

$id_hasil_tes = $_POST['id_hasil_tes'];
$saran_pengobatan = $_POST['saran_pengobatan'];


$sql = "INSERT INTO penanganan_sedang VALUES ( NULL,'$id_hasil_tes' , '$saran_pengobatan')";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
echo "MANTAP";
} else {
// kalau gagal tampilkan pesan
die("Gagal menyimpan perubahan");
}
