package org.lwt.BMweb.dao;

import org.lwt.BMweb.model.Admin;

public interface AdminDao {

	Admin get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(Admin admin);//����

	Integer save(Admin admin);//����
}
