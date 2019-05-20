package com.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.domain.TodoVO;
import com.todolist.mapper.TodoMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;


//������ ������ ���� �������̽��� ����ü�� ������ �ۼ�

//@Service�ֳ����̼��� �ش� Ŭ������ ���� �������� �����̳ʿ� �����Ѵ�

@Log
@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	@Setter(onMethod_ = {@Autowired})
	TodoMapper mapper;

	@Override
	public void register(TodoVO todo) {
		log.info("register======================="+todo);
		mapper.insertSelectKey(todo); //selectkey�� �����ؾ� �α׿��� �����Խù� ��ȣ ��ȸ ����
	
	}
	//�Խñ� ��������. mapper�� ��ȸ����� ����ϰ�, mapper�� read����� ��ȸ������ TodoVO��ü���·� ��ȯ�Ѵ�.�̸� �״�� return���� ��������.
	@Override
	public TodoVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("==================================get : "+bno);
		
		return mapper.read(bno);
	}
	//�Խñ� ���� ����
	@Override
	public boolean modify(TodoVO todo) {
		log.info("=================================modify : "+todo);
		return mapper.update(todo)==1;
	}
	//�Խñ� ���� ����. mapper.delete�� ������ ���ڵ��� ���� ��ȯ�ϹǷ� 1�̸� true ��ȯ.
	@Override
	public boolean remove(Long bno) {
		log.info("===================================remove : "+bno);
		return mapper.delete(bno)==1;
	}
	//�Խñ� ��� ��ȸ
	@Override
	public List<TodoVO> getList() {
		log.info("==================================getList");
		return mapper.getList();
	}
	
	
}
