package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import business.User;
import business.value.Permission;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import exception.LoginException;

public class SystemController implements ControllerInterface {
	public static List<Permission> currentAuth = null;
	public static User userConnected = null;
	
	public int login(String id, String password){
		
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			return 0;
			//throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		
		if(!passwordFound.equals(password)) {
			return 2;
			//throw new LoginException("Password incorrect");
		} 
		userConnected = map.get(id);	
		currentAuth = map.get(id).getAuthorization();
		return 1;
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	
}
