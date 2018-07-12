(function () {

    var userservice = new UserServiceClient();
    var registerBtn = jQuery('#regBtn');
    var usernames = $('#usernameFld');
    var passwords = $('#passwordFld');
    var verifyPassword = $('#verifyPasswordFld');
    var userTemp;

    $(main);

    function main() {
        registerBtn.click(register);
    }

    function register() {
        var usernameStr = usernames.val();
        userTemp = usernameStr;

        var passwordStr = passwords.val();
        var verifyPasswordStr = verifyPassword.val();

        if (usernameStr === ""
            || usernameStr === null
            || passwordStr === ""
            || passwordStr === null
            || verifyPasswordStr === ""
            || verifyPasswordStr === null) {
            alert("Please fill in every field");
            location.reload();
        } else if (passwordStr !== verifyPasswordStr && ((passwordStr !== null)
                                                         || (verifyPasswordStr !== null))) {
            console.log(usernameStr);
            alert("Passwords do not match");
            location.reload();
        } else if (userservice.findByUsername(usernameStr) === null) {
            alert("IDENTITY THEFT IS NOT A CRIME JIM");
            location.reload();
        } else {
            alert("creating user...");
            userservice.register(new User(usernameStr, passwordStr)).then(registrationAlertHandler());
        }
    }

    function registrationAlertHandler(response) {
        if (response.status === 200) {
            alert("Welcome " + userTemp);
            window.location.href = '/jquery/profile/profile.template.client.html';
        } else {
            alert('Oops. That Username is already taken. Pick a new one!');
        }
    }

})
();
