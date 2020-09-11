<?php
    include("db.php");
    session_start();
    $sid = $_SESSION['sid'];
    $un_cid=$_GET['cancelled'];
    $cid = trim($un_cid);
    //params are ok.
    $stat_check = "SELECT * FROM apply WHERE sid = $sid AND cid='$cid'";

    $stat_exist = mysqli_query($db, $stat_check);

    $count_exist = mysqli_num_rows($stat_exist);
    echo $count_exist;

    if($count_exist==0) {
      header("location: fail/fail_delete.php");
      exit();
    }
    else if($count_exist>0)
     {
      $stat_delete = "DELETE FROM apply WHERE sid = $sid AND cid = '$cid'";
      $old_data = mysqli_query($db, $stat_delete);
      header("location: succ_delete.php");
      exit();
    }
?>
