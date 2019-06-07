package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import business.Address;
import business.Book;
import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.dao.LibraryMemberRepository;
import javafx.fxml.Initializable;


public class MemberController implements Initializable {
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean saveNewMember(String fName,String lName,String phone,String street,String city,String state,String zip){
		boolean returnedValue=true;
		String memberId=getMemberId();
		
		//Creating Address and Member objects
		Address adr=new Address(street,city,state,zip);
		LibraryMember libMember=new LibraryMember(memberId,fName,lName,phone,adr);		
		
		//Saving the member
		DataAccess da=new DataAccessFacade();
		da.saveNewMember(libMember);
		
		return returnedValue;
	}

	public String getMemberId() {
		int min=1;
		int max=2000;
		int id=(int)(Math.random()*((max-min)+1))+min;		
		return ""+id;
	}
	
	
	
}
