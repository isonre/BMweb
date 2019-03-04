package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.User;

public interface UserDao {

	User get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(User user);//����

	Integer save(User user);//���
	
	List findByNameAndPass(String identity, String u_pwd);
	
	List findByIdentity(String identity);
	
}
