<?php
    include("db.php");
    session_start();
    //initial rw COUNT
    $stat_init = "SELECT * FROM apply";
    $init_res=mysqli_query($db, $stat_init);
    $count_init = mysqli_num_rows($init_res);


    $res_exec = mysqli_query($db, $stat_init);
    $datas = $res_exec->fetch_assoc();
    $_SESSION['s_datas'] = $datas;
    $count = mysqli_num_rows($res_exec);

    $sid=$_SESSION['s_id'];
    $un_cid=$_GET['added'];
    $cid = trim($un_cid);
    $stat = "INSERT INTO apply(sid, cid)
             VALUES($sid, '$cid')";
    $res_exec = mysqli_query($db, $stat);

    $stat_late = "SELECT * FROM apply";
    $late_res=mysqli_query($db, $stat_late);
    $count_late = mysqli_num_rows($late_res);


    if($count_late > $count_init)
    {
        session_start();
        header("location: succ_app.php");
        $db->close();
        exit();
    }
    else
    {
        header("location: fail/app_fail.php");
        exit();
    }
?>
