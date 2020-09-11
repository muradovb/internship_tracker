function displayLimitDialog()
{
    var mess = "you have exceeded the application limit";
    alert(mess);
    return false;
};

document.getElementById("avail_bttn").onclick = function () {
        location.href = "new_application.php";
};
