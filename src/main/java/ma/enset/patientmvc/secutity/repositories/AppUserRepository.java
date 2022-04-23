package ma.enset.patientmvc.secutity.repositories;

import ma.enset.patientmvc.secutity.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {

     AppUser findByUsername(String username);
}
