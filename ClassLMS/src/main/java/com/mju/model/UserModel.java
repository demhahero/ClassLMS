package com.mju.model;

public class UserModel {
	int id;
	String name;
	String password;
	
	public void setID(int id){
		this.id=id;
	}
	public void setUsername(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public int getID(){
		return id;
	}
	public String getUsername(){
		return name;
	}
	public String getPassword(){
		return password;
	}
}
