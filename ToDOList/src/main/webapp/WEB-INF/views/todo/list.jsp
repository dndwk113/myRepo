<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@include file="../includes/header.jsp" %>
  
  <script> var counter =0; </script>
        
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">ToDoList</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">		</div>
                        <button id='regBtn' type="button" class="btn btn-default" >새로운 일과 등록</button>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" >
                                    <thead>
                                        <tr>
                                            <th style="width:50px">번호 </th>
                                            <th style="width:80px">여유기간</th>
                                            <th style="width:70px">중요도</th>
                                            <th style="width:100px">관리번호</th>
                                            <th>업무목록</th>
                                            <th style="width:100px">작성자</th>
                                            <th style="width:100px">작성일</th>
                                            <th style="width:100px">수정일</th>
                                        </tr>
                                    </thead>
                                
                                <c:forEach items="${list}" var="todo">
                                	<tr>	
                                		<td><c:out value="${todo.bno}"/></td>
                                		
                                		<!--<fmt:formatDate pattern="dd" value="${todo.d_day}" var="dday"/> -->
                                		
                                		<c:set var="line" value="#{todo.d_day}"/>
                                		<fmt:parseNumber value="${line.getTime() / (24*60*60*1000)}" integerOnly="true" var = 'dtime' />
                                		<c:set var="now"  value="<%= new java.util.Date() %>" />
										<fmt:parseNumber value="${now.getTime() / (24*60*60*1000)}" integerOnly="true" var = 'present' />
										
										<td>D _ <c:out value="${dtime-present}"/>  </td>
                                		<td><c:out value="${todo.priorty}"/> </td>
                                		<td><c:out value="${todo.mngcode}" /> </td>
                                		<td><a href='/todo/get?bno=<c:out value="${todo.bno}"/>'><c:out value="${todo.title}" /></a></td>
                                		<td><c:out value="${todo.writer}" /> </td>
                                		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${todo.regdate}" /> </td>
                                		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${todo.updateDate}" /> </td>
                                	</tr>
                                <script>
                                $(document).ready(function() {
                                 	if(('<c:out value="${dtime-present}"/>') < 0){counter++;}
                                });
                                </script>
                                
                                </c:forEach>
                                </table> 
                                
                                
                                <!-- modal창 -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                           	<div class="modal-dialog">
                           		<div class="modal-content">
                           			<div class="modal-headder">
                           				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                           				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
                           			</div>
                           		<div class="modal-body">처리가 완료되었습니다</div>
                           		<div class="modal-footer">
                           			<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
                           			
                           		</div>
                           		</div>
                           		<!-- /.modal-content -->
                           	</div>
                           		<!-- /.modal-dialog -->
                           </div>
                           		<!-- /.modal -->   
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	
    	  	if(counter !=0) {alert(counter+'개의 지난 업무가 있습니다. 학인 후 기한을 연장하거나 게시글을 삭제해주세요');}    		
    		
    	    	
    	
    	var result = '<c:out value="${result}"/>';
    
		checkModal(result);
        
        history.replaceState({},null,null);
        
        function checkModal(result) {
        	if(result===''||history.state) {
        		return;
        	}
        
        if(parseInt(result)> 0) {
        	$(".modal-body").html("게시글"+parseInt(result)+" 번이 등록되었습니다.");
        }
        	$("#myModal").modal("show");
        }
        
        	$('#regBtn').on("click", function(){
        		self.location ="/todo/register";
        	});
    });
    </script>    
    
    <%@include file="../includes/footer.jsp" %>
