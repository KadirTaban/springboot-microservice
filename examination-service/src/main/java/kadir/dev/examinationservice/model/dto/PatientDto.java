package kadir.dev.examinationservice.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PatientDto {
    private long id;
    private String name;
    private String surname;
    private String tckNo;
    private String phoneNumber;

}
