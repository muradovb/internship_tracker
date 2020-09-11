<?php

    define('DB_SERVER', 'dijkstra.ug.bcc.bilkent.edu.tr');
    define('DB_USERNAME', 'bayram.muradov');
    define('DB_PASSWORD', 's2YadJ5B');
    define('DB_DATABASE', 'bayram_muradov');

    $db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

    if(mysqli_connect_errno()){
        echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }
?>
