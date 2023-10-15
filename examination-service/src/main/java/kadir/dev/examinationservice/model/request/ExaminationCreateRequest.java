package kadir.dev.examinationservice.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kadir.dev.examinationservice.entity.Doctor;
import kadir.dev.examinationservice.model.dto.DoctorDto;
import kadir.dev.examinationservice.model.dto.PatientDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationCreateRequest {

    @NotBlank
    private String description;
    @NotNull
    private DoctorDto doctor;
    @NotNull
    private PatientDto patient;

}
