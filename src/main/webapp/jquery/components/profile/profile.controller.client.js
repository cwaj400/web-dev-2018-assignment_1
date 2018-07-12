(function () {

    var $username, $firstName, $lastName,
        $updateBtn, $phone, $role, $logoutBtn;
    var currentUser = null;

    var userservice = new UserServiceClient();

    $(main);

    function main() {

        $username = $("#username");
        $firstName = $("#firstName");
        $lastName = $("#lastName");
        $phone = $('#phone');
        $role = $('#role');
        $logoutBtn = $('#logoutBtn');

        $updateBtn = $("#updateBtn");

        $updateBtn.click(updateUser);

        $logoutBtn.click(logout);

        profile()
            .then(renderUser);
    }

    function logout() {
        alert("Goodbye");
        userservice.logout().then(redirect);
    }

    function redirect() {
        window.location.href = "../login/login.template.client.html"
    }

    function updateUser() {

        var user = {
            firstName: $firstName.val(),
            lastName: $lastName.val(),
            phone: $phone.val(),
            username: $username.val(),
            role: $role.val()
        };

        fetch("/api/user/" + currentUser.id, {
                                                 method: 'put', body: JSON.stringify(user),
                                                 credentials: 'include',
                                                 headers: {
                                                     'content-type': 'application/json'
                                                 }
                                             }).then(function () {
            alert("Updated!");
        });
    }

    function renderUser(user) {
        currentUser = user;
        $username.val(user.username);
        $firstName.val(user.firstName);
        $lastName.val(user.lastName);
        $phone.val(user.phone);
        $role.val(user.role);
    }

    function profile() {
        return fetch('/profile', {
            method: 'get',
            credentials: 'include'
        }).then(function (response) {
            return response.json();
        });
    }
})();