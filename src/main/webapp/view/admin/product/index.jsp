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
<div class="container">		
		<form method="POST" action="/hhh/product/store">
			<div class="container">
				<div class="row mt-3 pt-2">
					<div class="form-group mt-3">
						<label>Tên sản phẩm: </label> <input 
							name="ten" class="form-control" type="text">
					</div>
					<div class="form-group mt-3">
						<label>Loại sản phẩm: </label> <select class="form-select"
							name="category_id" id="category_id">
							<option selected value="" disabled="disabled">Chọn loại
								sản phẩm</option>
							<c:forEach items="${ dscate }" var="category">
								<option value="${ category.id }">${ category.ten }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group mt-3">
						<label>Số lượng: </label> <input 
							name="soLuong" class="form-control" type="number">
					</div>
					<div class="form-group mt-3">
						<label>Giá: </label> <input name="donGia"
							class="form-control" type="number">
					</div>
					<div class="form-group mt-3">
						<label>Màu sắc: </label> <input
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
						<label>Ảnh: </label> <input name="img"
							class="form-control" type="file">
					</div>
					<div class="form-group mt-3">
						<button class="btn btn-primary">Thêm mới</button>
					</div>
				</div>

				
				<c:if test="${empty dspro }">
					<p class="alert alert-warning">Khong co du lieu</p>
				</c:if>
				<c:if test="${!empty dspro }">
					<table class="table mt-3">
						<thead class="table-black">
							<tr>
								<th>Tên sản phẩm</th>
								<th>Loại sản phẩm</th>
								<th>Số lượng</th>
								<th>Đơn giá</th>
								<th>Màu sắc</th>
								<th>Kích thước</th>
								<th>Ảnh</th>
								<th colspan="2">Thao tac</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ dspro }" var="pro">
								<tr>
									<td>${ pro.ten }</td>
									<td>${ pro.category.ten }</td>
									<td>${ pro.soLuong }</td>
									<td>${ pro.donGia }</td>
									<td>${ pro.mauSac }</td>
									<td>${ pro.kichThuoc }</td>
									<td>${ pro.img }</td>
									<td><a class="btn btn-primary"
										href="/hhh/product/edit?id=${pro.id }">Cập nhật</a></td>
									<td><a class="btn btn-danger" data-bs-toggle="modal"
										data-bs-target="#Delete${pro.id}"
										href="/hhh/product/delete?id=${pro.id}">Xóa</a>
										<div class="modal fade" id="Delete${pro.id}" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Message</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">Bạn có muốn xóa không ?</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">Close</button>
														<a class="btn btn-danger"
															href="/hhh/product/delete?id=${pro.id }">Xóa</a>
													</div>
												</div>
											</div>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</form>
	</div>
	<script src="/hhh/js/jquery.min.js"></script>
	<script src="/hhh/js/popper.min.js"></script>
	<script src="/hhh/js/bootstrap.min.js"></script>
</body>
</html>