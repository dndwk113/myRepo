<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Todo Register</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="pannel-default">
			<div class="pannel-heading">Todo Register</div>
			<div class="pannel-body">
				<form role="form" action="/todo/register" method="post" accept-charset="UTF-8">
					<div class="form-group">
					<label>제목</label> <input class="form-controll" name='title'>
					</div>
					
					<div class="form-group">
					<label>중요도</label> <input class="form-controll" name='importance'>
					</div>
					
					<div class="form-group">
					<label>우선순위</label> <input class="form-controll" name='priorty'>
					</div>
					
					<div class="form-group">
					<label>관리번호</label> <input class="form-controll" name='mngcode'>
					</div>
					
					<div class="form-group">
					<label>마감기일</label> <input class="form-controll" name='d_day'>
					</div>
					
					<div class="form-group">
					<label>Text Area</label>
					<textarea class="form-control" rows="15" name='content' style="width:800px"></textarea>
					</div>
					
					<div class="form-group">
					<label>Writer</label><input class="form-control" name='writer' style="width:200px">
					</div>
					<button type="submit" class="btn btn-default">Submit Button</button>
                    <button type="reset"  class="btn btn-default">Reset Button</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>