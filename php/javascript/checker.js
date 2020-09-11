function checkFields()
{
    var username = document.forms["login_form"]["username"].value;
    var password = document.forms["login_form"]["password"].value;

    if (username == null || username == "", password == null || password == "") {
        alert("!fields cannot be blank!");
        return false;
    }
};
