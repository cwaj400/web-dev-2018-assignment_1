(function () {

    var userservice = new UserServiceClient();
    var registerBtn = jQuery('#regBtn');
    var usernameFld = $('#username');
    var passwordFld = $('#passwordFld');
    var verifyPassword = $('#verifyPasswordFld');


    $(main);

    function main() {
        registerBtn.click(register);
    }


    function register() {
        var usernameStr = usernameFld.val();
        var passwordStr = passwordFld.val();
        var verifyPasswordStr = verifyPassword.val();

        var userObj = {
            username: usernameStr,
            password: passwordStr
        };

        if (usernameStr === ""
            || usernameStr === null
        || passwordStr === ""
        || passwordStr === null
        || verifyPasswordStr === ""
        || verifyPasswordStr === null) {
            alert("Please fill in every field");
        }
        else if (passwordStr !== verifyPasswordStr) {
            console.log(usernameStr);
            alert("Passwords do not match");
        }
        else if (isInDB(usernameStr)) {
            alert("That user name has been taken - IDENTITY THEFT IS NOT A JOKE, JIM!");
        }
        else {
            userservice.createUser(userObj);
        }
    }

    function isInDB(usernameStr) {
        for (var i = 0; i < users.length; i++) {
            if (userservice.get().username === usernameStr) {
                return true;
            }
        }
    }
})
();
