<div class="alert alert-success">
    <strong>Success!</strong> You have successfully registered
    <strong class="registered-class"></strong>!
</div>

<div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">Further Recommendations</div>
    <div class="panel-body">

        <div>
            <p>Our system also provides further recommendations based on your student background and recent selection.</p>
            <p>Below is the list of recommendations with details:</p>
        </div>
        <ul>
            <div class="row">
                <li>
                    <div class="col-md-8">
                        <div class="h4" id="cs584-recommend-class" style="font-weight:bold; margin-top: 0px;">CS 584 - User Interface Design and Development</div>
                        <p>since 88% of students who took them together got A's in both classes</p>
                    </div>
                    <div class="col-md-4">
                        <a class="btn icon-btn btn-primary" href="#" id="viet-registration-suggestion-cs584-check-available-open-panel">
                            <span class="glyphicon btn-glyphicon glyphicon-list img-circle text-success"></span>Check Availability</a>
                    </div>
                </li>
            </div>

            <div class="row">
                <li>
                    <div class="col-md-8">
                        <div class="h4" id="swe637-recommend-class" style="font-weight:bold; margin-top: 0px;">SWE 637 - Software Testing</div>
                        <p>since you only have this core course left, and it will only be offered this upcoming semester!</p>
                    </div>
                    <div class="col-md-4">
                        <a class="btn icon-btn btn-primary suggestion-button" href="#" id="viet-registration-suggestion-swe637-check-available-open-panel">
                            <span class="glyphicon btn-glyphicon glyphicon-list img-circle text-success"></span>Check Availability</a>
                    </div>
                </li>
            </div>

        </ul>

        <div id="class-detail-CS584-template-suggest" style="display:none">
            <jsp:include page="/class-detail-CS584.jsp" />
        </div>


        <div id="viet-registration-suggestion-cs584-template" class="panel panel-primary" style="display:none">
            <!-- Default panel contents -->
            <div class="panel-heading">CS 584 Available Sections</div>
            <div class="panel-body">
                <div class="row">
                    <ul>
                        <div class="row" style="margin-bottom:20px">
                            <li>
                                <div class="col-md-5">
                                    <span>CS 584 - Section 1: Tuesday - 7:20 to 10:00 PM</span>
                                </div>
                                <div class="col-md-7">
                                    <a class="btn icon-btn btn-success suggestion-button" href="#">
                                        <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Register</a>
                                    <a class="btn icon-btn btn-primary suggestion-button" href="#" id="viet-registration-suggestion-cs584-see-details">
                                        <span class="glyphicon btn-glyphicon glyphicon-info-sign img-circle text-primary"></span>See Details</a>
                                </div>
                            </li>
                        </div>

                        <div class="row" style="margin-bottom:20px">
                            <li>
                                <div class="col-md-5">
                                    <span>CS 584 - Section 2: Wednesday - 4:30 to 7:10 PM</span>
                                </div>
                                <div class="col-md-7">
                                    <a class="btn icon-btn btn-success suggestion-button" href="#">
                                        <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Register</a>

                                    <a class="btn icon-btn btn-primary suggestion-button" href="#">
                                        <span class="glyphicon btn-glyphicon glyphicon-info-sign img-circle text-primary"></span>See Details</a>
                                </div>

                            </li>
                        </div>
                    </ul>
                    <div class="col-md-12">
                        <button id="viet-registration-suggestion-cs584-check-available-close-panel" class="btn btn-primary"> Close Suggestion Panel</button>
                    </div>
                </div>
            </div>
        </div>
        <div id="viet-registration-suggestion-swe637-template" class="panel panel-primary" style="display:none">
            <!-- Default panel contents -->
            <div class="panel-heading">SWE 637 Available Sections</div>
            <div class="panel-body">
                <div class="row">
                    <ul>
                        <div class="row" style="margin-bottom:20px">
                            <li>
                                <div class="col-md-5">
                                    <span>SWE 637 - Section 1: Monday - 4:30 to 7:10 PM</span>
                                </div>
                                <div class="col-md-7">
                                    <a class="btn icon-btn btn-success suggestion-button" href="#">
                                        <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Register</a>
                                    <a class="btn icon-btn btn-primary suggestion-button" href="#">
                                        <span class="glyphicon btn-glyphicon glyphicon-info-sign img-circle text-primary"></span>See Details</a>
                                </div>
                            </li>
                        </div>
                    </ul>
                    <div class="col-md-12">
                        <button id="viet-registration-suggestion-swe637-check-available-close-panel" class="btn btn-primary"> Close Suggestion Panel</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <button class="btn btn-primary main-menu-navigation-button">Back to Main Menu</button>
            </div>
        </div>
    </div>


</div>