function loadPages(){
    $("#getallstudent").load("http://localhost:8090/getAllStudent");
    $("#getallcourse").load("http://localhost:8090/getAllCourse");
    $("#getallcourseregistrations").load("http://localhost:8090/getAllCourseRegistration");
    $("#description").load("http://localhost:8090/readme");

}

//////////////////////////////////

function addStudent(){

    let param1 = document.querySelector('#email');
    let param2 = document.querySelector('#password');

    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/addStudent";

    // open a connection
    xhr.open("POST", url, true);

    // Set the request header i.e. which type of content you are sending
    xhr.setRequestHeader("Content-Type", "application/json");

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    // Converting JSON data to string
    let data = JSON.stringify({ "email": param1.value,"password":param2.value});
    // Sending data with the request
    xhr.send(data);
}

//////////////////////////////////

function addCourse(){

    let param1 = document.querySelector('#coursename');

    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/addCourse";

    // open a connection
    xhr.open("POST", url, true);

    // Set the request header i.e. which type of content you are sending
    xhr.setRequestHeader("Content-Type", "application/json");

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };
    // Converting JSON data to string
    let data = JSON.stringify({ "name": param1.value });
    // Sending data with the request
    xhr.send(data);
}

/////////////////////////////////////////////////////////////

function addCourseReg(){

    let param1 = document.querySelector('#student_id');
    let param2 = document.querySelector('#course_id');
    let param3 = 5;
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/addCourseRegistration";

    // open a connection
    xhr.open("POST", url, true);

    // Set the request header i.e. which type of content you are sending
    xhr.setRequestHeader("Content-Type", "application/json");

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    // Converting JSON data to string
    let data = JSON.stringify({ "student_id": param1.value,"course_id":param2.value, "power":param3.value} );
    // Sending data with the request
    xhr.send(data);
}

///////////////////////////////////////////////////////////

function deleteStudent(student_id){
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/deleteStudent?student_id="+student_id+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    xhr.send();
}

///////////////////////////////////////////////////////////

function  deleteCourse(course_id){
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/deleteCourse?course_id="+course_id+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    xhr.send();
}

///////////////////////////////////////////////////////////

function deleteCourseReg(courseregistration_id){
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/deleteCourseRegistration?courseregistration_id="+courseregistration_id+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    xhr.send();
}

///////////////////////////////////////////////////////////

function updateStudent(student_id){
    var password=document.getElementById('password'+student_id).value;
    var email=document.getElementById('email'+student_id).value;

    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/updateStudent?student_id="+student_id+"&email="+email+"&password="+password+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    xhr.send();
}

///////////////////////////////////////////////////////////

function updateCourse(course_id){
    var name=document.getElementById('course'+course_id).value;
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/updateCourse?course_id="+course_id+"&name="+name+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    xhr.send();
}

////////////////////////////

function updateCourseReg(courseregistration_id){
    var power=document.getElementById('coursereg'+courseregistration_id).value;
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/updateCourseRegistration?courseregistration_id="+courseregistration_id+"&power="+power+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            loadPages();
        }
    };

    xhr.send();
}