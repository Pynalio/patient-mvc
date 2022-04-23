package ma.enset.patientmvc.secutity.service;

import ma.enset.patientmvc.secutity.entities.AppRole;
import ma.enset.patientmvc.secutity.entities.AppUser;

public interface SecurityService  {

    AppUser saveUser(String username,String password,String rePassword );
    AppRole saveNewRole(String roleName,String description);

    void addRoleToUser(String username,String rolename);
    void removeRoleFromUser(String username,String rolename);
    AppUser loadUserByUserName(String username);

}
