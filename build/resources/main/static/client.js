$(document).ready(function () {
    init()
});

function init() {
    enable();
    getEmployees();
}

function enable() {
    $("#btnSubmit").on("click", postEmployee);
    $("#btnSearch").on("click", searchEmployee);
    $("#btnSearch2").on("click", searchEmployeePosition);
    // $("#list").on("click", searchEmployeeSalary);
}

function getEmployees() {
    $.ajax({
        type: "GET",
        url: "/getAllEmployees",
        success: function (data) {
            appendPeople(data);
        }
    });
}

function postEmployee(event) {
    event.preventDefault();

    var newEmployee = {
        id: $("#txtId").val(),
        firstName: $("#txtFName").val(),
        lastName: $("#txtLName").val(),
        salary: $("#txtSalary").val(),
        position: $("#txtPosition").val()

    };

    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(newEmployee),
        url: "/add/employee",
        success: function (data) {
            getEmployees();
        }
    });

    $.ajax({
        type: "GET",
        url: "/get3/" + newEmployee.salary,
        success: function (data) {
            appendPeople(data);
        }
    });

    $("#txtId").val("");
    $("#txtFName").val("");
    $("#txtLName").val("");
    $("#txtSalary").val("");
    $("#txtPosition").val("");

}

function searchEmployee(event) {
    event.preventDefault();

    var searchId = $("#txtSearch").val();

    $.ajax({
        type: "GET",
        url: "/get/" + searchId,
        success: function (data) {
            appendPeople(data);
        }
    });
    $("#txtSearch").val("");
}

function searchEmployeePosition(event) {
    event.preventDefault();

    var searchPosition = $("#txtSearch2").val();

    $.ajax({
        type: "GET",
        url: "/get2/" + searchPosition,
        success: function (data) {
            appendPeople(data);
        }
    });
    $("#txtSearch2").val("");
}


function appendPeople(peopleArray) {
    $("#container").empty();
    for (var i = 0; i < peopleArray.length; i++){
        var person = peopleArray[i];

        $("#container").append("<div></div>");
        var el = $("#container").children().last();
        el.append("<p>" + person.id + " : " +
            person.firstName + " " +
            person.lastName + "</p>");
    }
}
