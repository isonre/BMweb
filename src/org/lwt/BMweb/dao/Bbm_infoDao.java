package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.Bbm_info;

public interface Bbm_infoDao {

	Bbm_info get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(Bbm_info bbminfo);//����

	Integer save(Bbm_info bbminfo);//���
	
	public List<Bbm_info> getAllBbm_info();//����ȫ���ı�����Ϣ
	
	List findByIdentity(String identity);
}
