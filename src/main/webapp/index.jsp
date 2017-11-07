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

<!-- Custom Stylesheets -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom/custom-stylesheet.css" />

<!-- ========= -->
<!-- Libraries -->
<!-- ========= -->
<script src="${pageContext.request.contextPath}/js/lib/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/lib/json2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/src/index.js" type="text/javascript"></script>

</head>

<body>
	<!-- ========= -->
	<!-- Your HTML -->
	<!-- ========= -->

	<jsp:include page="/fixed-navbar.jsp" />
	
	<div class="body-content">
	
		<p>Hello World</p>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Panel title</h3>
		</div>
		<div class="panel-body">
			
	
			
		<h1>Our Content goes here!</h1>


		
		</div>
		
	
	</div>
	
	</div>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">New Feature - Built-in Social Network</h4>
				</div>
				<div class="modal-body">
	
					<p>Our new class registration user interface would use your LinkedIn Profile to create an "internal social network" within the school. 
						By sharing your profile at our registration system, not only would you have an opportunity to match other classmates of same career interests, 
						but you could also allow our school’s affiliated partners to find you earlier.
					</p>
						
					<p>Your LinkedIn profile is public anyways, so why not using it properly to introduce yourself to the industry as soon as possible? 
						Before all these opportunities happen, we would need your permission to link your LinkedIn profile to our system, and we would help you do the rest! 
						By clicking on Linked My LinkedIn, you have read and agreed our Terms and Conditions of our Privacy agreement.
					</p>
					
					<div class="row">
						<div class = "col-md-2">
							<button type="button" class="btn btn-default">No Thanks!</button>
						</div>
						<div class = "col-md-6">
							<a class="btn btn-block btn-social btn-linkedin">
								<span class="fa fa-linkedin"></span> Sign in with LinkedIn
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	

	
	

	
	

</body>



</html>