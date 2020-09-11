<?php
    include("db.php");
    session_start();
    $student_info = $_SESSION['s_datas'];
    $_SESSION['s_datas'] = $student_info;

    $sid = $student_info['sid'];
    //for cancel & add operations
    $_SESSION['sid'] = $sid;

    $account_query = "SELECT cid, cname, quota FROM student NATURAL JOIN apply NATURAL JOIN company WHERE sid = $sid";
?>

<!DOCTYPE html>
<html>
<title>Welcome</title>
<link rel = "stylesheet" type = "text/css" href = "../css/navbar.css">
<link rel = "stylesheet" type = "text/css" href = "../css/account.css">
<link rel = "stylesheet" type = "text/css" href = "../css/main.css">
<script type = "text/javascript" src = "../javascript/dialog_applimit.js"></script>


<div class="topnav">
  <a href = "../index.php"> log out</a>
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
          $std_info = mysqli_query($db, $account_query);
          $row_count = mysqli_num_rows($std_info);
          for($i = 0; $i < $row_count; $i++)
          {
              $results = $std_info->fetch_assoc();

              $_SESSION['del_row'] = $results;

              $c_id = $results['cid'];
              $c_name = $results['cname'];
              $quota = $results['quota'];
      ?>
          <tr>
              <td> <?php echo $c_id; ?> </td>
              <td> <?php echo $c_name; ?> </td>
              <td> <?php echo $quota; ?> </td>
              <td> <a href = "cancel.php?cancelled=
                <?php echo $c_id ?>"><img src = "../images/cancel.png" alt = "cancel"
                style = "height:3%">
              </img></a> </td>
          </tr>

      <?php
          }
      ?>

    </table>
    <br></br>
    <form action="welcome.php">
      <?php
            $stat_count_d = "SELECT COUNT(sid) as total FROM apply WHERE sid=$sid";
            $counter_d = mysqli_query($db, $stat_count_d);
            $count = $counter_d->fetch_assoc();
            echo $count['total'];
            if($count['total']==3):?>
    <button type=".cancelbtn" onclick="displayLimitDialog()" >can't make a new application </button>
   </form>

    <?php
          elseif($count['total']!=3):?>
    <a href = "new_application.php"> make a new application</a>
  <?php endif; ?>


</div>
</html>
