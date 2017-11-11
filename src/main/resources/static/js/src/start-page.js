var dynamicClassList = [];

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

$(function() {
    $('#myModal').modal('show');
    $("#new-registration-template").hide();

    // Create a new registration
    $("#create").click(function(event){
        event.preventDefault();
        $("#main-menu-template").hide();
        $("#new-registration-template").show();

        
        $.get( "/api/student/get-master-dummy", function( data ) {
            alert( "Student ID: " + data.studentId );
            alert( "Student Title: " + data.title );
            alert( "Student Category: " + data.category );
            if (data.title === 'Master'){
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
            if (data.title === 'Master'){
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
           alert ($(this).val());
        }else{
            alert ($(this).val());
        }
    });    
    
});

function renderClassList(){
    // Autocomplete trigger for masters/undergrads
    $("#class-selection").autocomplete({
        source: dynamicClassList
    });
}





