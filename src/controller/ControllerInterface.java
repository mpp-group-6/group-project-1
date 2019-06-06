package controller;

import java.util.List;

import exception.LoginException;

public interface ControllerInterface {
	public int login(String id, String password);
	public List<String> allMemberIds();
	public List<String> allBookIds();
	
}
