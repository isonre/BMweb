package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.Nation;

public interface NationDao {

	Nation get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(Nation nation);//����

	Integer save(Nation nation);//���
	
	public List<Nation> getAllNation();//����ȫ��������
}
