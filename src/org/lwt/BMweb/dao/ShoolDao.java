package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.Shool;

public interface ShoolDao {

	Shool get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(Shool shool);//����

	Integer save(Shool shool);//���
	
	public List<Shool> getAllShool();//����ȫ��������
}
