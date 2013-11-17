<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8" />
	<title>SigawBayan - Login</title>
	<meta name="description" content="Hackathon" />
	<meta name="author" content="Innovex" />
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link href="css/lib/bootstrap.min.css" rel="stylesheet" />
	<link href="css/lib/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="css/lib/style.min.css" rel="stylesheet" />
	<link href="css/lib/style-responsive.min.css" rel="stylesheet" />
	<link href="css/lib/retina.css" rel="stylesheet" />
	<link href="css/common.css" rel="stylesheet" />
	<!-- end: CSS -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/lib/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="css/lib/ie9.css" rel="stylesheet">
	<![endif]-->
	
	<!-- start: Favicon and Touch Icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
	<link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
	<link rel="shortcut icon" href="ico/favicon.png" />
	<!-- end: Favicon and Touch Icons -->	
		
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>
		<div class="container-fluid-full">
		<div class="row-fluid">	
			<div class="row-fluid">
				<div class="login-box">
					<h2>Login to your account</h2>
					<form class="form-horizontal" action="<c:url value='j_spring_security_check'/>" method="post" />
						<fieldset>
							<input class="input-large span12" name="j_username" id="username" type="text" placeholder="type username" />
							<input class="input-large span12" name="j_password" id="password" type="password" placeholder="type password" />
							<div class="clearfix"></div>
							<button type="submit" class="btn btn-large btn-success span12">Sign In</button>
							</fieldset>	
					</form>
						
				</div>
			</div><!--/row-->
		</div><!--/fluid-row-->
	</div><!--/.fluid-container-->

	<!-- start: JavaScript-->
		<script src="js/lib/jquery-1.10.2.min.js"></script>
		<script src="js/lib/jquery-migrate-1.2.1.min.js"></script>	
		<script src="js/lib/jquery-ui-1.10.3.custom.min.js"></script>	
		<script src="js/lib/jquery.ui.touch-punch.js"></script>	
		<script src="js/lib/modernizr.js"></script>	
		<script src="js/lib/bootstrap.min.js"></script>	
		<script src="js/lib/jquery.cookie.js"></script>	
		<script src='js/lib/fullcalendar.min.js'></script>	
		<script src='js/lib/jquery.dataTables.min.js'></script>
		<script src="js/lib/excanvas.js"></script>
		<script src="js/lib/jquery.flot.js"></script>
		<script src="js/lib/jquery.flot.pie.js"></script>
		<script src="js/lib/jquery.flot.stack.js"></script>
		<script src="js/lib/jquery.flot.resize.min.js"></script>
		<script src="js/lib/jquery.flot.time.js"></script>
		
		<script src="js/lib/jquery.chosen.min.js"></script>	
		<script src="js/lib/jquery.uniform.min.js"></script>		
		<script src="js/lib/jquery.cleditor.min.js"></script>	
		<script src="js/lib/jquery.noty.js"></script>	
		<script src="js/lib/jquery.elfinder.min.js"></script>	
		<script src="js/lib/jquery.raty.min.js"></script>	
		<script src="js/lib/jquery.iphone.toggle.js"></script>	
		<script src="js/lib/jquery.uploadify-3.1.min.js"></script>	
		<script src="js/lib/jquery.gritter.min.js"></script>	
		<script src="js/lib/jquery.imagesloaded.js"></script>	
		<script src="js/lib/jquery.masonry.min.js"></script>	
		<script src="js/lib/jquery.knob.modified.js"></script>	
		<script src="js/lib/jquery.sparkline.min.js"></script>	
		<script src="js/lib/counter.min.js"></script>	
		<script src="js/lib/raphael.2.1.0.min.js"></script>
		<script src="js/lib/justgage.1.0.1.min.js"></script>	
		<script src="js/lib/jquery.autosize.min.js"></script>	
		<script src="js/lib/retina.js"></script>
		<script src="js/lib/jquery.placeholder.min.js"></script>
		<script src="js/lib/wizard.min.js"></script>
		<script src="js/lib/core.min.js"></script>
		<script src="js/lib/charts.min.js"></script>	
		<script src="js/lib/custom.min.js"></script>
		<script src="js/common.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>