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
	
	//���� ���� ��, ���ο� �Խñ� ��� �������� ���� ���� Ȯ��
	@Ignore
	@Test
	public void testRegister() {
		TodoVO todo = new TodoVO();
		todo.setImportance(2L);
		todo.setPriorty(5L);
		todo.setMngcode("BEK#0008");
		todo.setD_day(new Date());
		todo.setTitle("��Ʈ�� �̿���� �������� ���� �ۼ�");
		todo.setContent("����������� ��Ʈ�� ���� �� ��Ʈ�� ���庸�� �ۼ� ����");
		todo.setWriter("�̿��� ���");
		
		service.register(todo);
		
		log.info("������ �Խù��� ��ȣ : "+todo.getBno());
		//bno�� 2�� �����Ѵ�. ����??. �켱 mapper�� selectkey�� �Էµǰ� �ִ�. TodoMapper.xmi������ nextval ��ø���. ������[2019/05/16]
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
		
		todo.setTitle("���� �����մϴ�");
		log.info("modify result : "+service.modify(todo));
	}
	
}//e_class
