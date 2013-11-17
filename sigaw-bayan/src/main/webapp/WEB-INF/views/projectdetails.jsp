<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8" />
	<title>Innovex - Hackathon #kabantayngbayan</title>
	<meta name="description" content="Innovex - Hackathon #kabantayngbayan" />
	<meta name="author" content="Juan Dela Cruz" />
	<meta name="keyword" content="Innovex, Dashboard, Bootstrap" />
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link href="${pageContext.request.contextPath}/css/lib/bootstrap.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/lib/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/lib/style.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/lib/style-responsive.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/lib/retina.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" />
	
	<!-- end: CSS -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="${pageContext.request.contextPath}/css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="${pageContext.request.contextPath}/css/ie9.css" rel="stylesheet">
	<![endif]-->
	
	<!-- start: Favicon and Touch Icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/ico/apple-touch-icon-144-precomposed.png" />
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/ico/apple-touch-icon-114-precomposed.png" />
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/ico/apple-touch-icon-72-precomposed.png" />
	<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/ico/apple-touch-icon-57-precomposed.png" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/ico/favicon.png" />
	<!-- end: Favicon and Touch Icons -->	
		
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>
		<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a id="main-menu-toggle" class="hidden-phone open"><i class="icon-reorder"></i></a>		
				<div class="row-fluid">
				<a class="brand span2" href="${pageContext.request.contextPath}/index.html"><span>Innovex</span></a>
				</div>		
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
					
						
						<!-- end: Message Dropdown -->
						<li>
							<a class="btn" href="#">
								<i class="icon-wrench"></i>
							</a>
						</li>
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn account dropdown-toggle" data-toggle="dropdown" href="#">
								<div class="avatar"><img src="img/avatar.jpg" alt="Avatar" /></div>
								<div class="user">
									<span class="hello">Welcome!</span>
									<span class="name">Juan Dela Cruz</span>
								</div>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
									
								</li>
								<li><a href="#"><i class="icon-user"></i> Profile</a></li>
								<li><a href="#"><i class="icon-cog"></i> Settings</a></li>
								<li><a href="#"><i class="icon-envelope"></i> Messages</a></li>
								<li><a href="${pageContext.request.contextPath}/login.html"><i class="icon-off"></i> Logout</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<!-- start: Header -->
	
		<div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				
				<div class="row-fluid actions">
													
					<input type="text" class="search span12" placeholder="..." />
				
				</div>	
				
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="${pageContext.request.contextPath}/home"><i class="icon-bar-chart"></i><span class="hidden-tablet"> Dashboard</span></a></li>	
						<li><a href="${pageContext.request.contextPath}/budgetgraph"><i class="icon-eye-open"></i><span class="hidden-tablet"> Budget Graph</span></a></li>
						<li><a href="${pageContext.request.contextPath}/chart"><i class="icon-dashboard"></i><span class="hidden-tablet"> Chart 2</span></a></li>
						<li><a href="${pageContext.request.contextPath}/chart"><i class="icon-lock"></i><span class="hidden-tablet"> Chart 3</span></a></li>
					</ul>
				</div>
			</div>
			<!-- end: Main Menu -->
						
			<!-- start: Content -->
			<div id="content" class="span10">
						
				<div class="row-fluid">
					<div id="project-details">
						<p>Project Description: ${projectDetail.description}</p>
						<p>Project Amount: ${projectDetail.amount}</p>
						
						<div>
							<form action="projectdetails/comment">
								<textarea id="comments" name="comment"rows="10"></textarea>
								<input id="saroNo" type="hidden" name="saroNo" value="${projectDetail.saro_no}" />
								<input id="region" type="hidden" name="region" value="${projectDetail.region}" />
								<a id="submit-comment" href="${pageContext.request.contextPath}/projectdetails/comment/${projectDetail.saro_no}/${projectDetail.region}/">Post</a>
							</form>
						</div>
						
					</div>
				</div>	
					
			</div>
			<!-- end: Content -->
				
				</div><!--/fluid-row-->
				
		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>
		
		<div class="clearfix"></div>
		
		<footer>
			<p>
				<span style="text-align:left;float:left">&copy; 2013 team awesome innovex</span>
				<span class="hidden-phone" style="text-align:right;float:right">Powered by: <a href="" alt="">Innovex</a></span>
			</p>

		</footer>
				
	</div><!--/.fluid-container-->

	<!-- start: JavaScript-->
		<script src="${pageContext.request.contextPath}/js/lib/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery-migrate-1.2.1.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery-ui-1.10.3.custom.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.ui.touch-punch.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/modernizr.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.cookie.js"></script>	
		<script src='${pageContext.request.contextPath}/js/lib/fullcalendar.min.js'></script>	
		<script src='${pageContext.request.contextPath}/js/lib/jquery.dataTables.min.js'></script>
		<script src="${pageContext.request.contextPath}/js/lib/excanvas.js"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery.flot.js"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery.flot.pie.js"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery.flot.stack.js"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery.flot.resize.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/lib/jquery.flot.time.js"></script>
		
		<script src="${pageContext.request.contextPath}/js/lib/jquery.chosen.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.uniform.min.js"></script>		
		<script src="${pageContext.request.contextPath}/js/lib/jquery.cleditor.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.noty.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.elfinder.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.raty.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.iphone.toggle.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.uploadify-3.1.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.gritter.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.imagesloaded.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.masonry.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.knob.modified.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.sparkline.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/counter.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/raphael.2.1.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/lib/justgage.1.0.1.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/jquery.autosize.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/retina.js"></script>
		<script src="${pageContext.request.contextPath}/js/lib/jquery.placeholder.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/lib/wizard.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/lib/core.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/charts.min.js"></script>	
		<script src="${pageContext.request.contextPath}/js/lib/custom.min.js"></script>
		<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCLfYBcvYL3bBIvHqFJIVp22IZsXRcbUQ&sensor=false"></script>
		<script src="${pageContext.request.contextPath}/js/common.js"></script>
		<script src="${pageContext.request.contextPath}/js/map.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>