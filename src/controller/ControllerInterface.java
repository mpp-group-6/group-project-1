package controller;

import java.util.List;

import dataaccess.exception.InvalidCredentials;
import dataaccess.exception.UserNotFound;

public interface ControllerInterface {
	public void login(String id, String password) throws UserNotFound, InvalidCredentials;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	
}
