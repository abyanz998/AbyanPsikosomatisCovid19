<?php

include("config.php");



$sql = "SELECT * FROM tes ORDER BY id_tes DESC LIMIT  1";
$result = array();
$query = mysqli_query($db, $sql);

while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'id_tes' => $row['id_tes'],
    'id_user' => $row['id_user']
));
}

echo json_encode(array("result" => $result));
?>
