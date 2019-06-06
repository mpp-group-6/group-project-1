package dataaccess.dao;

import java.util.Map;

import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import exception.LibraryMemberNotFound;

public class LibraryMemberRepository
{
    final static DataAccess dbAccess;
    
    final static Map<String, LibraryMember> libraryMembersMap;
    
    static {
        dbAccess = new DataAccessFacade();
        libraryMembersMap = dbAccess.readMemberMap();
    }
    
    public static LibraryMember getMember(String memberId) throws LibraryMemberNotFound {
        LibraryMember member = libraryMembersMap.get(memberId);
        if(member == null)
            throw new LibraryMemberNotFound();
        return member;
    }
    
    public static void updateMember(LibraryMember member) {
        dbAccess.updateMember(member);                     
    }
}
