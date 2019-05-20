package com.todolist.mapper;

import java.util.List;
import com.todolist.domain.TodoVO;

public interface TodoMapper {
	
	//@Select("select * from todolist where bno > 0") << xml로 sql문 통합관리하게 되었다
	//2.  DB로부터 값을 받아올 때 쓰는 용도
	public List<TodoVO> getList();
	
	//  DB에 신규레코드 삽입
	public void insert(TodoVO todo);
	
	//  DB에 신규 레코드 삽입(pk 지정)
	public void insertSelectKey(TodoVO todo);
	
	// pk를 이용한 레코드 조회
	public TodoVO read(Long bno);
	
	// pk를 이용한 레코드 삭제. 삭제된 레코드 수를 정수로 반환한다
	public int delete(Long bno);
	
	public int update(TodoVO todo);
}
