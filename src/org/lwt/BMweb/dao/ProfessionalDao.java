package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.Professional;

public interface ProfessionalDao {

	Professional get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(Professional pro);//����

	Integer save(Professional pro);//���
	
	public List<Professional> getAllProfessional();//����ѧУid����ȫ����רҵ
}
