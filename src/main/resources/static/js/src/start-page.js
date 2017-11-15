var dynamicClassList = [];


var loginInfo = [

    {'username': 'vtran18',
    'password': 'monkeyisland123'
    },
    {'username': 'divya',
    'password': '123'
    },
    {'username': 'nuthana',
    'password': '456'
    }

]


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

var userLogin;

var linkedInLinked = false;

$(function() {
    
    $('#btn-login').click(function(){

        


        userLogin=$('#login-username').val();
        $('#login-template').hide();
        

        $.get( "/api/student/" + userLogin, function( data ) {
            $("#student-name-val").html(data.studentName);
            $("#student-gnumber-val").html(data.studentGNumber);
            $("#student-level-val").html(data.studentClassLevel);
            $("#student-major-val").html(data.studentMajor);
            $("#student-conc-val").html(data.studentConcentration);
            if (linkedInLinked){
                $("#student-linkedin-val").html(data.studentLinkedIn);
            }
            else{
                $("#student-linkedin-val").html("Not Yet Provided. <a id='linkedin-link-summary' class='col-md-4 btn btn-block btn-social btn-linkedin'><span class='fa fa-linkedin'></span> Link Your LinkedIn!</a>");
            }
        });

        $.get( "/api/student/" + userLogin + "/completed", function( data ) {
            var completedCourses = data;
            var coreHtml ="", concentrationHtml="";
            for (var i = 0; i < data.length; i++){
                var eachCourse = data[i];
                if (data[i].courseMajor == "Core" ){
                    coreHtml += "<li>" + data[i].courseName + " - " + data[i].courseSection + "</li>";
                }
                else{
                    concentrationHtml += "<li>" + data[i].courseName + " - " + data[i].courseSection + "</li>";
                }
            }
            $("#core-classes").html(coreHtml);
            $("#concentration-classes").html(concentrationHtml);
        });

        displayLoadingPage();

    });
       

    // Display the textbox to type in LinkedIn Address
    $('#linkedin-link').click(function(event){
        event.preventDefault();
        $('#linkedin-verify-template').modal('show');

    });

    // Display verify page by appending after the input textbox

    // Verify linkedin page
    $('[data-toggle=tooltip]').tooltip();

    // Create a new registration
    $("#create").click(function(event){
        event.preventDefault();
        $("#main-menu-template").hide();
        $("#new-registration-template").show();

        
        $.get( "/api/student/get-master-dummy", function( data ) {
            alert( "Student ID: " + data.studentId );
            alert( "Student Title: " + data.title );
            alert( "Student Category: " + data.category );
            if (data.title == 'Master'){
                dynamicClassList = allMasterClasses;
            }
            else{
                dynamicClassList = allUndergradClasses;
            }
            renderClassList();
        });
    });

    // Modify the existing registration - STILL DUMMY - TESTING MASTER VS UNDERGRADS
    $("#modify").click(function(event){
        event.preventDefault();
        $("#main-menu-template").hide();
        $("#new-registration-template").show();

        $.get( "/api/student/get-undergrad-dummy", function( data ) {
            alert( "Student ID: " + data.studentId );
            alert( "Student Title: " + data.title );
            alert( "Student Category: " + data.category );
            if (data.title == 'Master'){
                dynamicClassList = allMasterClasses;
            }
            else{
                dynamicClassList = allUndergradClasses;
            }
            renderClassList();
        });
    });    

    $("#new-registration-questionnaire-template").hide();

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


    $("#student-questionnaire").click(function(event){   
        $("#new-registration-direct-search-template").hide();
        $("#new-registration-questionnaire-template").show();
    });

    $("#class-level").change(function(){
        if($(this).prop("checked") == true){
            classLevelGrad = true;
        }else{
            classLevelGrad = false;
        }
    });    

    // $("#check-all-major").click(function () {
    //     $(".major").prop('checked', $(this).prop('checked'));
    // });

    $("#check-all-major").change(function () {
        $(".major").prop('checked', $(this).prop('checked')).change();
    });    
});


function displayLoadingPage(){
    $('#loading-page-template').show();
    var elem = $("#loading-bar"); 
    var barWidth = 1;
    var id = setInterval(frame, 1);
    function frame() {
        if (barWidth >= 100) {
            clearInterval(id);
            setTimeout(function(){ 
                $('#loading-page-template').hide();
                $('#fixed-navbar-template').show();
                $('#main-menu-template').show();
                $('#new-feature').modal('show'); 
            }, 1250);
        } else {
           
            barWidth+=1; 
            $("#complete-percentage").html(barWidth);
            elem.width(barWidth + '%'); 
        }
    }
    
}


function renderClassList(){
    // Autocomplete trigger for masters/undergrads
    $("#class-selection").autocomplete({
        source: dynamicClassList
    });
}

function displayNextQuestion(changed){

}

function slideClassCategory(){

 
}




