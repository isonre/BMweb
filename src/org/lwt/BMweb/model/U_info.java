package org.lwt.BMweb.model;

import java.sql.Date;

public class U_info {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getGradShool() {
		return gradShool;
	}
	public void setGradShool(String gradShool) {
		this.gradShool = gradShool;
	}
	public Date getGradTime() {
		return gradTime;
	}
	public void setGradTime(Date gradTime) {
		this.gradTime = gradTime;
	}
	public String getGradCate() {
		return gradCate;
	}
	public void setGradCate(String gradCate) {
		this.gradCate = gradCate;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	//������Ϣ
	private int u_id;//id

	private String identity;//���֤
	private String name;//����
	private String sex;//�Ա�
	private Date birthday;//����
	private Nation nation;//����  �������
	private Place place ;//����  (���)
	private String political ;//������ò
	private String gradShool  ;//��ҵѧУ
	private Date gradTime ;//��ҵʱ��
	private String gradCate;//��������
	private String education;//ѧ��
	private String results;//�߿��ɼ�
	private String homeAddress;//���֤סַ

	//��ϵ��ʽ
	private String address;//ͨ�ŵ�ַ
	private String t_name;//������
	private String code;//�ʱ�
	private String telephone;//��ϵ�绰
	private String email;//����
	private String qq;//qq
	private String remarks;//��ע

	public U_info(){
		super();
	}
}
