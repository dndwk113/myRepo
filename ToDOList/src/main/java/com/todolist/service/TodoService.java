package com.todolist.service;

import java.util.List;

import com.todolist.domain.TodoVO;


//느슨한 결합을 위해 인터페이스와 구현체를 별도로 작성
public interface TodoService {

	//사용자로부터 입력받는 서비스 단위
	
	//게시글 등록
	public void register(TodoVO board);
	
	//게시글 조회
	public TodoVO get(Long bno);
	
	//게시글 수정
	public boolean modify(TodoVO todo);
	
	//게시글 삭제
	public boolean remove(Long bno);
	
	//뭐더라??
	public List<TodoVO> getList();
	
}
