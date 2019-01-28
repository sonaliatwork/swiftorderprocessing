package org.swift.order;


public class User {
	private String userId;
	private String userRole;
	private String userName;
	private String userDepartment;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRole=" + userRole + ", userName=" + userName + ", userDepartment="
				+ userDepartment + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

}