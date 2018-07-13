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
        var passwordStr = password.val();
        var username = usernameFld.val();

        if (username && passwordStr !== null) {

            userService.login(username, passwordStr).then(navigateToProfile).catch(failHandler);
        } else {
            location.reload();
            alert('Please fill in all fields.');
        }
    }

    function navigateToProfile() {
        window.location.href = "../profile/profile.template.client.html";
    }

    function failHandler(response) {
        if (response.status === 200) {
            alert("Welcome!");
            window.location.href = '../profile/profile.template.client.html';
        } else {
            alert('No user with credentials found. Please try again.');
        }
    }
})();