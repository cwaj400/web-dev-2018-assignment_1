function User(username, password, firstName, lastName, email, phone, role, dob) {
  this.username = username;
  this.password = password;
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
  this.role = role;
  this.dob = dob;

  this.setUsername = setUsername;
  this.getUsername = getUsername;

  this.setPassword = setPassword;
  this.getPassword = getPassword;

  this.setFirstName = setFirstName;
  this.getFirstName = setFirstName;

  this.setLastName = setLastName;
  this.getLastName = getLastName;

  this.setPhone = setPhone;
  this.getPhone = getPhone;

  this.setEmail = setEmail;
  this.getEmail = getEmail;

  this.setRole = setRole;
  this.getRole = getRole;

  this.setDob = setDob;
  this.getDob = getDob;



  function setUsername(username) {
    this.username = username;
  }

  function getUsername() {
    return this.username;
  }

  function setPassword(password) {
    this.password = password;
  }

  function getPassword() {
    return this.password;
  }

  function setFirstName(firstName) {
    this.firstName = firstName;
  }

  function getFirstName() {
    return this.firstName;
  }

  function setLastName(lastName) {
    this.lastName = lastName;
  }

  function getLastName() {
    return this.lastName
  }

  function setPhone(phone) {
    this.phone = phone;

  }

  function getPhone() {
    return this.phone;
  }

  function setEmail(email) {
    this.email = email;
  }

  function getEmail() {
    return this.email;
  }

  function setRole(role) {
    this.role = role;
  }

  function getRole() {
    return this.role;
  }

  function setDob(dob) {
    this.dob = dob
  }

  function getDob() {
    return this.dob;
  }

}