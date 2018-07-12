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

        var usr = {
            username: usrStr,
            password: passwordStr
        };
        var usrObj = JSON.stringify(usr);

        if (usrStr && passwordStr !== null
            || (usrStr && passwordStr === "")) {
            userService.login(usr)
                .then(navigateToProfile, failHandler);
        } else {
            alert("Please fill in every field");
            location.reload();
        }
    }

    function navigateToProfile() {
        window.location.href = "../profile/profile.template.client.html";
    }

    function failHandler(response) {
        if (response.status === 200) {
            alert("Welcome!");
            window.location.href = '/jquery/profile/profile.template.client.html';
        } else {
            alert('No user with credentials found. Please try again.');
        }
    }
})();
