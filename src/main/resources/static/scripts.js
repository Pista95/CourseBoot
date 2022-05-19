function resizeIframe(obj) {
    obj.style.height = obj.contentWindow.document.documentElement.scrollHeight + 'px';
    obj.style.width =  obj.contentWindow.document.documentElement.scrollWidth + 'px';
}
function sendJSON(){

    let result = document.querySelector('.result');
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
            //$("result").load("getAll");
            // alert("successful sending");
        }
    };

    // Converting JSON data to string
    var data = JSON.stringify({ "email": param1.value,"password":param2.value});
    // Sending data with the request
    xhr.send(data);
    // alert("Sent JSON: " +data);
    document.getElementById('getallstudent').contentDocument.location.reload(true);

}
/////////////////////////////////////////////////////////////

function addCOURSE(){

    let result = document.querySelector('.result1');
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
        }
    };
    // Converting JSON data to string
    var data = JSON.stringify({ "name": param1.value });
    // Sending data with the request
    xhr.send(data);
    document.getElementById('getallcourse').contentDocument.location.reload(true);

}

/////////////////////////////////////////////////////////////

function sendCOURSEREG(){

    let result = document.querySelector('.result');
    let param1 = document.querySelector('#student_id');
    let param2 = document.querySelector('#course_id');
    let param3 = document.querySelector('#power');

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
            result.innerHTML = this.responseText;
            // alert("successful sending");
        }
    };

    // Converting JSON data to string
    var data = JSON.stringify({ "student_id": param1.value,"course_id":param2.value, "power":param3.value} );
    // Sending data with the request
    xhr.send(data);
    //alert("Sent JSON: " +data);
    document.getElementById('getallcourseregistrations').contentDocument.location.reload(true);

}