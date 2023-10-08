package kadir.dev.examinationservice.model.dto;

import kadir.dev.examinationservice.entity.Doctor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ExaminationDto {

    private Long id;
    private String description;
    private Doctor doctor;
    private Date createdDate;
}
