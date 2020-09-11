<?php
    include("db.php");
    session_start();
    $st_id = $_SESSION['sid'];
    $_SESSION['s_id'] = $st_id;
    $stat_all_quotas = "SELECT cname, cid, quota, COUNT(sid) AS fild_q
                        FROM
                        apply NATURAL JOIN company
                        WHERE sid!=$st_id";

    $avail_quotas=mysqli_query($db, $stat_all_quotas);
?>


<!DOCTYPE html>
<html>
<title>New Application</title>
<link rel = "stylesheet" type = "text/css" href = "../css/navbar.css">
<link rel = "stylesheet" type = "text/css" href = "../css/account.css">
<link rel = "stylesheet" type = "text/css" href = "../css/main.css">
<div class="topnav">
  <a href = "../index.php"> log out</a>
  <a href = "welcome.php"> welcome page</a>
</div>
<br>
</br>
<div class="applinfo">
    <table id = "student-info">
      <tr>
          <th>company_id</th>
          <th>company_name</th>
          <th>quota</th>
          <th>opeartion</th>
      </tr>
      <?php
          $row_count = mysqli_num_rows($avail_quotas);
          for($i = 0; $i < $row_count; $i++)
          {
              $results = $avail_quotas->fetch_assoc();

              $_SESSION['del_row'] = $results;

              $c_id = $results['cid'];
              $c_name = $results['cname'];
              $quota = $results['quota'];
         ?>
          <tr>
              <td> <?php echo $c_id; ?> </td>
              <td> <?php echo $c_name; ?> </td>
              <td> <?php echo $quota; ?> </td>
              <td> <a href = "proc_app.php?added=
                <?php echo $c_id ?>">
                <img src = "../images/add.png" alt = "add"
                style = "height:3%">
              </img></a> </td>
          </tr>
          <?php
              }
          ?>

          </table>
