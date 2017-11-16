<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE = edge,chrome = 1" />
	<title>Single-Page App - Smart Class Registration</title>

	<!-- ========= -->
	<!-- Stylesheets -->
	<!-- ========= -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/docs.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-social.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-toggle.css" />

	<!-- Custom Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom/custom-stylesheet.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.scss" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nav_bar.css" />

	<!-- For Linkedin Verification -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
	<!-- ========= -->
	<!-- Libraries -->
	<!-- ========= -->
	<script src="${pageContext.request.contextPath}/js/lib/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/json2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery-ui.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/bootstrap-toggle.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/lib/docs.js" type="text/javascript"></script>
	<!-- ========= -->
	<!-- JavaScript Function -->
	<!-- ========= -->
	<script src="${pageContext.request.contextPath}/js/src/start-page.js" type="text/javascript"></script>

</head>

<body>
	<!-- ========= -->
	<!-- Your HTML -->
	<!-- ========= -->

	<div id="fixed-navbar-template" style="display:none">
		<jsp:include page="/fixed-navbar.jsp" />
	</div>

	<div id="login-template" class="body-content">
		<jsp:include page="/login.jsp" />
	</div>

	<div id="loading-page-template" class="body-content" style="display:none">
		<jsp:include page="/loading-page.jsp" />
	</div>

	<div id="new-registration-template" class="body-content" style="display:none">
		<jsp:include page="/new-registration.jsp" />
	</div>
	<div id="modify-registration-template" class="body-content" style="display:none">
		<jsp:include page="/modify-registration.jsp" />
	</div>

	<div id="registration-suggestion-template" class="body-content" style="display:none">
		<jsp:include page="/registration-suggestion.jsp" />
	</div>

	<div id='main-menu-template' class='body-content' style="display:none">
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
								<span>Name: </span>
								<span id="student-name-val"></span>
							</li>
							<li>
								<span>G-Number: </span>
								<span id="student-gnumber-val"></span>
							</li>
							<li>
								<span>Class Level: </span>
								<span id="student-level-val"></span>
							</li>
							<li>
								<span>Major: </span>
								<span id="student-major-val"></span>
							</li>
							<li>
								<span>Concentration: </span>
								<span id="student-conc-val"></span>
							</li>
							<li>
								<span>LinkedIn Profile Link: </span>
								<span id="student-linkedin-val"></span>
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
						<div class="h4 list-heading">Core Courses</div>
						<ul id="core-classes"></ul>


						<div class="h4 list-heading">Concentration Courses</div>
						<ul id="concentration-classes">
						</ul>


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

								<a data-toggle="collapse" data-parent="#accordion" href="#collapseModify">MODIFY YOUR CURRENT REGISTRATION SESSION</a>
								<div id="collapseModify" class="panel-collapse collapse">
									<div class="alert alert-success alert-dismissable">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">Delete</a>
										<strong>CS 637</strong>
									</div>
								</div>
								<br/>
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseExisting">VIEW YOUR CURRENT REGISTRATION SESSION</a>
								<div id="collapseExisting" class="panel-collapse collapse">

									<ul id="current-reg">
										<li>CS584 - Data Mining</li>
									</ul>
								</div>
								<br/>
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseReview">WRITE A REVIEW</a>
								<div id="collapseReview" class="panel-collapse collapse">

								</div>
								<div class="list-group">

									<a href="#" id="create" class="list-group-item">
										CREATE A NEW REGISTRATION SESSION
									</a>
									<a href="#" class="list-group-item">
										VIEW YOUR CURRENT REGISTRATION SESSION
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="modal fade body-content" id="linkedin-verify-template" role="dialog" aria-labelledby="verify-linkedin-label">
				<jsp:include page="/input-linkedin.jsp" />
			</div>

			<div class="modal fade body-content" id="new-feature" tabindex="-1" role="dialog" aria-labelledby="new-feature-label">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="new-feature-label">New Feature - Built-in Social Network</h4>
						</div>
						<div class="modal-body">

							<p>Our new class registration user interface would use your LinkedIn Profile to create an "internal social network" within
								the school. By sharing your profile at our registration system, not only would you have an opportunity to match other
								classmates of same career interests, but you could also allow our school’s affiliated partners to find you earlier.
							</p>

							<p>Your LinkedIn profile is public anyways, so why not using it properly to introduce yourself to the industry as soon
								as possible? Before all these opportunities happen, we would need your permission to link your LinkedIn profile to
								our system, and we would help you do the rest! By clicking on Linked My LinkedIn, you have read and agreed our Terms
								and Conditions of our Privacy agreement.
							</p>

							<div class="row">
								<div class="col-md-2">
									<button type="button" class="btn btn-default" data-dismiss="modal"> Not Now</button>
								</div>
								<div class="col-md-6">
									<a id="linkedin-link" class="btn btn-block btn-social btn-linkedin" data-dismiss="modal">
										<span class="fa fa-linkedin"></span> Link Your LinkedIn!
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal HTML -->
			<div id="confirm-success" class="modal fade body-content">
				<div class="modal-dialog modal-confirm">
					<div class="modal-content">
						<div class="modal-header">
							<div class="icon-box">
								<i class="material-icons">&#xE876;</i>
							</div>
							<h4 class="modal-title">Awesome!</h4>
						</div>
						<div class="modal-body">
							<p class="text-center">Your LinkedIn Profile Link has been added to our system. Click OK to Proceed</p>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success btn-block" data-dismiss="modal">OK</button>
						</div>
					</div>
				</div>
			</div>

</body>

</html>