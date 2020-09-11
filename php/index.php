<?php
    include("php/db.php");
    session_start();
?>

<!DOCTYPE html>
<html>
<title>Login Page</title>
<link rel ="stylesheet" type="text/css" href="css/main.css">
<script type = "text/javascript" src = "javascript/checker.js"></script>
<form action="php/process_login.php" method = "POST" id = "i_form", name="login_form">
  <div class="imgcontainer">
    <img src="images/img_avatar.png" alt="Avatar" class="avatar">
  </div>
    <head>
        <center>
            <b>
                <font size="3" color="green">Intern Tracker</font>
            </b>
        </center>
    </head>
  <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit" onclick="checkFields()">Login</button>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="container" class="cancelbtn">good luck</button>
  </div>
</form>
</html>
