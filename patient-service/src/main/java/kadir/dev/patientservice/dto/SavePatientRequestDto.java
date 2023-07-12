package kadir.dev.patientservice.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Builder
@Getter
public class SavePatientRequestDto {
    private long id;
    private String name;
    private String surname;
    private String tckNo;
    private String phoneNumber;
}
