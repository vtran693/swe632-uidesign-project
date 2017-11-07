<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE = edge,chrome = 1" />
<title>Hello World using Backbone.js</title>

<!-- ========= -->
<!-- Stylesheets -->
<!-- ========= -->
<link rel="stylesheet" th:href="@{/css/bootstrap-theme.min.css}" />
<link rel="stylesheet" th:href="@{/css/bootstrap.min.css}" />
<link rel="stylesheet" th:href="@{/css/docs.css}" />
<link rel="stylesheet" th:href="@{/css/font-awesome.css}" />
<link rel="stylesheet" th:href="@{/css/bootstrap-social.css}" />

<!-- ========= -->
<!-- Libraries -->
<!-- ========= -->
<script th:src="@{/js/lib/jquery-3.2.1.min.js}" type="text/javascript"></script>
<script th:src="@{/js/lib/bootstrap.min.js}" type="text/javascript"></script>
<script th:src="@{/js/lib/json2.js}" type="text/javascript"></script>
<script th:src="@{/js/src/index.js}" type="text/javascript"></script>

</head>

<body>
	<!-- ========= -->
	<!-- Your HTML -->
	<!-- ========= -->
	
	<jsp:include page="/fixed-navbar.jsp" />
	
	<div class="container">
	<div>
	<h3>Class Registration and Suggestions</h3>h3>
	<a href="#">
    	<span class="glyphicon glyphicon-shopping-cart"></span>
    </a>
    </div>
	<p>We have analyzed your major and emphasis with completed courses.
	   Since you are only a part-time student, we suggest taking only two classes per semester.
	   Below is our class suggestion for Spring 2018.
	</p>

	<div class="panel-group">
	
		<div class="panel panel-default">
		<div class="panel-heading">Emphasis Courses</div>
		<div class="panel-body">
		<p>Since you took SWE 642 and SWE 621 we suggest:</p>
		<a href="#">SWE 645 - Component-Based Software Development</a>
		<a href="#">SWE 632 - User Interface Design and Development</a>	
		</div>
		</div>
			
		<div class="panel panel-default">
		<div class="panel-heading">Elective Courses</div>
		<div class="panel-body">
		<p>Since you are interested in Machine Learning when taking CS 580, we suggest:</p>
		<a href="#">CS 782 - Machine Learning</a>
		<a href="#">CS 787 - Decision Guidance Systems</a>	
		</div>
		</div>

	</div>
	</div>
	
	
	

</body>



</html>