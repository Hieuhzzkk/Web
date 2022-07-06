<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/hhh/css/bootstrap.min.css" />

</head>
<body>
	<form method="POST" action="/hhh/categories/update?id=${ cate.id }">
		<div class="container">
			<div class="row mt-3 pt-2">
				
				<div class="form-group mt-3">
					<label>Tên danh mục</label> <input value="${cate.ten }" type="text"
						name="ten" />
				</div>
				<div class="form-group mt-3">
					<label>Người tạo</label> <select name="user_id">
						<c:forEach items="${ dsUser }" var="user">
							<option value="${ user.id }">${ user.hoTen }</option>
						</c:forEach>	
					</select>
				</div>
				<div class="form-group mt-3">
					<button class="btn btn-primary">Cập nhật</button>
				</div>
			</div>
		</div>
	</form>

	<script src="/hhh/js/jquery.min.js"></script>
	<script src="/hhh/js/popper.min.js"></script>
	<script src="/hhh/js/bootstrap.min.js"></script>
</body>
</html>