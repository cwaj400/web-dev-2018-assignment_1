function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.findUserById = findUserById;
    this.updateUser = updateUser;
    this.findByUsername = findByUsername;
    this.login = login;
    this.logout = logout;
    this.url =
        'http://localhost:8080/api/user';
    this.loginUrl =
        'http://localhost:8080/api/login';
    this.logoutUrl = 'http://localhost:8080/api/logout';
    var self = this;

    function login(username, password) {
        return fetch(self.loginUrl, {
            method: 'post',
            body: JSON.stringify({
                                     username: username,
                                     password: password
                                 }),
            headers: {
                'content-type': 'application/json'
            },
            credentials: 'include'
        });
    }

    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
                                                  method: 'put',
                                                  body: JSON.stringify(user),
                                                  headers: {
                                                      'content-type': 'application/json'
                                                  }
                                              })
            .then(function (response) {
                if (response.bodyUsed) {
                    return response.json();
                } else {
                    return null;
                }
            });
    }

    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function (response) {
                return response.json();
            });
    }

    function deleteUser(userId) {
        return fetch(self.url + '/' + userId, {
                                                  method: 'delete'
                                              })
    }

    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json();
            });
    }

    function findByUsername(username) {
        return fetch(self.url + "?username=" + username).then(function (response) {
            return response.json();
        })

    }

    function logout() {
        return fetch(self.logoutUrl, {
            method: 'post',
            headers: {
                'content-type': 'application/json'
            },
            credentials: 'include'
        });
    }

    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            },
            credentials: 'include'
        });
    }
}