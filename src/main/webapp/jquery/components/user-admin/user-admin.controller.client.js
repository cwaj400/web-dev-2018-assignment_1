//IIFE


console.log(jQuery);

(function() {

  jQuery(main);

  var tbody;
  var template;
  var userService = new UserServiceClient();

  function main() {
    tbody = jQuery('tbody');
    template = jQuery('.template');
    $('#createUserBtn').click(createUser);
    $('#deleteUserBtn').click(deleteUser(event));
    $('#editUserBtn').click(editUser(event));

    findAllUsers();
  }

  function findAllUsers() {
    userService
      .findAllUsers()
      .then(renderUsers);
  }

  function createUser() {
    console.log('creating User');
      tbody.css('color', 'red');

    var username = $('#usernameFld').val();
    var password = $('#passwordFld').val();
    var firstName = $('#firstNameFld').val();
    var lastName = $('#lastNameFld').val();
    var phone = $('#phone');

    var user = {
      username: username,
      password: password,
      firstName: firstName,
      lastName: lastName
    };

    userService
      .createUser(user)
      .then(findAllUsers);
  }

  function renderUsers(users) {
    tbody.empty();
    for (var i = 0; i < users.length; i++) {
      var user = users[i];
      var clone = template.clone();

      clone.attr('id', user.id);

      clone.find('.delete').click(deleteUser);
      clone.find('.edit').click(editUser);

      clone.find('.username')
        .html(user.username);
      tbody.append(clone);
    }
  }

  function deleteUser(event) {
    var deleteBtn = $(event.currentTarget);
    var userId = deleteBtn
      .parent()
      .parent()
      .attr('id');

    userService
      .deleteUser(userId)
      .then(findAllUsers);
  }

  function editUser(event) {
    console.log('editUser');
    console.log(event);
  }

})();