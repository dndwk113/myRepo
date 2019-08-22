package com.todolist.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todolist.domain.TodoVO;
import com.todolist.mapper.TodoMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private TodoService service;
	
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	//서비스 구현 중, 새로운 게시글 등록 정상적인 연결 여부 확인
	@Ignore
	@Test
	public void testRegister() {
		TodoVO todo = new TodoVO();
		todo.setImportance(2L);
		todo.setPriorty(5L);
		todo.setMngcode("BEK#0008");
		todo.setD_day(new Date());
		todo.setTitle("베트남 미용시장 시장조사 보고서 작성");
		todo.setContent("ㅁㅁㅁ차장님 베트남 출장 후 베트남 시장보고서 작성 지시");
		todo.setWriter("이웅식 사원");
		
		service.register(todo);
		
		log.info("생성된 게시물의 번호 : "+todo.getBno());
		//bno가 2씩 증가한다. 왜지??. 우선 mapper의 selectkey로 입력되고 있다. TodoMapper.xmi값에서 nextval 중첩사용. 수정함[2019/05/16]
	}
	
	
	
	@Test
	public void testGetList() {
		service.getList().forEach(todo ->log.info(todo));
	}
	
	
	@Test
	public void testGet() {
		log.info(service.get(44L));
	}
	
	@Test
	public void testDelete() {
		log.info("remove result : " + service.remove(49L));
	}
	
	@Test
	public void testUpdate() {
		
		TodoVO todo = service.get(46L);
		
		if (todo == null) {return;}
		
		todo.setTitle("제목만 수정합니다");
		log.info("modify result : "+service.modify(todo));
	}
	
}//e_class
