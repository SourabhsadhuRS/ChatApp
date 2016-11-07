package com.manage.user;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserManagement {
	static List<UserPOJO> data = new ArrayList<UserPOJO>();
	static Iterator<UserPOJO> itr = data.iterator();
	static String dirStorage = "D:/ChatApp";
	
	UserManagement(){
		System.out.println("========UserManagement=========");
	}
	
	public static boolean CheckUser(String id, String pwd, String session){
		System.out.println("========CheckUser=========");
		boolean retVal = false;
		if(data.size()==0) UserManagement.loadUser();
		for(int iter=0; iter<data.size(); iter++){
			if(id.equals(data.get(iter).getUsername())){
				if(pwd.equals(data.get(iter).getPwd())){
					retVal = true;
					data.get(iter).setSessionID(session);
					//exit for loop
					iter = data.size();
				}
			}
		}
		return retVal;
	}
	
	public static void loadUser(){
		System.out.println("=======New LoadUser=========");
			UserPOJO user = new UserPOJO();
			user.setUsername("1");
			user.setPwd("1");
			user.setSessionID("");
			data.add(user);
			UserManagement.createFolder(dirStorage+"/1");
	}
	
	public static boolean createUser(String user, String pwd, String session){
		boolean out=false;
		System.out.println("========CreateUser=========");
		if (data.size() != 0) {
			for (UserPOJO itr : data) {
				if (itr.getUsername().equals(user)) {
					System.out.println("User already exists");
				}
			}
		} else {
			UserPOJO newuser = new UserPOJO();
			newuser.setUsername(user);
			newuser.setPwd(pwd);
			newuser.setSessionID(session);
			data.add(newuser);
			out = true;
			createFolder(dirStorage + "/" + user);
		}
	return out;
//		deleteEntry();
	}
	
	public static void printUser(){
		
		System.out.println("========PrintUser=========");
		for(int iter=0; iter<data.size(); iter++){
			System.out.println("Name="+data.get(iter).getUsername()+"******Password="+data.get(iter).getPwd()+"******Session ID="+data.get(iter).getSessionID());
		}
	}

	public static void createFolder(String path){

		File folder = new File(path);
		System.out.println("======================createFolder Folder Create======================");
		if (folder.exists() && folder.isDirectory()) {
			System.out.println("Folder "+path+" is present");
		}else{
			new File(path).mkdir();
			System.out.println("Folder "+path+" is created");
		}
	}
	
}
