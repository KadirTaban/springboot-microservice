package kadir.dev.examinationservice.model.dto;

import kadir.dev.examinationservice.entity.Doctor;
import lombok.Builder;

import java.util.Date;

@Builder
public class ExaminationDto {

    private long id;
    private String description;
    private Doctor doctor;
    private Date createdDate;
}
