package com.todolist.service;

import java.util.List;

import com.todolist.domain.TodoVO;


//������ ������ ���� �������̽��� ����ü�� ������ �ۼ�
public interface TodoService {

	//����ڷκ��� �Է¹޴� ���� ����
	
	//�Խñ� ���
	public void register(TodoVO board);
	
	//�Խñ� ��ȸ
	public TodoVO get(Long bno);
	
	//�Խñ� ����
	public boolean modify(TodoVO todo);
	
	//�Խñ� ����
	public boolean remove(Long bno);
	
	//������??
	public List<TodoVO> getList();
	
}
