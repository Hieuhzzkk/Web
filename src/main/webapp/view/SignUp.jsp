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
<form method="POST" action="/hhh/users/store">
       <div>
           <label>Name: </label>
           <input type="text" name="hoTen">
       </div>
       <div>
           <label>Dia chi: </label>
           <input type="text" name="diaChi">
       </div>
       <div>
           <label>Email</label>
           <input type="email" name="email">
       </div>
       <div>
           <label>Password</label>
           <input type="password" name="password">
       </div>
       <div>
           <label>PhoneNumber: </label>
           <input type="number" name="sdt">
       </div>
      <div>
      	<label>Avatar</label>
      	  <input type="text" name="avatar">
      </div>
       <button>Submit</button>
   </form>
	<script src="/hhh/js/jquery.min.js"></script>
	<script src="/hhh/js/popper.min.js"></script>
	<script src="/hhh/js/bootstrap.min.js"></script>
</body>
</html>