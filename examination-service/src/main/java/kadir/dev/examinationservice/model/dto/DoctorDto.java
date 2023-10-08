package kadir.dev.examinationservice.model.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DoctorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String branch;
    private Date createdDate;

}
