//IIFE

(function () {

    var userService = new UserServiceClient();
    var userNameFld = $('#usernameFld');
    var password = $('#passwordFld');
    var phone = $('#phone');
    var firstName = $('#firstNameFld');
    var lastName = $('#lastNameFld');
    var email = $('#emailFld');
    var dob = $('#dobInput');
    var role = $('#roleFld');

    //Buttons
    var createBtn = $('#createUserBtn');
    var editUsrBtn = $('#editUserBtn');

    console.log("hello there");

    var tbody;
    var template;

    jQuery(main);

    //var userService = new UserServiceClient();

    function main() {
        console.log("in main");
        tbody = jQuery('tbody');
        template = jQuery('.template');
        createBtn.click(createUser);
        //editUsrBtn.click(findUserByID);
        $('#deleteUserBtn').click(deleteUser);
        $('#editUserBtn').click(editUser);

        findAllUsers();
    }

    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }

    // function findUserByID() {
    //     console.log($(this));
    //     var usrID = 0;
    //     userService
    //         .findUserById()
    //         .then(renderUsers);
    // }

    function createUser() {
        console.log('creating user...');

        var usernameStr = userNameFld.val();
        var passwordStr = password.val();
        var firstnameStr = firstName.val();
        var lastnameStr = lastName.val();
        var phoneStr = phone.val();
        var emailStr = email.val();
        var dobStr = dob.val();
        var roleStr = role.val();

        var usrObj = {
            dob: dobStr,
            email: emailStr,
            firstName: firstnameStr,
            lastName: lastnameStr,
            password: passwordStr,
            phone: phoneStr,
            role: roleStr,
            username: usernameStr,
        };

        var usrObjStr = JSON.stringify(usrObj);

        console.log(usrObjStr);

        fetch('/api/user', {
            method: 'post',
            body: usrObjStr,
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    function renderUsers(users) {
        tbody.empty();
        for (var i = 0; i < users.length; i++) {

            renderUser(users[i]);
        }
    }

    function renderUser(user) {
        var clone = template.clone();

        clone.attr('id', user.id);

        clone.find('.delete').click(deleteUser);
        clone.find('.edit').click(editUser);

        clone.find('.username')
            .html(user.username);

        clone.find('.password')
            .html(user.password);

        clone.find('.firstName')
            .html(user.firstName);

        clone.find('.lastName')
            .html(user.lastName);

        clone.find('.phone')
            .html(user.phone);

        clone.find('.email')
            .html(user.email);

        clone.find('.dob')
            .html(user.dob);

        clone.find('.role')
            .html(user.role);

        tbody.append(clone);
    }

    function deleteUser(event) {
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn
            .parent()
            .parent()
            .parent()
            .attr('id');

        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }

    function editUser(event) {
        console.log('editUser');
        console.log($(event.currentTarget));
    }
})();
