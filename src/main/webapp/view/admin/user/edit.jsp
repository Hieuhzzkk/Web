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
	<form method="POST"
	action="/hhh/users/update?id=${ user.id }">
	<div class="mb-3">
		<label>Họ tên</label>
		<input class="form-control" type="text" name="hoTen" value="${ user.hoTen }" />
	</div>
	<div class="mb-3">
		<label>Địa chỉ</label>
		<input class="form-control" type="text" name="diaChi" value="${ user.diaChi }" />
	</div>
	<div class="mb-3">
		<label>SĐT</label>
		<input class="form-control" type="text" name="sdt" value="${ user.sdt }" />
	</div>
	<div class="mb-3">
		<label>Email</label>
		<input class="form-control" type="email" name="email" value="${ user.email }" />
	</div>
	<div class="mb-3">
		<label>Avatar</label>
		<input class="form-control" type="text" name="avatar" value="${ user.avatar }" />
	</div>
	<div>
		<button class="btn btn-primary">Cập nhật</button>
	</div>
	</form>
   
	<script src="/hhh/js/jquery.min.js"></script>
	<script src="/hhh/js/popper.min.js"></script>
	<script src="/hhh/js/bootstrap.min.js"></script>
</body>
</html>
