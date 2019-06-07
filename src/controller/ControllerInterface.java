package controller;

import java.util.List;

import exception.LoginException;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public boolean saveLibraryMember(String fName,String lName,String phone,String street,String city,String state,String zip);
}
