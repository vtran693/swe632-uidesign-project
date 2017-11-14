
var VietTran =
JSON.stringify({
        'studentUsername': 'vtran18',
        'studentGNumber': 'g12345678',
        'studentClassLevel': 'graduate',
        'studentMajor': 'swe',
        'studentConcentration':'web',
        'studentCompletedCourses':

        [
            {
                'courseName': 'SWE632',
                'courseSection': '1',
                'courseDate': 'Wed',
                'courseTimePeriod': '7h20-10h00',
                'courseAvailability': 1
            },
            {
                'courseName': 'SWE645',
                'courseSection': '1',
                'courseDate': 'Thurs',
                'courseTimePeriod': '7h20-10h00',
                'courseAvailability': 1
            }
        ],
        'studentCurrentRegisteredCourses':
        [
            {
                'courseName': 'CS583',
                'courseSection': '1',
                'courseDate': 'Tues',
                'courseTimePeriod': '4h30-7h10',
                'courseAvailability': 0
            }
        ]
    }
);

$(function () {

    $("#viet-tran").click(function(event){
        event.preventDefault();

        $.ajax({
            url : "/api/student",
            type: "POST",
            data: VietTran,
            contentType: "application/json; charset=utf-8",
            dataType   : "json",
            success    : function(){
                alert("success");
            },
            fail       : function(xhr, status, error) {
                alert(status);
                alert(error);
            }
        });        
    });


       
});