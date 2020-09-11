<?php
    include("db.php");
    session_start();
    $username = mysqli_escape_string($db, $_POST['username']);
    $password = mysqli_escape_string($db, $_POST['password']);
    //echo $username;
    //echo $password;
    $stat = "SELECT * FROM student WHERE sname = '$username' and sid = '$password'";
    $res_exec = mysqli_query($db, $stat);
    $datas = $res_exec->fetch_assoc();
    $_SESSION['s_datas'] = $datas;
    $count = mysqli_num_rows($res_exec);


    if($count > 0)
    {
        session_start();
        header("location: welcome.php");
        $db->close();
        exit();
    }
    else if($username != "" && $password != "")
    {
        //echo "fail";
        header("location: fail/login_fail.php");
        exit();
    }
    else
    {
        header("location: ../index.php");
        exit();
    }
?>
