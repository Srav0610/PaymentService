package com.OrderService.DTO;

import java.util.Objects;



public class UserDetails {
	private String userName;
	private String password;
	private String fristName;
	private String lastName;
	private String gender;
	private Integer age;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", password=" + password + ", fristName=" + fristName
				+ ", lastName=" + lastName + ", gender=" + gender + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, fristName, gender, lastName, password, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(age, other.age) && Objects.equals(fristName, other.fristName)
				&& Objects.equals(gender, other.gender) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
	
	
	
	


}
