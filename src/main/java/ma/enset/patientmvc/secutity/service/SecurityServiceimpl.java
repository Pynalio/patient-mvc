package ma.enset.patientmvc.secutity.service;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import ma.enset.patientmvc.secutity.entities.AppRole;
import ma.enset.patientmvc.secutity.entities.AppUser;
import ma.enset.patientmvc.secutity.repositories.AppRoleRepository;
import ma.enset.patientmvc.secutity.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Slf4j
//log des infos
@AllArgsConstructor
@Transactional
public class SecurityServiceimpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder  passwordencoder;



    @Override
    public AppUser saveUser(String username, String password, String rePassword) {
        if(!password.equals(rePassword)) throw new RuntimeException("Passwords not match");
        String hashedPWD=passwordencoder.encode(password);
        AppUser appUser=new AppUser();
        //generer une chaine de caractere aleatoire qui depend de la date system (unique)
        appUser.setUserid(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        AppUser savedAppUser= appUserRepository.save(appUser);


        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {

        AppRole appRole=appRoleRepository.findByRoleName(roleName);

        if(appRole!=null) throw new RuntimeException("Role"+roleName+"already exist");

        appRole=new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
       AppRole saveAppRole1= appRoleRepository.save(appRole);



        return saveAppRole1;
    }

    @Override
    public void addRoleToUser(String username, String rolename) {

        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException("user not found");
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        //ajouter a la liste des roles apres ajouter le role
        if(appRole==null) throw new RuntimeException("Role not found");

         appUser.getAppRoles().add(appRole);

    }

    @Override
    public void removeRoleFromUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException("user not found");
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        //ajouter a la liste des roles apres ajouter le role
        if(appRole==null) throw new RuntimeException("Role not found");

        appUser.getAppRoles().remove(appRole);

    }

    @Override
    public AppUser loadUserByUserName(String username) {



        return appUserRepository.findByUsername(username);
    }
}
