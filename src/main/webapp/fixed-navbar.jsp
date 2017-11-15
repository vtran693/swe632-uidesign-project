<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nav_bar.css"/>
</head>
<body>
<div  id="nav_bar" class="navbar navbar-primary navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <!--       <a class="navbar-brand" href="#">
                            <img class="img-responsive" alt="Brand" src="${pageContext.request.contextPath}/img/mason-logo-green.gif}" />
                        </a> -->

        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a id="btn-home" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li>
                    <a href="#">New Registration</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Services
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                    	<li>
                            <a href="#">Submit Review</a>
                        </li>
                        <li>
                            <a href="#">My Grades</a>
                        </li>     
                        <li>
                            <a href="#">Current Class Schedule</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="https://library.gmu.edu/use/study-rooms" target="_blank">Group Study Rooms</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="https://library.gmu.edu/" target="_blank">University Libraries</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" />
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">HELP</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">Personal Information</a>
                        </li>
                        <li>
                            <a href="#">Student Services</a>
                        </li>
                        <li>
                            <a href="#">Financial Aid</a>
                        </li>
                        <li>
                            <a href="#">Employee Services</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="/web/home" class="btn btn-info btn-md">
          						<span class="glyphicon glyphicon-log-out"></span> Log out
        					</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</div>
</body>