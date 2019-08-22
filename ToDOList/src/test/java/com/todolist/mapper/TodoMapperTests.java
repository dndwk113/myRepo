package com.todolist.mapper;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todolist.domain.TodoVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {
	@Setter(onMethod_ =  @Autowired)
	private TodoMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(todo->log.info(todo));
	}
	
	//게시글 등록 테스트
	@Test
	public void testInsert() {
		TodoVO todo = new TodoVO();
		//객체에 값을 담아준다
		todo.setImportance(1L);
		todo.setPriorty(1L);
		todo.setMngcode("DOE#0001");
		todo.setD_day(new Date());
		todo.setTitle("오늘의 목표");
		todo.setContent("수업은 따라가는게 좋지 않을까??");
		todo.setWriter("이웅식");
		//insert로 값을 제출한다. TodoMapper.xml문의 insert조건에 맞춰 입력된다 [각각 #{변수명}에 삽입된다])
		mapper.insert(todo);
		//insert문의 결과를 콘솔창에서 반환한다
		log.info(todo);
	}
	
	//testInsertSelectKey는 우선 건너뛴다. 
	
	
	//조회 테스트.
	@Test
	public void testRead() {
		TodoVO todo = mapper.read(21L);
		log.info(todo);
	}
	
	@Test
	public void testDelete() {
		log.info("Delect Count : " + mapper.delete(6L));
	}
	@Test
	public void testUpdate() {
		TodoVO todo = new TodoVO();
		
		todo.setBno(50L);
		todo.setImportance(4L);//null값 으로 수정할 수 없다. 우선순위 등 옵션을 수정으로 제거하려면 어떻게 해야할까?
		todo.setPriorty(6L);
		todo.setMngcode("QWE#0001");
		todo.setD_day(new Date());
		todo.setTitle("동남아 뷰티 시장조사보고서");
		todo.setContent("가나다가나다");
		todo.setWriter("user00");
	
		int count = mapper.update(todo);
		log.info("update count :" + count);
	}
}
