package ma.enset.patientmvc;

import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    /*@Bean *///au demarrage execute cette methode
    CommandLineRunner commandLineRunner(PatientRepository p){
        return args ->{
           /* p.save(new Patient(null,"hassan",new Date(),false,555));
            p.save(new Patient(null,"Mohammed",new Date(),true,201));
            p.save(new Patient(null,"Yasmine",new Date(),false,211));
            p.save(new Patient(null,"hanane",new Date(),false,441));*/
            p.save(new Patient(null,"imane",new Date(),false,441));

            p.findAll().forEach(y ->{

            System.out.println(y.getNom());



        });

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }

}
