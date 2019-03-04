package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.Zbm_info;

public interface Zbm_infoDao {

	Zbm_info get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(Zbm_info zbminfo);//����

	Integer save(Zbm_info zbminfo);//���
	
	public List<Zbm_info> getAllZbm_info();//����ȫ���ı�����Ϣ
	
	List findByIdentity(String identity);
}
