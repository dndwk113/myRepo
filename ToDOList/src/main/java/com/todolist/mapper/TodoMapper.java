package com.todolist.mapper;

import java.util.List;
import com.todolist.domain.TodoVO;

public interface TodoMapper {
	
	//@Select("select * from todolist where bno > 0") << xml�� sql�� ���հ����ϰ� �Ǿ���
	//2.  DB�κ��� ���� �޾ƿ� �� ���� �뵵
	public List<TodoVO> getList();
	
	//  DB�� �űԷ��ڵ� ����
	public void insert(TodoVO todo);
	
	//  DB�� �ű� ���ڵ� ����(pk ����)
	public void insertSelectKey(TodoVO todo);
	
	// pk�� �̿��� ���ڵ� ��ȸ
	public TodoVO read(Long bno);
	
	// pk�� �̿��� ���ڵ� ����. ������ ���ڵ� ���� ������ ��ȯ�Ѵ�
	public int delete(Long bno);
	
	public int update(TodoVO todo);
}
