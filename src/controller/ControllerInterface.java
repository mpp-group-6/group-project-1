package controller;

import java.util.List;

import dataaccess.exception.InvalidCredentials;
import dataaccess.exception.UserNotFound;

public interface ControllerInterface {
	public void login(String id, String password) throws UserNotFound, InvalidCredentials;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public boolean saveLibraryMember(String fName,String lName,String phone,String street,String city,String state,String zip);
}
