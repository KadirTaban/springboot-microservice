package kadir.dev.examinationservice.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Builder
public class DoctorDto {

    private long id;
    private String firstName;
    private String lastName;
    private String branch;
    private Date createdDate;
}
