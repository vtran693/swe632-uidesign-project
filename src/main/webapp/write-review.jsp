<div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">Write Reviews</div>
    <div class="panel-body">
        <h4>Views</h4>
        <h4>All Courses</h4>


        <h4>Below is the list of your completed courses.</h4>
        <ul class="nav nav-tabs">
            <li role="presentation" class="active">
                <a href="#">Level Order</a>
            </li>
            <li role="presentation">
                <a href="#">Semester Order</a>
            </li>
        </ul>





        <div id="class-order-review-panel" class="panel panel-info">
            <!-- Default panel contents -->
            <div class="panel-heading">Class Order View</div>
            <div class="panel-body">
                <div id="undergrad-class-order-view-review-template" style="display:none">
                    <jsp:include page="/undergrad-class-order-view.jsp"/>
                </div>
        

            </div>
        </div>

        <div id="semester-order-review-panel" class="panel panel-info">
            <!-- Default panel contents -->
            <div class="panel-heading">SWE 632 Available Sections</div>
            <div class="panel-body">
                <div class="row">
                    <ul>
                        <li>
                            <span>SWE 632 - Section 1: Wednesday - 7:20 to 10:00
                                <a class="btn icon-btn btn-success" href="#">
                                    <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Register</a>
                            </span>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <ul>
                        <li>
                            <span>SWE 632 - Section 1: Wednesday - 7:20 to 10:00
                                <a class="btn icon-btn btn-success" href="#">
                                    <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Register</a>
                            </span>
                        </li>
                    </ul>
                </div>


            </div>
        </div>


        <button class="btn btn-primary" id="main-menu-navigation-button">Back to Main Menu</button>


    </div>
</div>