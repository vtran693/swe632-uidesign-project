var dynamicClassList = [];

var textChangeForClassRegistration = "";

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
    "https://www.linkedin.com/in/viet-tran-272570108/",
    "https://www.linkedin.com/in/nuthanat/",
    "https://www.linkedin.com/in/divya-vajja-ab80a478/"
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
var coreHtml = "";
var concentrationHtml = "";
var regHtml = "";
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
                    $("#student-linkedin-val").html("Not Yet Provided.");
                }
                // After data is loaded, show the switch based on the class level
                // By default it is checked for Grad

                if (userLoginData.studentMajor == "Under Graduate") {
                    $("#class-level").prop("checked", false).change();
                    searchCriteriaLevel = "undergrad";
                }
                else {
                    searchCriteriaLevel = "grad";
                }
            });



            $.get("/api/student/" + userLogin + "/completed", function (data) {

                var completedCourses = data;
                coreHtml = ""
                concentrationHtml = "";
                for (var i = 0; i < data.length; i++) {
                    var eachCourse = data[i];
                    if (data[i].courseConcentration == "Core") {
                        coreHtml += ("<li>" + data[i].courseName + " - " + "Section " + data[i].courseSection + "</li>");
                    }
                    else {
                        concentrationHtml += ("<li>" + data[i].courseName + " - " + "Section " + data[i].courseSection + "</li>");
                    }
                }
                if (coreHtml == "") {
                    coreHtml = "You have not taken any Core classes yet";
                }
                if (concentrationHtml == "") {
                    concentrationHtml = "You have not taken any Concentration classes yet";
                }
                $("#core-classes").html(coreHtml);
                $("#concentration-classes").html(concentrationHtml);
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


    // Ok button
    $("#ok-button").click(function () {
        $("#student-linkedin-val").html(userLoginData.studentLinkedIn);
        // Hide the linkedin verify page
        $("#linkedin-verify-template").modal('hide');
        $("#linkedin-input-button").hide();
        $('#verify-linkedin').slideUp("slow");
    });

    // Click the LinkedIn button
    $("#linkedin-input-button").click(function (){
        $("#linkedin-verify-template").modal('show');
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

        var matched = false;
        $('#verify-process-tag-linkedin').show();
        setTimeout(function () {
            $('#verify-process-tag-linkedin').hide();
            $.each(linkedUrlList, function (index, value) {
                if ($('#linkedin-url').val() == value) {
                    $('#verify-linkedin').slideToggle("slow");
                    $("#verify-linkedin-button").hide();
                    $("#not-now-linkedin-button").hide();
                    matched = true;
                }
            });
            if (matched == true) {
                $('#linkedin-error-label').hide();

            }
            else {
                $('#linkedin-error-label').show();
            }

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
        $("#modify-registration-template").hide();
        $("#write-review-template").hide();
        $("#new-registration-template").show();


        $.get("/api/student/get-master-dummy", function (data) {

            if (data.title == 'Master') {
                dynamicClassList = allMasterClasses;
            }
            else {
                dynamicClassList = allUndergradClasses;
            }
            renderClassList();
        });
    });

    $(".create-global-class").click(function (event) {
        event.preventDefault();

        returnHome();

        $("#new-registration-template").show();


        $.get("/api/student/get-master-dummy", function (data) {

            if (data.title == 'Master') {
                dynamicClassList = allMasterClasses;
            }
            else {
                dynamicClassList = allUndergradClasses;
            }
            renderClassList();
        });
    });

    $("#view-modify").click(function (event) {
        event.preventDefault();
        $("#main-menu-template").hide();
        $("#write-review-template").hide();
        $("#new-registration-template").hide();
        $("#modify-registration-template").show();


        $.get("/api/student/" + userLogin + "/registered", function (data) {
            var registeredCourses = data;
            regHtml = "";
            modHtml = "";
            for (var i = 0; i < data.length; i++) {

                // Add the div class row
                regHtml += ("<div class='row'>");
                // Start the list
                regHtml += ("<li>");
                // Align class description
                regHtml += ("<div class='col-md-8'>");

                regHtml += (data[i].courseName + " - " + "Section " + data[i].courseSection + "  - Prof. " + data[i].courseProfessor + " - " + "Day & Time :" + data[i].courseDate + "-" + data[i].courseTimePeriod);
                // Close class description alignment
                regHtml += ("</div>");
                // Align Info/Drop button
                regHtml += ("<div class='col-md-4 info-drop'>");

                // Add the More Info button
                regHtml += ("<a id='" + data[i].courseName + "-more-info-button'" + " class='btn icon-btn btn-warning' href='#' onclick='" + data[i].courseName + "MoreInfo()'>");

                regHtml += ("<span class='glyphicon btn-glyphicon glyphicon-trash img-circle text-warning'></span> More Info </a>")

                // Add the Drop button
                regHtml += ("<a id='" + data[i].courseName + "-delete-button'" + " class='btn icon-btn btn-danger' href='#' onclick='" + data[i].courseName + "MoreInfo()'>");

                regHtml += ("<span class='glyphicon btn-glyphicon glyphicon-trash img-circle text-danger'></span> Drop </a>")
                // Close class description alignment
                regHtml += ("</div>");
                // End the list
                regHtml += ("</li>");
                // End the row
                regHtml += ("</div>");
            }
            if (regHtml == "") {
                regHtml = "You have not yet registered to any courses. Please click on CREATE A NEW REGISTRATION SESSION";
            }

            $("#current-reg").html(regHtml);

        });

    });


    // Modify the existing registration - STILL DUMMY - TESTING MASTER VS UNDERGRADS
    $("#modify").click(function (event) {
        event.preventDefault();
        $("#main-menu-template").hide();
        $("#new-registration-template").show();

        $.get("/api/student/get-undergrad-dummy", function (data) {

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

        var searchResultList = "";
        if ($("#software-engineer").prop('checked')) {
            $.get("/api/courses/" + searchCriteriaLevel + "/swe", function (data) {
                for (var i = 0; i < data.length; i++) {
                    searchResultList = writeClassSuggestion(searchResultList, data, i);
                }
                $("#search-class-result").append(searchResultList);
            });
        }
        // Reset the text change
        textChangeForClassRegistration = "";
        searchResultList = "";
        if ($("#computer-science").prop('checked')) {
            $.get("/api/courses/" + searchCriteriaLevel + "/cs", function (data) {
                for (var i = 0; i < data.length; i++) {
                    searchResultList = writeClassSuggestion(searchResultList, data, i);
                }
                $("#search-class-result").append(searchResultList);
            });
        }
        // Reset the text change
        textChangeForClassRegistration = "";
    });




    // Register for SWE645
    $("#SWE645-01-registerbutton").click(function () {

    });
    
    // Register for SWE632
    $("#SWE632-01-registerbutton").click(function () {

    });

    // The back to main menu button at the suggestion page
    $(".main-menu-navigation-button").click(function (event) {
        event.preventDefault();
        returnHome();
    });

    // Navigation home logo click
    $("#btn-home").click(function () {
        returnHome();
    });

    // Write review page display
    $("#write-review-option").click(function () {
        $("#main-menu-template").hide();
        $("#write-review-template").show();
    });

    $("#modify-more-info-button").click(function (event) {
        event.preventDefault();
        $("modify-more-info-message-template").slideDown();
        $("modify-delete-message-template").slideUp();
    });

    $("#modify-delete-button").click(function (event) {
        event.preventDefault();
        $("modify-more-info-message-template").slideUp();
        $("modify-delete-message-template").slideDown();
    });

    // Class Suggestions
    
    $("#nuthana-registration-suggestion-swe645-check-available-open-panel").click(function (event) {
        event.preventDefault();
        $("#nuthana-registration-suggestion-swe645-template").slideDown();
    });
    
    $("#nuthana-registration-suggestion-swe645-check-available-close-panel").click(function (event) {
        event.preventDefault();
        $("#nuthana-registration-suggestion-swe645-template").slideUp();

    });
    
    $("#nuthana-registration-suggestion-swe642-check-available-open-panel").click(function (event) {
        event.preventDefault();
        $("#nuthana-registration-suggestion-swe642-template").slideDown();
    });
    
    $("#nuthana-registration-suggestion-swe642-check-available-close-panel").click(function (event) {
        event.preventDefault();
        $("#nuthana-registration-suggestion-swe642-template").slideUp();

    });

    $("#viet-registration-suggestion-swe632-check-available-open-panel").click(function (event) {
        event.preventDefault();
        $("#viet-registration-suggestion-swe632-template").slideDown();
    });
    

    $("#viet-registration-suggestion-swe632-check-available-close-panel").click(function (event) {
        event.preventDefault();
        $("#viet-registration-suggestion-swe632-template").slideUp();

    });

    $("#viet-registration-suggestion-swe637-check-available-open-panel").click(function (event) {
        event.preventDefault();
        $("#viet-registration-suggestion-swe637-template").slideDown();

    });

    $("#viet-registration-suggestion-swe637-check-available-close-panel").click(function (event) {
        event.preventDefault();
        $("#viet-registration-suggestion-swe637-template").slideUp();

    });


});

function writeClassSuggestion(searchResultList, data, i) {
    // If the the text change is different from the current data course name, write <li>
    if (textChangeForClassRegistration != data[i].courseName) {
        if (textChangeForClassRegistration != "") {
            searchResultList += "</ul>"
            searchResultList += "</li>"
            // End the row
            searchResultList += ("</div>");
        }
        // Update the text change
        textChangeForClassRegistration = data[i].courseName;

        // Start a new row of class
        searchResultList += ("<div class='row'>");


        searchResultList += ("<li>");

        // Start the description for class
        searchResultList += ("<div class='col-md-8'>");
        searchResultList += ("<a href='#' id='" + data[i].courseName + "-detailsbutton'" + " onclick='view" + data[i].courseName + "Details()'>");
        searchResultList += data[i].courseName;
        searchResultList += "</a>";

        // Close the description for class
        searchResultList += ("</div>");

        // Start an empty div
        searchResultList += ("<div class='col-md-4'>");
        // Close the button for class details
        searchResultList += ("</div>");

        // Start an line div
        searchResultList += ("<div class='row'>");

        // Add a title before showing sections
        searchResultList += ("<span style='font-weight:bold'>Available Sections</span>");
        // Close the line div
        searchResultList += ("</div>");

        searchResultList += "<ul>";
    }

    searchResultList += ("<li>");

    // Start the description for section
    searchResultList += ("<div class='col-md-5'>");
    searchResultList += (data[i].courseName + " - " + "Section " + data[i].courseSection + "<br>");
    searchResultList += ("Class Schedule: " + data[i].courseDate + " from " + data[i].courseTimePeriod);

    // Close the description for section
    searchResultList += ("</div>");

    // Start the button for class registration
    searchResultList += ("<div class='col-md-7'>");
     
    // Build the register button
    searchResultList += ("<a class='btn icon-btn btn-success' href='#' id='" + data[i].courseName + "-" + data[i].courseSection + "-registerbutton'");

    searchResultList += (" onclick='register" + data[i].courseName + "Section" + data[i].courseSection + "()'>");

    searchResultList += ("<span class='glyphicon btn-glyphicon glyphicon-plus img-circle text-success'></span>Register</a>");

    // Close the button for section
    searchResultList += ("</div>");

    searchResultList += "</li>";

    return searchResultList;
}


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

function registerSWE632Section01() {
    $(".registered-class").html("SWE632 - Section 01");
    $("#new-registration-template").hide();
    $("#registration-suggestion-template-nuthana").show();
}

function registerSWE437Section01() {
    $(".registered-class").html("SWE437 - Section 01");
    $("#new-registration-template").hide();
    $("#registration-suggestion-template-divya").show();
}

function viewSWE621Details() {
    $("#class-detail-SWE621-template").slideDown();
    $("#class-detail-SWE632-template").hide();
    $("#class-detail-SWE645-template").hide();
    $("#class-detail-SWE437-template").hide();
    $("#class-detail-CS550-template").hide();
    $("#class-detail-CS584-template").hide();
}

function viewSWE632Details() {
    $("#class-detail-SWE621-template").hide();
    $("#class-detail-SWE632-template").slideDown();
    $("#class-detail-SWE645-template").hide();
    $("#class-detail-SWE437-template").hide();
    $("#class-detail-CS550-template").hide();
    $("#class-detail-CS584-template").hide();
}
function viewSWE645Details() {
    $("#class-detail-SWE621-template").hide();
    $("#class-detail-SWE632-template").hide();
    $("#class-detail-SWE645-template").slideDown();
    $("#class-detail-SWE437-template").hide();
    $("#class-detail-CS550-template").hide();
    $("#class-detail-CS584-template").hide();
}
function viewSWE437Details() {
    $("#class-detail-SWE621-template").hide();
    $("#class-detail-SWE632-template").hide();
    $("#class-detail-SWE645-template").hide();
    $("#class-detail-SWE437-template").slideDown();
    $("#class-detail-CS550-template").hide();
    $("#class-detail-CS584-template").hide();
}
function viewCS550Details() {
    $("#class-detail-SWE621-template").hide();
    $("#class-detail-SWE632-template").hide();
    $("#class-detail-SWE645-template").hide();
    $("#class-detail-SWE437-template").hide();
    $("#class-detail-CS550-template").slideDown();
    $("#class-detail-CS584-template").hide();
}
function viewCS584Details() {
    $("#class-detail-SWE621-template").hide();
    $("#class-detail-SWE632-template").hide();
    $("#class-detail-SWE645-template").hide();
    $("#class-detail-SWE437-template").hide();
    $("#class-detail-CS550-template").hide();
    $("#class-detail-CS584-template").slideDown();
}

function slideClassCategory() {
    $("#class-detail-CS550-template").slideDown();
}

function returnHome() {
    $("#new-registration-template").hide();
    $("#modify-registration-template").hide();
    $("#registration-suggestion-template").hide();
    $("#registration-suggestion-template-nuthana").hide();
    $("#registration-suggestion-template-divya").hide();
    $("#write-review-template").hide();
    $("#main-menu-template").show();
}









