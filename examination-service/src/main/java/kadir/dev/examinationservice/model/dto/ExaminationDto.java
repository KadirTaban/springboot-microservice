package kadir.dev.examinationservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ExaminationDto {

    private Long id;
    private String description;
    private DoctorDto doctor;
    private Date createdDate;

}
