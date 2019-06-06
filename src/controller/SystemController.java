package controller;

import java.util.ArrayList;
import java.util.List;
import business.User;
import business.value.Permission;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.dao.UserRepository;
import dataaccess.exception.InvalidCredentials;
import dataaccess.exception.UserNotFound;

public class SystemController implements ControllerInterface {
	public static List<Permission> currentAuth = null;
	public static User currentUser = null;
	private static Integer USER_MATCHED = 1;
	private static Integer INVALID_INPUT = 0;
	private static Integer INVALID_CRED = 2;
	
	public void login(String userId, String password) throws UserNotFound, InvalidCredentials{
	    currentUser = UserRepository.getuser(userId, password);
        currentAuth = currentUser.getAuthorization();
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
