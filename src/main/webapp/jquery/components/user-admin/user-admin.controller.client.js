//IIFE

(function () {

    var userService = new UserServiceClient();
    var userNameFld = $('#usernameFld');
    var password = $('#passwordFld');
    var phone = $('#phoneFlds');
    var firstName = $('#firstNameFld');
    var lastName = $('#lastNameFld');
    var email = $('#emailFld');
    var dob = $('#dobInput');
    var role = $('#roleFld');

    var usrIdUpdating = 0;

    //Buttons
    var createBtn = $('#createUserBtn');
    var editUsrBtn = $('#editUserBtn');
    var updateUsrBtn = $('#updateUserBtn');

    console.log("hello there");

    var tbody;
    var template;
    var inputRow;

    jQuery(main);

    //var userService = new UserServiceClient();

    function main() {
        console.log("in main");
        tbody = jQuery('tbody');
        template = jQuery('.template');
        inputRow = jQuery('.inputRow');
        createBtn.click(createUser);
        $('#deleteUserBtn').click(deleteUser);
        $('#editUserBtn').click(editUser);
        $('#updateUserBtn').click(updateUser);

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
            username: usernameStr
        };

        userService.createUser(usrObj).then(findAllUsers);
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

        clone.find('.phoneFld')
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

    function updateUser(event) {
        console.log($(event.currentTarget));

        var updateUsrBtn = $(event.currentTarget);

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
            username: usernameStr
        };

        console.log(userService.updateUser(usrIdUpdating, usrObj));

        if (usernameStr === null
            || usernameStr === ""
            || passwordStr === null
            || passwordStr === ""
            || firstnameStr === null
            || firstnameStr === ""
            || lastnameStr === null
            || lastnameStr === ""
            || phoneStr === null
            || phoneStr === ""
            || emailStr === null
            || emailStr === ""
            || dobStr === null
            || dobStr === ""
            || roleStr === null
            || roleStr === "") {
            alert("Please Fill All Required Field");
        }
        else {
            userService.updateUser(usrIdUpdating, usrObj).then(findAllUsers);
            console.log('updating user...');
        }
    }

    function editUser(event) {
        var editUsrBtn = $(event.currentTarget);

        var usrId = editUsrBtn.parent().parent().attr('id');

        userService.findUserById(usrId).then(function (user) {
            userNameFld.val(user.username);
            password.val(user.password);
            phone.val(user.phone);
            firstName.val(user.firstName);
            lastName.val(user.lastName);
            email.val(user.email);
            dob.val(user.dob);
            role.val(user.role);
            console.log(inputRow.id);
            inputRow.id = user.id;

            usrIdUpdating = user.id;

            console.log(inputRow.id);

            console.log(user.id);
            console.log("that should do it!");
        });

        console.log('editing user...');
    }
})
();
