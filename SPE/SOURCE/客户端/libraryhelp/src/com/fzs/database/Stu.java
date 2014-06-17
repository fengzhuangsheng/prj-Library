package com.fzs.database;

public class Stu {

	private Integer id;
	private String name;
	private String password;
	private String idcard;
	private String gender;
	private String academy;
	private String profession;
	private Integer grade;

	public Stu(Integer id, String name, String password, String idcard,
			String gender, String academy, String profession, Integer grade) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.idcard = idcard;
		this.gender = gender;
		this.academy = academy;
		this.profession = profession;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}
