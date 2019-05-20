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
	
	//�Խñ� ��� �׽�Ʈ
	@Test
	public void testInsert() {
		TodoVO todo = new TodoVO();
		//��ü�� ���� ����ش�
		todo.setImportance(1L);
		todo.setPriorty(1L);
		todo.setMngcode("DOE#0001");
		todo.setD_day(new Date());
		todo.setTitle("������ ��ǥ");
		todo.setContent("������ ���󰡴°� ���� ������??");
		todo.setWriter("�̿���");
		//insert�� ���� �����Ѵ�. TodoMapper.xml���� insert���ǿ� ���� �Էµȴ� [���� #{������}�� ���Եȴ�])
		mapper.insert(todo);
		//insert���� ����� �ܼ�â���� ��ȯ�Ѵ�
		log.info(todo);
	}
	
	//testInsertSelectKey�� �켱 �ǳʶڴ�. 
	
	
	//��ȸ �׽�Ʈ.
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
		todo.setImportance(4L);//null�� ���� ������ �� ����. �켱���� �� �ɼ��� �������� �����Ϸ��� ��� �ؾ��ұ�?
		todo.setPriorty(6L);
		todo.setMngcode("QWE#0001");
		todo.setD_day(new Date());
		todo.setTitle("������ ��Ƽ �������纸��");
		todo.setContent("�����ٰ�����");
		todo.setWriter("user00");
	
		int count = mapper.update(todo);
		log.info("update count :" + count);
	}
}
