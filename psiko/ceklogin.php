<?php

include("config.php");

$gmail= $_POST['gmail'];
$password= $_POST['password'];


$sql = "SELECT * FROM user WHERE gmail='$gmail' AND password='$password'";

$query = mysqli_query($db, $sql);
$result = array();
$stat=mysqli_num_rows ( $query );

array_push($result, array('status' => $stat));
echo json_encode(array("result" => $result));
?>
