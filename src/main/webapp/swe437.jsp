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
	<div class="container">
	
		<script type='text/javascript' src='https://us-east-1.online.tableau.com/javascripts/api/viz_v1.js'></script>
		<div class='tableauPlaceholder' style='width: 1000px; height: 650px;' align="center">
			<object class='tableauViz' width='1000' height='650' style='display:none;'>
				<param name='host_url' value='https%3A%2F%2Fus-east-1.online.tableau.com%2F' /> 
				<param name='embed_code_version' value='2' /> 
				<param name='site_root' value='&#47;t&#47;divyavajja' />
				<param name='name' value='SWE632&#47;SWE437' />
				<param name='tabs' value='no' />
				<param name='toolbar' value='no' />
				<param name='showAppBanner' value='false' />
				<param name='showShareOptions' value='false' />
			</object>
		</div>
		
		
		<div class="panel panel-default">
      	<div class="panel-heading" align="center">Reviews</div>
        <div class="panel-body" style="max-height:200px;overflow-y: scroll;">
              <div class="media">
              <div class="media-left">
                <img src="viet-linkedin-pic.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                <a class="media-heading" href="https://www.linkedin.com/in/viet-tran-272570108/" target="_blank">Viet Tran - Student - SWE</a>
                <p>Dr. Ammann is knowledgeable in software testing, and you will learn quite a bit from him. There are weekly quizzes, and homeworks. 
                Required to read textbook. Some of material can be confusing - most learning done in class activities. Final exam was more challenging than weekly quizzes, however not insurmountable. Would recommend Dr. Amman Great guy</p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="imgs.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                 <a class="media-heading" href="http://www.linkedin.com/in/divya-vajja-ab80a478" target="_blank">Krishna Vemuri - Student - CS</a>
                <p>He's a nice professor who gaves in-class execises to prepare quizs. 12 quizzes drop 3 lowest. Hws are every week like quizzes. 
                Fortunately, you can have 2 partners for hw. Easy class as long as you follow up with the in class exercise. 
                The final is a little tough. I didn't copy down terms on cheat sheet. So I lost 660 on the final. Speak so low.</p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="imgn.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                 <a class="media-heading" href="#" target="_blank">Sameera Bammidi - Student - INFS</a>
                <p>Terribly banal, overcomplicates trivial topics, and forces you to attend his useless lectures. 
                Attendance is mandatory and you will lose tons of points if you don't attend because of participation 
                points and these god-awful weekly quizzes he gives even though this is a 400 level course.</p>
              </div>
              </div>
              <hr>
        </div>
     	</div>
    
 
		<div align="center">
		<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span> Add Class to Cart</button>
	  	<button type="button" class="btn btn-primary">Back to Class Suggestions</button>
		</div>

	
	</div>
	</div>	

</body>



</html>