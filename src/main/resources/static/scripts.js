function loadpages(){
    $("#getallstudent").load("http://localhost:8090/getAllStudent");
    $("#getallcourse").load("http://localhost:8090/getAllCourse");
    $("#getallcourseregistrations").load("http://localhost:8090/getAllCourseRegistration");
    $("#description").load("http://localhost:8090/readme");

}
function generateRandomInteger(min, max) {
    return Math.floor(min + Math.random() * (max - min + 1))
}

function update(courseregid,power){
   //
}


function sendJSON(){

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
            $("#getallstudent").load("http://localhost:8090/getAllStudent");
        }
    };

    // Converting JSON data to string
    let data = JSON.stringify({ "email": param1.value,"password":param2.value});
    // Sending data with the request
    xhr.send(data);
    // alert("Sent JSON: " +data);
    //alert("Tanuló felvéve");

}


function addCOURSE(){

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
            //result.innerHTML = this.responseText;
            $("#getallcourse").load("http://localhost:8090/getAllCourse");
        }
    };
    // Converting JSON data to string
    let data = JSON.stringify({ "name": param1.value });
    // Sending data with the request
    xhr.send(data);
     // alert("Kurzus felvehető");
    //setTimeout( document.getElementById('getallcourse').contentDocument.location.reload(true),900);
}

/////////////////////////////////////////////////////////////

function sendCOURSEREG(){

    let param1 = document.querySelector('#student_id');
    let param2 = document.querySelector('#course_id');
    let param3 = generateRandomInteger(3,5);
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
            //result.innerHTML = this.responseText;
            $("#getallcourseregistrations").load("http://localhost:8090/getAllCourseRegistration");
        }
    };

    // Converting JSON data to string
    let data = JSON.stringify({ "student_id": param1.value,"course_id":param2.value, "power":param3.value} );
    // Sending data with the request
    xhr.send(data);
    //alert("Sent JSON: " +data);
}

function deleteCourseReg(id){
    alert(id);
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/deleteCourseRegistration?id="+id+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            $("#getallcourseregistrations").load("http://localhost:8090/getAllCourseRegistration");
        }
    };

    xhr.send();
}


///////////////////////////////////////////////////////////
function deleteStudent(student_id){
    alert(student_id);
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/deleteStudent?student_id="+student_id+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            $("#getallstudent").load("http://localhost:8090/getAllStudent");
        }
    };

    xhr.send();
}


function deleteCourse(id){
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/deleteCourse?course_id="+id+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            $("#getallcourse").load("http://localhost:8090/getAllCourse");
        }
    };

    xhr.send();
}

function updateCourse(course_id, name){
    //alert(course_id+" "+name);
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/updateCourse?course_id="+course_id+"&name="+name+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            $("#getallCourse").load("http://localhost:8090/getAllCourse");
        }
    };

    xhr.send();
}

function updateStudent(student_id, name, password){
    //alert(course_id+" "+name);
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8090/updateStudent?student_id="+student_id+"&name="+name+"&password"+password+"";

    xhr.open("POST", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            $("#getallstudent").load("http://localhost:8090/getAllStudent");
        }
    };

    xhr.send();
}