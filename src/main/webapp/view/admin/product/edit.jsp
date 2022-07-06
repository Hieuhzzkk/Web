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
	<form method="POST" action="/hhh/product/update?id=${ pro.id }">
		<div class="container">
			<div class="row mt-3 pt-2">
				<div class="form-group mt-3">
					<label>Tên sản phẩm: </label> <input value="${pro.ten }" name="ten"
						class="form-control" type="text">
				</div>
				<div class="form-group mt-3">
					<label>Loại sản phẩm: </label> 
					<select class="form-select" name="category_id" id="category_id">
						<option selected value="" disabled="disabled">Chọn loại sản phẩm</option>	
						<c:forEach items="${ categorise }" var="categorise">
							<c:choose>
								<c:when test="${categorise.id == pro.category.id}">
									<option selected value="${pro.category.id}">${pro.category.ten }</option>
								</c:when>
								<c:otherwise>
									<option value="${categorise.id}">${categorise.ten }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="form-group mt-3">
					<label>Số lượng: </label> <input value="${pro.soLuong }"
						name="soLuong" class="form-control" type="number">
				</div>
				<div class="form-group mt-3">
					<label>Giá: </label> <input value="${pro.donGia }" name="donGia"
						class="form-control" type="number">
				</div>
				<div class="form-group mt-3">
					<label>Màu sắc: </label> <input value="${pro.mauSac }"
						name="mauSac" class="form-control" type="text">
				</div>
				<div class="form-group mt-3">
					<label>Kích thước: </label> <select class="form-select"
						name="kichThuoc" id="kichThuoc">
							<option value="15 inch">15 inch</option>
							<option value="15.6 inch">15.6 inch</option>
							<option value="16 inch">16 inch</option>
					</select>
				</div>
				<div class="form-group mt-3">
					<label>Ảnh: </label> <input value="${pro.img }" name="img"
						class="form-control" type="file">
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