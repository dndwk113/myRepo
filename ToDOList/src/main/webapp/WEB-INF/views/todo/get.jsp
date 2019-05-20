<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Todo Read Page</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="pannel-default">
			<div class="pannel-heading">Todo Read Page</div>
			<div class="pannel-body">
				<form role="form" action="/todo/register" method="post" accept-charset="UTF-8">
					
					<div class="form-group">
					<label>Bno</label> <input class="form-controll" name='bno'
					 value='<c:out value="${todo.bno}"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
					<label>제목</label> <input class="form-controll" name='title' 		value='<c:out value="${todo.title}"/>' readonly="readonly">    
					</div>
					
					<div class="form-group">
					<label>중요도</label> <input class="form-controll" name='importance' 	value='<c:out value="${todo.importance}"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
					<label>우선순위</label> <input class="form-controll" name='priorty'		value='<c:out value="${todo.priorty}"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
					<label>관리번호</label> <input class="form-controll" name='mngcode'		value='<c:out value="${todo.mngcode}"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
					<label>마감기일</label> <input class="form-controll" name='d_day'		value='<c:out value="${todo.d_day}"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
					<label>Text Area</label>
					<textarea class="form-control" rows="15" name='content' style="width:800px" readonly="readonly"><c:out value="${todo.content}"/></textarea>
					</div>
					
					
                        
					
					<div class="form-group">
					<label>Writer</label>    <input class="form-controll" name='writer' value='<c:out value="${todo.writer}"/>' readonly="readonly">
                    </div>
					<button data-oper='modify' class="btn btn-default">
					<a href= "/todo/modify?bno=<c:out value="${todo.bno}"/>">Modify</a>
					</button>
					
                    <button data-oper='list'  class="btn btn-info">
                    <a href="/todo/list">List</a></button>
					
					
				</form>
			</div>
		</div>
	</div>
</div>
		<!--  <script type="text/javascript">
                  $(document).ready(function() {
                  	var operForm = $("#operForm");
                  	
                  	$("button[data-oper='modify']").on("click", function(e){
                  	operForm.attr("action","/todo/modify").submit();
                  		
                  	});
                  	
                  	$("button[data-oper='list']").on("click", function(e){
                  	    operForm.find("#bno").remove();
                  		operForm.attr("action","/todo/list")
                  		operForm.submit();
                  		});
                  });
		</script>
		-->
<%@include file="../includes/footer.jsp"%>