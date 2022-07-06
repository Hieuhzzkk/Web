<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">
			${ sessionScope.message }
	</div>
	
	<c:remove var="message" scope="session"/>
</c:if>
<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">
			${ sessionScope.error }
	</div>
	
		<c:remove var="error" scope="session"/>	
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/hhh/css/bootstrap.min.css" />
</head>
<body>


	<form method="POST" action="/hhh/users/store">
       <div class="mb-3">
           <label>Name: </label>
           <input class="form-control" type="text" name="hoTen">
       </div>
       <div class="mb-3">
           <label>Dia chi: </label>
           <input class="form-control" type="text" name="diaChi">
       </div>
       <div class="mb-3">
           <label>Email</label>
           <input class="form-control" type="email" name="email">
       </div>
       <div class="mb-3">
           <label>Password</label>
           <input class="form-control" type="password" name="password">
       </div>
       <div class="mb-3">
           <label>PhoneNumber: </label>
           <input class="form-control" type="number" name="sdt">
       </div>
      <div class="mb-3">
      	  <label>Avatar</label>
      	  <input class="form-control" type="text" name="avatar">
      </div>
      <div class="mb-3">
      	  <label>Vai trò</label>
      	  <input class="form-control" type="text" name="vaiTro">
      </div>
       <button class="btn btn-primary">Submit</button>
   </form>
   <c:if test="${ !empty ds }">
   <c:if test="${ empty ds }">
	<p class="alert alert-warning">Khong co du lieu</p>
</c:if>
	<table class="table">
		<thead class="table-dark">
			<th>Họ tên</th>
			<th>SĐT</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th>Avatar</th>
			<th>Vai trò</th>
			<th colspan="2">Thao tac</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="user">
				<tr>
					<td>${ user.hoTen }</td>	
					<td>${ user.sdt }</td>
					<td>${ user.email }</td>
					<td>${ user.diaChi }</td>
					<td>${user.avatar }</td>
					<td>${ user.vaiTro }</td>
					<td>
						<a class="btn btn-primary" href="/hhh/users/edit?id=${user.id }">Cập nhật</a>
					</td>
					<td>
						<a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" href="/hhh/users/delete?id=${user.id }">Xóa</a>
						<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body">
							        Bạn có muốn xóa không ?
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							        <a  class="btn btn-danger" href="/hhh/users/delete?id=${user.id }">Xóa</a>
							      </div>
							    </div>
							  </div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

	<script src="/hhh/js/jquery.min.js"></script>
	<script src="/hhh/js/popper.min.js"></script>
	<script src="/hhh/js/bootstrap.min.js"></script>
</body>
</html>

