package ma.enset.patientmvc.secutity.repositories;

import ma.enset.patientmvc.secutity.entities.AppRole;
import ma.enset.patientmvc.secutity.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {

     AppRole findByRoleName(String roleName);
}
