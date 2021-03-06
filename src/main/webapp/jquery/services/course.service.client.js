function CourseServiceClient() {
    this.createCourse = createCourse;
    this.findAllCourses = findAllCourses;
    this.findCourseById = findCourseByID;
    this.deleteCourse = deleteCourse;
    this.updateCourse = updateCourse;
    this.url = '/api/course';
    var self = this;

    function createCourse(course) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(course),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function findAllCourses(callback) {
        return $.ajax({
        url: self.url,
        success: callback
        });
    }

    function findCourseByID(courseId) {
        return fetch(
            self.url + '/' + courseId)
            .then(function(response) {
                return response.json();
            });
    }

    function updateCourse(courseId, course) {
        return fetch(self.url + '/' + courseId, {
            method: 'put',
            body: JSON.stringify(course),
            headers: {
            'content-type': 'application/json'
            }
        });
    }

    function deleteCourse(courseId) {
        return fetch(self.url + '/' + courseId, {
        method: 'delete'
        });
    }
}