<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE = edge,chrome = 1" />
	<title>Hello World using Backbone.js</title>

	<!-- ========= -->
	<!-- Stylesheets -->
	<!-- ========= -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/docs.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-social.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css" />

	<!-- Custom Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom/custom-stylesheet.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.scss" />
	<!-- ========= -->
	<!-- Libraries -->
	<!-- ========= -->
	<script src="${pageContext.request.contextPath}/js/lib/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/json2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery-ui.js" type="text/javascript"></script>


	<!-- ========= -->
	<!-- JavaScript Function -->
	<!-- ========= -->
	<script src="${pageContext.request.contextPath}/js/src/start-page.js" type="text/javascript"></script>

</head>

<body>
	<!-- ========= -->
	<!-- Your HTML -->
	<!-- ========= -->

	<jsp:include page="/fixed-navbar.jsp" />

	<div id = "new-registration-template" class = "body-content">
		<jsp:include page="/new-registration.jsp" />
	</div>

	
	<div id='main-menu-template' class = 'body-content'>
		<jsp:include page="/title.jsp" />
		<div class="panel-group" id="accordion">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">1. Student Summary</a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in">
					<div class="panel-body">
						<ul>
							<li>
								<span>Name: Viet Tran</span>
							</li>
							<li>
								<span>Class Level: Graduate</span>
							</li>
							<li>
								<span>Student Type: Part-time</span>
							</li>
							<li>
								<span>Major: MS Software Engineering </span>
							</li>
							<li>
								<span>Emphasis: Web Apps Design and Development</span>
							</li>
						</ul>

						<!-- <span>Name: ${student.firstName} ${student.firstName}</span> -->
						<!-- <span>Class Level: ${student.classLevel}</span>  -->

					</div>
				</div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">2. Completed Courses</a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse">
					<div class="panel-body">
						<p>Bootstrap is a powerful front-end framework for faster and easier web development. It is a collection of CSS and HTML
							conventions.
							<a href="https://www.tutorialrepublic.com/twitter-bootstrap-tutorial/" target="_blank">Learn more.</a>
						</p>
					</div>
				</div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">3. Main Menu</a>
					</h4>
				</div>
				<div id="collapseThree" class="panel-collapse collapse">
					<div class="panel-body">
						<div class="list-group">

							<a href="#" id = "create" class="list-group-item">
								CREATE A NEW REGISTRATION SESSION
							</a>
							<a href="#" id = "modify"  class="list-group-item">
								MODIFY THE EXISTING REGISTRATION SESSION - DUMMY
							</a>
							<a href="#" class="list-group-item">
								VIEW YOUR CURRENT REGISTRATION SESSION
							</a>
							<a href="#" class="list-group-item">
								WRITE A REVIEW FOR YOUR COMPLETED COURSES
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>



</html>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Feature - Built-in Social Network</h4>
				</div>
				<div class="modal-body">
	
					<p>Our new class registration user interface would use your LinkedIn Profile to create an "internal social
						network" within the school. By sharing your profile at our registration system, not only would you
						have an opportunity to match other classmates of same career interests, but you could also allow
						our school’s affiliated partners to find you earlier.
					</p>
	
					<p>Your LinkedIn profile is public anyways, so why not using it properly to introduce yourself to the industry
						as soon as possible? Before all these opportunities happen, we would need your permission to link
						your LinkedIn profile to our system, and we would help you do the rest! By clicking on Linked My
						LinkedIn, you have read and agreed our Terms and Conditions of our Privacy agreement.
					</p>
	
					<div class="row">
						<div class="col-md-2">
							<button type="button" class="btn btn-default">No Thanks!</button>
						</div>
						<div class="col-md-6">
							<a class="btn btn-block btn-social btn-linkedin">
								<span class="fa fa-linkedin"></span> Sign in with LinkedIn
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>