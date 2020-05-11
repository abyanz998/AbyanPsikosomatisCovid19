<?php

include("config.php");

$gmail= $_POST['gmail'];
$password= $_POST['password'];


$sql = "SELECT * FROM user WHERE gmail='$gmail' AND password='$password'";
$query = mysqli_query($db, $sql);
$result = array();

$stat=mysqli_num_rows ( $query );                                                                                                       

while($row = mysqli_fetch_array($query)){
    array_push($result, array(
      'status' => $stat,
    'id_user' => $row['id_user'],
    'nama' => $row['nama']
));
}
// yang diterima $result dulu baru $status
echo json_encode(array("result" => $result));
?>
