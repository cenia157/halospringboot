<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
	
</script>
<link rel="stylesheet" href="admin/login/0.css/login.css" />
</head>

<body>
	<section class="container forms">
		<div class="form login">
		<div class="close-img-box"> <a href="HC"> <img alt="" src="admin/login/0.img/close.png"></a></div>
			<div class="form-content">
				<div class="logo-img-box">
				 <img alt="" src="admin/login/0.img/logo.png" class="logo-img">
				 <div class="logo-txt">ハロー</div>
				 </div>
				<header>Admin Login</header>
				<form action="LoginC" method="post">
				<div class="login-result">${result }</div>
					<div class="field input-field">
						<input required="required" name="id" placeholder="ID" class="input">
					</div>

					<div class="field input-field">
						<input type="password" name="pw" placeholder="Password" class="password">
						<i class='bx bx-hide eye-icon'></i>
					</div>


					<div class="field button-field">
						<button>Login</button>
					</div>
				</form>
			</div>
		</div>
	</section>

</body>
<!-- <script src="admin/login/0.js/login.js" type="text/javascript"></script> -->
</html>