package kadir.dev.examinationservice.repository;

import kadir.dev.examinationservice.entity.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
