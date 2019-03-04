package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.U_info;

public interface U_infoDao {

	U_info get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(U_info uinfo);//����

	Integer save(U_info uinfo);//���
	
	public List<U_info> getAllU_info();//����ȫ�����û�������Ϣ
	
	List findByIdentity(String identity);
}
