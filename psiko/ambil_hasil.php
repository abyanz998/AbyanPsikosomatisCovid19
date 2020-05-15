<?php

include("config.php");



$sql = "SELECT * FROM hasil_tes ORDER BY id_hasil DESC LIMIT  1";
$result = array();
$query = mysqli_query($db, $sql);

while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'id_hasil' => $row['id_hasil'],
    'id_tes' => $row['id_tes']
));
}

echo json_encode(array("result" => $result));
?>
