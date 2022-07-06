<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/hhh/css/bootstrap.min.css" />

</head>
<body>
	<form method="POST" action="/hhh/Login">
	       
	       
	       <div class="container">
		<div class="row justify-content-center">
			<div class="col-md-7 col-lg-5">
				<div class="login-wrap p-4 p-md-5">
					<div class="icon d-flex align-items-center justify-content-center">
						<span class="fa fa-user-o"></span>
					</div>
					<h3 class="text-center mb-5">Sign In</h3>
					<form action="#" class="login-form">
						<div class="form-group">
							<input type="email" class="form-control rounded-left mb-5"
								placeholder="Username" name="email" required value="">
						</div>
						<div class="form-group d-flex">
							<input type="password" class="form-control rounded-left mb-5"
								placeholder="Password" name="password" required value="">
						</div>
						<div class="form-group">
							<button type="submit"
								class="form-control btn btn-primary rounded submit px-3">Login</button>
						</div>
						<div class="form-group d-md-flex">
							<div class="w-50 text-md-right mt-5">
								<a href="/ASM/views/Layout/LayoutDangKy.jsp">Bạn
									chưa có tài khoản</a>
							</div>
							<div class="w-50 text-md-right mt-5">
								<a href="#">Forgot Password?</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</form>
	<script src="/hhh/js/jquery.min.js"></script>
	<script src="/hhh/js/popper.min.js"></script>
	<script src="/hhh/js/bootstrap.min.js"></script>
</body>
</html>