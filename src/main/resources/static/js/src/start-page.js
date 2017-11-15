var dynamicClassList = [];


var loginInfo = [

    {
        'username': 'vtran18',
        'password': 'Monkeyisland123'
    },
    {
        'username': 'dvajja',
        'password': 'div123'
    },
    {
        'username': 'ntatinen',
        'password': 'Nuthana37$$'
    }

]

var linkedUrlList = [
    "https://www.linkedin.com/in/viet-tran-272570108/"
];

//Data
var allMasterClasses = [
    "SWE 632 - User Interface Design and Development",
    "SWE 645 - Component-Based Software Development",
    "CS 550 - Database Systems",
    "CS 580 - Introduction to Artificial Intelligence",
    "INFS 622 - Information Systems Analysis and Design",
    "ISA 681 - Secure Software Design",
];

var allUndergradClasses = [
    "SWE 205 - Software Usability Analysis and Design",
    "SWE 321 - Software Engineering.",
    "SWE 437 - Software Testing and Maintenance",
    "CS 310 - Data Structures",
    "CS 471 - Operating Systems.",
    "CS 484 - Data Mining"
];
var classLevelGrad = false;
var changed = false;

var loginVerified = false;
var userLoginData;

var linkedInLinked = false;

var searchCriteriaLevel = "";

$(function () {

    $('#btn-login').click(function () {
        $('#verify-process-tag-login').show();

        $('#login-alert').hide();
        $.each(loginInfo, function (index, value) {
            if ($('#login-username').val() == value.username) {
                if ($('#login-password').val() == value.password) {
                    loginVerified = true;
                }
            }
        });


        if (loginVerified) {
            loginVerified = true;
            userLogin = $('#login-username').val();
            $('#login-template').hide();

            $.get("/api/student/" + userLogin, function (data) {
                userLoginData = data;
                $("#student-name-val").html(data.studentName);
                $("#student-gnumber-val").html(data.studentGNumber);
                $("#student-level-val").html(data.studentClassLevel);
                $("#student-major-val").html(data.studentMajor);
                $("#student-conc-val").html(data.studentConcentration);
                if (linkedInLinked) {
                    $("#student-linkedin-val").html(data.studentLinkedIn);
                }
                else {
                    $("#student-linkedin-val").html("Not Yet Provided. <a id='linkedin-link-summary' class='btn btn-block btn-social btn-linkedin'><span class='col-md-4 fa fa-linkedin'></span> Link Your LinkedIn!</a>");
                }
                // After data is loaded, show the switch based on the class level
                // By default it is checked for Grad

                if (userLoginData.studentMajor == "Under Graduate") {
                    $("#class-level").prop("checked", false).change();
                    searchCriteriaLevel = "undergrad";
                }
                else{
                    searchCriteriaLevel = "grad";
                }
            });



            $.get("/api/student/" + userLogin + "/completed", function (data) {
                $("#core-classes").html("");
                $("#concentration-classes").html("");

                var completedCourses = data;
                var coreHtml = "", concentrationHtml = "";
                for (var i = 0; i < data.length; i++) {
                    var eachCourse = data[i];
                    if (data[i].courseMajor == "Core") {
                        coreHtml += "<li>" + data[i].courseName + " - " + data[i].courseSection + "</li>";
                    }
                    else {
                        concentrationHtml += "<li>" + data[i].courseName + " - " + data[i].courseSection + "</li>";
                    }
                }
                $("#core-classes").append(coreHtml);
                $("#concentration-classes").append(concentrationHtml);
            });
            displayLoadingPage();
        }
        else {
            setTimeout(function () {
                $('#login-alert').show();
            }, 1000)
        }
        $('#verify-process-tag-login').hide();
    });


    // Display the textbox to type in LinkedIn Address
    $('#linkedin-link').click(function (event) {
        event.preventDefault();
        $('#new-feature').modal('hide');
        // Load up a new modal...
        $('#linkedin-verify-template').modal('show');
    });

    // Display verify page by appending after the input textbox
    $('#verify-linkedin-button').click(function () {
        $('#verify-process-tag-linkedin').show();
        setTimeout(function () {
            $('#verify-process-tag-linkedin').hide();
            $.each(linkedUrlList, function (index, value) {
                if ($('#linkedin-url').val() == value) {
                    $('#verify-linkedin').slideToggle("slow");
                }
            });

            $('#linkedin-error-label').show();
        }, 1000);

    });
    // Slide toggle to close the verify page
    $('#reject-linkedin').click(function () {
        $('#verify-linkedin').slideToggle("slow");
    });

    // Verify linkedin page
    $('[data-toggle=tooltip]').tooltip();

    // Create a new registration
    $("#create").click(function (event) {
        event.preventDefault();
        $("#main-menu-template").hide();
        $("#new-registration-template").show();


        $.get("/api/student/get-master-dummy", function (data) {
            alert("Student ID: " + data.studentId);
            alert("Student Title: " + data.title);
            alert("Student Category: " + data.category);
            if (data.title == 'Master') {
                dynamicClassList = allMasterClasses;
            }
            else {
                dynamicClassList = allUndergradClasses;
            }
            renderClassList();
        });
    });

    // Modify the existing registration - STILL DUMMY - TESTING MASTER VS UNDERGRADS
    $("#modify").click(function (event) {
        event.preventDefault();
        $("#main-menu-template").hide();
        $("#new-registration-template").show();

        $.get("/api/student/get-undergrad-dummy", function (data) {
            alert("Student ID: " + data.studentId);
            alert("Student Title: " + data.title);
            alert("Student Category: " + data.category);
            if (data.title == 'Master') {
                dynamicClassList = allMasterClasses;
            }
            else {
                dynamicClassList = allUndergradClasses;
            }
            renderClassList();
        });
    });

    $(".major").change(function () {
        if ($("#software-engineer").prop("checked") || $("#computer-science").prop("checked")) {
            $("#calculate-suggestion").slideDown("slow");
        }
        else {
            $("#calculate-suggestion").slideUp("slow");
        }
    })



    // Autocomplete Search for undergrads
    $('#undergrads').on('change', function () {
        $('#class-selection-val').html('You selected: ' + this.value);
    }).change();
    $('#undergrads').on('autocompleteselect', function (e, ui) {
        $('#class-selection-val').html('You selected: ' + ui.item.value);
    });

    // Autocomplete Search for masters
    $('#class-selection').on('change', function () {
        $('#class-selection-val').html('You selected: ' + this.value);
    }).change();
    $('#class-selection').on('autocompleteselect', function (e, ui) {
        $('#class-selection-val').html('You selected: ' + ui.item.value);
    });

    // Autocomplete trigger for undergrads
    // $("#undergrads").autocomplete({
    //     source: allUndergradClasses
    // });


    $("#student-questionnaire").click(function (event) {
        // $("#new-registration-direct-search-template").hide();
        $("#new-registration-questionnaire-template").show();
    });

    // $("#class-level").change(function () {
    //     if ($(this).prop("checked") == true) {
    //         classLevelGrad = true;
    //     } else {
    //         classLevelGrad = false;
    //     }
    // });

    // $("#check-all-major").click(function () {
    //     $(".major").prop('checked', $(this).prop('checked'));
    // });

    $("#class-level").change(function () {
        if ($(this).prop("checked") == true) {
            searchCriteriaLevel = "grad";
            if (userLoginData.studentClassLevel == "Under Graduate") {
                $("#class-level-mismatch").slideDown();
            }
            else {
                $("#class-level-mismatch").slideUp();
            }
        }
        else {
            searchCriteriaLevel = "undergrad";
            if (userLoginData.studentClassLevel == "Graduate") {
                $("#class-level-mismatch").slideDown();
            }
            else {
                $("#class-level-mismatch").slideUp();
            }
        }
    });

    $("#check-all-major").change(function () {
        $(".major").prop('checked', $(this).prop('checked')).change();
    });




    $("#calculate-suggestion").click(function () {
        $("#class-search-result-template").slideDown();
        // Reset search data
        $("#search-class-result").html("");

        var textChange = "";
        var searchResultList="";
        if ($("#software-engineer").prop('checked')) {
            $.get("/api/courses/" + searchCriteriaLevel + "/swe", function (data) {
                for (var i = 0; i < data.length; i++) {
                    var eachCourse = data[i];
                    // If the the text change is different from the current data course name, write <li>
                    if (textChange != data[i].courseName) {
                        if (textChange != "") {
                            searchResultList += "</ul>"
                            searchResultList += "</li>"
                        }
                        // Update the text change
                        textChange = data[i].courseName;
                        searchResultList += ("<li>" + data[i].courseName);
                        searchResultList += ("<button id='" + data[i] + "-detailsbutton'" + " class='btn btn-primary'>Details</button>");
                        searchResultList += "<ul>";
                    }
                    searchResultList += ("<li>" + data[i].courseName + " - " + data[i].courseSection + " " + data[i].courseDate + " - " + data[i].courseTimePeriod);

                    searchResultList += ("<button id='" + data[i].courseName + "-" + data[i].courseSection + "-registerbutton'" + " class='btn btn-success'");
                    
                    searchResultList += (" onclick='register" + data[i].courseName + "Section" + data[i].courseSection + "'>Register</button>");

                    searchResultList += "</li>";

                }
                $("#search-class-result").append(searchResultList);
            });
        }
        // Reset the text change
        textChange = ""

        if ($("#computer-science").prop('checked')) {
            $.get("/api/courses/" + searchCriteriaLevel + "/cs", function (data) {
                for (var i = 0; i < data.length; i++) {
                    var eachCourse = data[i];
                    // If the the text change is different from the current data course name, write <li>
                    if (textChange != data[i].courseName) {
                        if (textChange != "") {
                            searchResultList += "</ul>"
                            searchResultList += "</li>"
                        }
                        // Update the text change
                        textChange = data[i].courseName;
                        searchResultList += ("<li>" + data[i].courseName);
                        searchResultList += ("<button id='" + data[i] + "-detailsbutton'" + " class='btn btn-primary'>Details</button>");
                        searchResultList += "<ul>";
                    }
                    searchResultList += ("<li>" + data[i].courseName + " - " + data[i].courseSection + " " + data[i].courseDate + " - " + data[i].courseTimePeriod);

                    searchResultList += ("<button id='" + data[i].courseName + "-" + data[i].courseSection + "-registerbutton'" + " class='btn btn-success'");
                    
                    searchResultList += (" onclick='register" + data[i].courseName + "Section" + data[i].courseSection + "'>Register</button>");

                    searchResultList += "</li>";
                }
                $("#search-class-result").append(searchResultList);
            });
        }
    });

    // Register for SWE645
    $("#SWE645-01-registerbutton").click(function(){

    })

});


function displayLoadingPage() {
    $('#loading-page-template').show();
    var elem = $("#loading-bar");
    var barWidth = 1;
    var id = setInterval(frame, 1);
    function frame() {
        if (barWidth >= 100) {
            clearInterval(id);
            setTimeout(function () {
                $('#loading-page-template').hide();
                $('#fixed-navbar-template').show();
                $('#main-menu-template').show();
                $('#new-feature').modal('show');
            }, 1000);
        } else {

            barWidth += 1;
            $("#complete-percentage").html(barWidth);
            elem.width(barWidth + '%');
        }
    }

}


function renderClassList() {
    // Autocomplete trigger for masters/undergrads
    $("#class-selection").autocomplete({
        source: dynamicClassList
    });
}

function registerSWE645Section01() {
    $(".registered-class").html("SWE645 - Section 01");
    $("#new-registration-template").hide();
    $("#registration-suggestion-template").show();
}

function slideClassCategory() {


}




