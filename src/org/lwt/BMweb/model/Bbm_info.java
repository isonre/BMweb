package org.lwt.BMweb.model;

public class Bbm_info {
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public Shool getShool() {
		return shool;
	}
	public void setShool(Shool shool) {
		this.shool = shool;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Professional getPro_1() {
		return pro_1;
	}
	public void setPro_1(Professional pro_1) {
		this.pro_1 = pro_1;
	}
	public Professional getPro_2() {
		return pro_2;
	}
	public void setPro_2(Professional pro_2) {
		this.pro_2 = pro_2;
	}
	public Professional getPro_3() {
		return pro_3;
	}
	public void setPro_3(Professional pro_3) {
		this.pro_3 = pro_3;
	}
	public Professional getPro_4() {
		return pro_4;
	}
	public void setPro_4(Professional pro_4) {
		this.pro_4 = pro_4;
	}

	private int b_id;
	private String identity;//���֤

	//־Ը
	private Shool shool;
	
	//רҵ
	private Professional pro_1;
	private Professional pro_2;
	private Professional pro_3;
	private Professional pro_4;	
}
