(function () {
    var usernameFld = jQuery('#usernameLoginFld');
    var password = $('#passwordLoginFld');
    var logInBtn = $('#loginLogBtn');
    var userService = new UserServiceClient();

    $(main);

    function main() {
        logInBtn.click(login);
    }

    function login() {
        var usrStr = usernameFld.val();
        var passwordStr = password.val();

        if (usrStr && passwordStr !== null
        || usrStr && passwordStr === "") {
            userService.login(usrStr, passwordStr)
                .then(loginAlertHandler());
        } else {
            alert('Could not log in!');
        }
    }

    function loginAlertHandler(response) {
        if (response.status === 200) {
            alert("Welcome!");
            window.location.href = '/jquery/profile/profile.template.client.html';
        } else {
            alert('No user with credentials found. Please try again.');
        }
    }
})();