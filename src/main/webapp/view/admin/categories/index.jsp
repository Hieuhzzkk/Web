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
	<form method="POST" action="/hhh/categories/store">
			<div class="container">
				<div class="row mt-3 pt-2">
					<div class="form-group mt-3">
						<label>Tên danh mục</label>
						<input type="text" name="ten" />
					</div>
					<div class="form-group mt-3">
						<label>Người tạo</label>
							<select name="user_id">
								<c:forEach items="${ dsUser }" var="user">
									<option value="${ user.id }">${ user.hoTen }</option>
								</c:forEach>
							</select>
					</div>
					<div class="form-group mt-3">
						<button class="btn btn-primary">Thêm mới</button>
					</div>
				</div>				
					<table class="table mt-3">
						<thead class="table-black">
							<tr>
								<th>Tên danh mục</th>
								<th>Người tạo</th>
								<th colspan="2">Thao tac</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ dscate }" var="cate">
								<tr>
									<td>${ cate.ten }</td>
									<td>${ cate.user.hoTen }</td>
									<td><a class="btn btn-primary"
										href="/hhh/categories/edit?id=${cate.id }">Cập nhật</a></td>
									<td><a class="btn btn-danger" data-bs-toggle="modal"
										data-bs-target="#Delete${cate.id}"
										href="/hhh/categories/delete?id=${cate.id}">Xóa</a>
										<div class="modal fade" id="Delete${cate.id}" tabindex="-1"
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
															href="/hhh/categories/delete?id=${cate.id }">Xóa</a>
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
		</form>

	<script src="/hhh/js/jquery.min.js"></script>
	<script src="/hhh/js/popper.min.js"></script>
	<script src="/hhh/js/bootstrap.min.js"></script>
</body>
</html>