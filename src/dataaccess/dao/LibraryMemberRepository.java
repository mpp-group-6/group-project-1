package dataaccess.dao;

import java.util.Map;
import business.LibraryMember;
import exception.LibraryMemberNotFound;

public class LibraryMemberRepository extends ObjectRepository
{
    public static LibraryMember getMember(String memberId) throws LibraryMemberNotFound {
        Map<String, LibraryMember> libraryMembersMap = dbAccess.readMemberMap();
        LibraryMember member = libraryMembersMap.get(memberId);
        if(member == null)
            throw new LibraryMemberNotFound();
        return member;
    }
    
    public static void updateMember(LibraryMember member) {
        dbAccess.updateMember(member);                     
    }
}
