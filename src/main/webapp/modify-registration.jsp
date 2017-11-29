<jsp:include page="/title.jsp" />

<div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">View/Modify Your Current Registration</div>
    <div class="panel-body">

        <div id="modify-confirm-delete-message" style="display:none">
            <div class="alert alert-success">
                <strong>Success!</strong> 
                You have dropped <strong>CS 584</strong> from your registration!
            </div>
        </div>

        <ul id="current-reg">
        </ul>

        
        <div id="viet-modify-more-info-swe645-template" style="display:none">
            <jsp:include page="/modify-more-info-swe645.jsp" />
        </div>

        <div id="viet-modify-drop-course-template" style="display:none">
            <jsp:include page="/delete-message.jsp" />
        </div>

        <div class="row">
            <div class="col-md-4">
                <button class="btn btn-primary main-menu-navigation-button">Back to Main Menu</button>
            </div>
        </div>
    </div>

</div>