<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">수정 페이지</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="pannel-default">
			<div class="pannel-heading">내용을 변경하세요</div>
			<div class="pannel-body">
				<form role="form" action="/todo/modify" method="post" accept-charset="UTF-8">
					
					<div class="form-group">
					<label>Bno</label> <input class="form-controll" name='bno'
					 value='<c:out value="${todo.bno}"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
					<label>제목</label> <input class="form-controll" name='title' 		value='<c:out value="${todo.title}"/>'>    
					</div>
					
					<div class="form-group">
					<label>중요도</label> <input class="form-controll" name='importance' 	value='<c:out value="${todo.importance}"/>'>
					</div>
					
					<div class="form-group">
					<label>우선순위</label> <input class="form-controll" name='priorty'		value='<c:out value="${todo.priorty}"/>' >
					</div>
					
					<div class="form-group">
					<label>관리번호</label> <input class="form-controll" name='mngcode'		value='<c:out value="${todo.mngcode}"/>'>
					</div>
					
					<div class="form=group">
					<label>등록일</label>
					<input class="form-controll" name='d_day' value='<fmt:formatDate pattern="yyyy/MM/dd" value="${todo.d_day}"/>'>
                    </div> 
					
					<div class="form-group">
					<label>Text Area</label>
					<textarea class="form-control" rows="15" name='content' style="width:800px" ><c:out value="${todo.content}"/></textarea>
					</div>
					
					<div class="form=group">
					<label>등록일</label>
					<input class="form-controll" name='regdate' value='<fmt:formatDate pattern="yyyy/MM/dd" value="${todo.regdate}"/>' readonly="readonly">
                    </div>    
					
					<div class="form=group">
					<label>수정일</label>
					<input class="form-controll" name='updateDate' value='<fmt:formatDate pattern="yyyy/MM/dd" value="${todo.updateDate}"/>' readonly="readonly">
                    </div>
					
					
					<div class="form-group">
					<label>작성자</label>    <input class="form-controll" name='writer' value='<c:out value="${todo.writer}"/>' readonly="readonly">
                    </div>
					<button type="submit" data-oper='modify' class="btn btn-default">수정하기	</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">삭제	</button>
                    <button type="submit" data-oper='list'  class="btn btn-info">목록으로 돌아가기</button>
					
					
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
		 <script type="text/javascript">
                    $(document).ready(function(){
                    	
                    	var formObj = $("form");
                    	
                    	$('button').on("click", function(e){
                    	
                    		e.preventDefault();
                    		
                    		var operation = $(this).data("oper");
                    		
                    		console.log(operation);
                    		
                    		if(operation === 'remove'){
                    		formObj.attr("action", "/todo/remove");	
                    		}else if(operation === 'list'){
							self.location= "/todo/list";
							return;
                    		}
                    		formObj.submit();
                    		
                    	});
                    });
		</script>
		
		
<%@include file="../includes/footer.jsp"%>