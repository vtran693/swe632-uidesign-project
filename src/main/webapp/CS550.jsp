<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE = edge,chrome = 1" />
<title>CS 550 class details</title>

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
		<div class='tableauPlaceholder' style='width: 1100px; height: 650px;' align="center">
			<object class='tableauViz' width='1100' height='650' style='display:none;'>
				<param name='host_url' value='https%3A%2F%2Fus-east-1.online.tableau.com%2F' /> 
				<param name='embed_code_version' value='2' /> 
				<param name='site_root' value='&#47;t&#47;divyavajja' />
				<param name='name' value='SWE632&#47;CS550' />
				<param name='tabs' value='no' />
				<param name='toolbar' value='no' />
				<param name='showAppBanner' value='false' />
				<param name='showShareOptions' value='false' />
			</object>
		</div>
		
		
   		<div class="panel panel-default">
      	<div class="panel-heading" align="center">Reviews</div>
        <div class="panel-body" style="max-height: 200px;overflow-y: scroll;">
              <div class="media">
              <div class="media-left">
                <img src="imgd.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                <a class="media-heading" href="http://www.linkedin.com/in/divya-vajja-ab80a478" target="_blank">Divya Vajja - Student - INFS</a>
                <p>He is tough. Despite all the things I've heard about him.I think it's a doable class.You just have to really understand the material to take the test.
				Go for his office hours, he helps a lot. Also, I read his slides and book before going to class and his lectures made more sense.</p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="imgn.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                 <a class="media-heading" href="https://www.linkedin.com/in/nuthanat/" target="_blank">Nuthana Tatineni - Student - CS</a>
                <p>Easy grading... if you put some effort you can get A for sure. She goes very slow in the class and as a result it is soooooooooo boring... her mid term and final were very good...
                 but her grading was very very easy... I suggest Dr. Lin's DBMS course to anyone over the other professors' DBMS course</p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="imgs.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                 <a class="media-heading" href="https://www.linkedin.com/in/krishna-sindhuri-vemuri-95b6b97b/" target="_blank">Krishna Vemuri - Student - CS</a>
                <p>Professor Lin is one of kind. She has a clear grading criteria. Always answered questions and gave good feedback. 
                I could have done a lot better, but messed up the final. But learn't a lot, taking this class. 
                Her assignments are confusing and take a lot of time. But they help you learn the material.</p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="viet-linkedin-pic.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                 <a class="media-heading" href="https://www.linkedin.com/in/viet-tran-272570108/" target="_blank">Viet Tran - Student - SWE</a>
                <p>Strict about no laptops or phones during class, he will call you out. All tests are one hour long, even the final! 
                Does not go deep into the math behind database theory, which i didn't mind. Teaches from slides that he developed, and are the primary study source. 
                boring class, material is well planned out,you learn a lot from the hw.</p>
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