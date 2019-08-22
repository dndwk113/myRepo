package com.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.domain.TodoVO;
import com.todolist.mapper.TodoMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;


//느슨한 연결을 위해 인터페이스와 구현체를 별개로 작성

//@Service애너테이션이 해당 클래스가 서비스 계층임을 컨테이너에 통지한다

@Log
@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	@Setter(onMethod_ = {@Autowired})
	TodoMapper mapper;

	@Override
	public void register(TodoVO todo) {
		log.info("register======================="+todo);
		mapper.insertSelectKey(todo); //selectkey를 지정해야 로그에서 생성게시물 번호 조회 가능
	
	}
	//게시글 열람서비스. mapper의 조회기능을 사용하고, mapper의 read기능은 조회내용을 TodoVO객체형태로 반환한다.이를 그대로 return으로 내보낸다.
	@Override
	public TodoVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("==================================get : "+bno);
		
		return mapper.read(bno);
	}
	//게시글 수정 서비스
	@Override
	public boolean modify(TodoVO todo) {
		log.info("=================================modify : "+todo);
		return mapper.update(todo)==1;
	}
	//게시글 삭제 서비스. mapper.delete는 삭제된 레코드의 수를 반환하므로 1이면 true 반환.
	@Override
	public boolean remove(Long bno) {
		log.info("===================================remove : "+bno);
		return mapper.delete(bno)==1;
	}
	//게시글 목록 조회
	@Override
	public List<TodoVO> getList() {
		log.info("==================================getList");
		return mapper.getList();
	}
	
	
}
