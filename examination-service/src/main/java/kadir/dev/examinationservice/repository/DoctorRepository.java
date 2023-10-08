package kadir.dev.examinationservice.repository;

import kadir.dev.examinationservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository <Doctor, Long > {

}
