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
		<div class='tableauPlaceholder' style='width: 1000px; height: 450px;' align="center">
			<object class='tableauViz' width='1000' height='450' style='display:none;'>
				<param name='host_url' value='https%3A%2F%2Fus-east-1.online.tableau.com%2F' /> 
				<param name='embed_code_version' value='2' /> 
				<param name='site_root' value='&#47;t&#47;divyavajja' />
				<param name='name' value='SWE632&#47;SWE621' />
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
                <img src="imgn.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                <a class="media-heading" href="https://www.linkedin.com/in/nuthanat/" target="_blank">Nuthana Tatineni - Student - CS</a>
                <p>This is the advanced level class for software modeling. The professor is very thorough with each lesson and knowledgeable with the materials. 
                He meets up with each team individually to go through the diagrams in depth and discuss any changes he would like to see. 
                I recommend taking this class with him to learn about designing concurrent diagrams./p>
              </div>
              </div>
              <hr>
              <div class="media">
              <div class="media-left">
                <img src="imgd.jpg" class="media-object" style="width:60px">
              </div>
              <div class="media-body">
                 <a class="media-heading" href="http://www.linkedin.com/in/divya-vajja-ab80a478" target="_blank">Divya Vajja - Student - INFS</a>
                <p>Competent, but ... Boring! Very slow. Compare with other SWE courses, 621 teaches a lot less material. Useful for some software, but not all. 
                Easy material, but grade depends on teamates which can hurt you</p>
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