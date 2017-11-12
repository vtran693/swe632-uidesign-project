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
	
		<div align="center">
		<iframe src="https://us-east-1.online.tableau.com/t/divyavajja/views/SWE632/SWE621?:embed=y&:showAppBanner=false&:showShareOptions=true&:display_count=no&:showVizHome=no" height="500" width="1000"></iframe><br/><br/><br/>
		</div>
		
		<div class="panel-group">
   		<div class="panel panel-default">
      	<div class="panel-heading">
	        <h4 class="panel-title">
	          <a data-toggle="collapse" href="#collapse1">Reviews</a>
	        </h4>
    	</div>
      	<div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body">
              <div class="media">
              <div class="media-left">
                <img src="img_avatar1.png" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                <a class="media-heading" href="http://www.linkedin.com/in/divya-vajja-ab80a478">Divya Vajja - Student</a>
                <p>CS 550 was a core course and it was very interesting to take under Amihai Motro</p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="img_avatar1.png" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                <a class="media-heading">Left-aligned</a>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="img_avatar1.png" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                <h4 class="media-heading">Left-aligned</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
              </div>
              </div>
              <hr>
        </div>
      </div>
    </div>
  </div>
</div>
	<div align="center">
	<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span> Add Class to Cart</button>
  	<button type="button" class="btn btn-primary">Back to Class Suggestions</button>
	</div>

	
	
		

</body>



</html>