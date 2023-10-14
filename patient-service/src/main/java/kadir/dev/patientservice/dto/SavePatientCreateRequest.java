package kadir.dev.patientservice.dto;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class SavePatientCreateRequest {
    private long id;
    private String name;
    private String surname;
    private String tckNo;
    private String phoneNumber;

}
