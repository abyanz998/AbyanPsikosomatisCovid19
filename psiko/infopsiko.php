<?php

include("config.php");



$sql = "SELECT * FROM info_psikosomatis";
$result = array();
$query = mysqli_query($db, $sql);

while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'id_konten' => $row['id_konten'],
    'konten' => $row['konten']
));
}

echo json_encode(array("result" => $result));
?>
