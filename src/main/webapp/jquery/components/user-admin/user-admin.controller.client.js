//IIFE


(function () {


        var userNameFld = $('#usernameFld');
        var password = $('#passwordFld');
        var phone = $('#phone');
        var firstName = $('#firstNameFld');
        var lastName = $('#lastNameFld');
        var email = $('#emailFld');
        var dob = $('#dobInput');
        var role = $('#roleFld');
        var createBtn = $('#createUserBtn');

        var tbody;
        var template;

        jQuery(main);

        //var userService = new UserServiceClient();

        function main() {
            //tbody = jQuery('tbody');
            //template = jQuery('.template');
            createBtn.click(createUser());
            // $('#deleteUserBtn').click(deleteUser(event));
            // $('#editUserBtn').click(editUser(event));
        }

        // function findAllUsers() {
        //     userService
        //         .findAllUsers()
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
            var url = ('d');

            fetch('/user-admin', {
                method: 'get',
                body: usrObjStr,
                headers: {
                    'Content-Type': 'application/json'
                }
            });
        }

        // function renderUsers(users) {
        //     tbody.empty();
        //     for (var i = 0; i < users.length; i++) {
        //         var user = users[i];
        //         var clone = template.clone();
        //
        //         clone.attr('id', user.id);
        //
        //         clone.find('.delete').click(deleteUser);
        //         clone.find('.edit').click(editUser);
        //
        //         clone.find('.username')
        //             .html(user.username);
        //         tbody.append(clone);
        //     }
        // }
        //
        // function deleteUser(event) {
        //     var deleteBtn = $(event.currentTarget);
        //     var userId = deleteBtn
        //         .parent()
        //         .parent()
        //         .attr('id');
        //
        //     userService
        //         .deleteUser(userId)
        //         .then(findAllUsers);
        // }
        //
        // function editUser(event) {
        //     console.log('editUser');
        //     console.log(event);
        // }

    }

)();
