package org.lwt.BMweb.dao;

import java.util.List;

import org.lwt.BMweb.model.Place;

public interface PlaceDao {

	Place get(Integer id);//����ĳ��
	
	int delete(int id);//ɾ��
	
	void update(Place place);//����

	Integer save(Place place);//���
	
	public List<Place> getAllPlace();//����ȫ��������
}
